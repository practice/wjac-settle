package org.jabberstory.cjac.forum.domain;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.multipart.MultipartFile;

public class ForumRepository extends HibernateDaoSupport {
	private static boolean isUnix = true;
	static {
		String os = System.getProperty("os.name");
		isUnix = !os.contains("Windows");
	}
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#listPosts(int)
	 */
	@SuppressWarnings("unchecked")
	public List<ForumPost> getTopLevelPosts(int forumId, int page) {
		Forum forum = getForum(forumId);
//		String queryString = "from ForumPost post left join fetch post.user where post.rootId = 0 order by post.id desc";
		DetachedCriteria criteria = DetachedCriteria.forClass(ForumPost.class);
		criteria.add(Restrictions.eq("rootId", 0));
		// TODO 이렇게 하는거 맞나?
//		criteria.add(Restrictions.eq("forum", getForum(forumId)));
		DetachedCriteria forumCrit = criteria.createCriteria("forum", "f", CriteriaSpecification.INNER_JOIN);
		forumCrit.add(
			Restrictions.or(
				Restrictions.eq("id", forumId), 
				// 요청한 포럼과 같은 타입의 공용포럼을 선택하여야 한다.
				Restrictions.and(Restrictions.eq("forumType", forum.getForumType()), 
					Restrictions.eq("groupId", "public"))));
		criteria.addOrder(Order.desc("id"));
		criteria.createAlias("user", "u", CriteriaSpecification.LEFT_JOIN);
		return getHibernateTemplate().findByCriteria(criteria, ForumService.PAGESIZE * (page -1), ForumService.PAGESIZE);
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#getPageCount()
	 */
	@SuppressWarnings("unchecked")
	public Long getPageCount(int forumId) {
		final String queryString = "select count(p) from ForumPost p where p.rootId = 0 and (p.forum.id = :forumId or p.forum.groupId = 'public')";
		List result = getHibernateTemplate().findByNamedParam(queryString, "forumId", forumId);
		
		Long postCount = ((Number)result.get(0)).longValue();
		Long pageCount = postCount / ForumService.PAGESIZE;
		if (postCount % ForumService.PAGESIZE != 0)
			pageCount++;
		return pageCount;
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#savePost(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ForumPost createPost(int forumId, String subject, String body, String userId, List<MultipartFile> files) {
		ForumPost post = new ForumPost(subject, body, userService.getUser(userId));
		post.setForum(getForum(forumId));
		getHibernateTemplate().save(post);
		String saveDir = calcSaveDir(post);
		addAttachments(files, post, saveDir);
		saveFiles(files, saveDir);
		return post;
	}

	public Forum getForum(int forumId) {
		return (Forum) getHibernateTemplate().get(Forum.class, forumId);
	}

	public ForumPost createReply(int forumId, int id, String subject, String body, String userId, List<MultipartFile> files) {
		ForumPost post = new ForumPost(subject, body, userService.getUser(userId));
		getHibernateTemplate().save(post);
		String saveDir = calcSaveDir(post);
		addAttachments(files, post, saveDir);
		post.setDepth(post.getDepth() + 1);
		post.setRootId(id);
		post.setReplyCount(post.getReplyCount() + 1);
		post.setForum(getForum(forumId));
		saveFiles(files, saveDir);
		return post;
	}

	private void saveFiles(List<MultipartFile> files, String saveDir) {
		for (MultipartFile mpf : files) {
			try {
				if (isUnix) {
					createDir(ForumService.FILE_PREFIX_UNIX + saveDir);
					mpf.transferTo(new File(ForumService.FILE_PREFIX_UNIX + saveDir + "/" + mpf.getOriginalFilename()));
				}
				else {
					createDir(ForumService.FILE_PREFIX_WIN + saveDir);
					mpf.transferTo(new File(ForumService.FILE_PREFIX_WIN + saveDir + "/" + mpf.getOriginalFilename()));
				}
			} catch (IllegalStateException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private void addAttachments(List<MultipartFile> files, ForumPost post, String saveDir) {
		for (MultipartFile mpf : files) {
			PostAttachment attachment = new PostAttachment();
			attachment.setFilename(mpf.getOriginalFilename());
			attachment.setFilesize(mpf.getSize());
			attachment.setDir(saveDir);
			post.addAttachment(attachment);
		}
	}

	private void createDir(String path) {
		new File(path).mkdirs();
	}

	private String calcSaveDir(ForumPost post) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd/HH/");
		String path = dateFormatter.format(new Date());
		return path + post.getId();
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#getPost(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public ForumPost getPost(int id) {
		String queryString = "from ForumPost post left join fetch post.user left join fetch post.attachments where post.id = :id ";
		List<ForumPost> list = getHibernateTemplate().findByNamedParam(queryString, "id", id);
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<ForumPost> getChildrenPosts(int id) {
		String queryString = "select distinct post from ForumPost post left join fetch post.user left join fetch post.attachments where post.rootId = :id ";
		queryString += " order by post.id";
		return getHibernateTemplate().findByNamedParam(queryString, "id", id);
	}

	@SuppressWarnings("unchecked")
	public PostAttachment getPostAttachment(int postId, int attId) {
		String queryString = "from PostAttachment a where a.id = :attId and a.post.id = :postId";
		List list = getHibernateTemplate().findByNamedParam(queryString, 
				new String[] {"attId", "postId"}, 
				new Object[] {attId, postId});
		if (list.size() == 0)
			return null;
		return (PostAttachment)list.get(0);
	}

	public ForumPost updatePost(int id, String subject, String body) {
		ForumPost post = getPost(id);
		post.setSubject(subject);
		post.setBody(body);
		return post;
	}

	public void removePost(int id) {
		ForumPost post = getPost(id);
		getHibernateTemplate().delete(post);
		// TODO 파일도 삭제해야 함.
	}

	public boolean isUnix() {
		return isUnix;
	}

	public Forum createForum(String groupId, String forumType, String forumName) {
		Forum forum = new Forum(groupId, forumType, forumName);
		getHibernateTemplate().save(forum);
		return forum;
	}

	@SuppressWarnings("unchecked")
	public List<Forum> findForumFor(String groupId) {
		String query = "from Forum f where f.groupId = :groupId and f.enabled <> 'N'";
		return getHibernateTemplate().findByNamedParam(query, "groupId", groupId);
	}

	@SuppressWarnings("unchecked")
	public List<Forum> getForums(final int page) {
		final ArrayList<Forum> list = new ArrayList<Forum>();
		return (List<Forum>)getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String queryString = "from Forum f, UserGroup ug where f.groupId = ug.groupId and f.enabled <> 'N'";
				Query query = session.createQuery(queryString);
				// Don't honor page parameter. page calculation is done in controller. This is temporal !!! Sorry.
//				query.setFirstResult(ForumService.PAGESIZE * 3 * (page -1));
//				query.setMaxResults(ForumService.PAGESIZE * 3);
				List<Object[]> rs = query.list();
				for (Object[] forums : rs) {
					Forum forum = (Forum)forums[0];
					UserGroup ug = (UserGroup)forums[1];
					forum.getProp().put("userGroup", ug);
					list.add(forum);
				}
				return list;
			}
		});
	}

}
