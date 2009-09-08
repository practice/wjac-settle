package org.jabberstory.cjac.forum.domain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.multipart.MultipartFile;

public class ForumRepository extends HibernateDaoSupport {
	
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#listPosts(int)
	 */
	@SuppressWarnings("unchecked")
	public List<ForumPost> getTopLevelPosts(int page) {
//		String queryString = "from ForumPost post left join fetch post.user where post.rootId = 0 order by post.id desc";
		DetachedCriteria criteria = DetachedCriteria.forClass(ForumPost.class);
		criteria.add(Restrictions.eq("rootId", 0));
		criteria.addOrder(Order.desc("id"));
		criteria.createAlias("user", "u", CriteriaSpecification.LEFT_JOIN);
		return getHibernateTemplate().findByCriteria(criteria, ForumService.PAGESIZE * (page -1), ForumService.PAGESIZE);
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#getPageCount()
	 */
	@SuppressWarnings("unchecked")
	public Long getPageCount() {
		List result = getHibernateTemplate().find("select count(p) from ForumPost p where p.rootId = 0 ");
		
		Long postCount = ((Number)result.get(0)).longValue();
		Long pageCount = postCount / ForumService.PAGESIZE;
		if (postCount % ForumService.PAGESIZE != 0)
			pageCount++;
		return pageCount;
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#savePost(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ForumPost createPost(String subject, String body, String userId, List<MultipartFile> files) {
		ForumPost post = new ForumPost(subject, body, userService.getUser(userId));
		saveAttachments(files, post);
		getHibernateTemplate().save(post);
		return post;
	}

	public ForumPost createReply(int id, String subject, String body, String userId, List<MultipartFile> files) {
		ForumPost post = new ForumPost(subject, body, userService.getUser(userId));
		saveAttachments(files, post);
		post.setDepth(post.getDepth() + 1);
		post.setRootId(id);
		post.setReplyCount(post.getReplyCount() + 1);
		getHibernateTemplate().save(post);
		return post;
	}

	private void saveAttachments(List<MultipartFile> files, ForumPost post) {
		for (MultipartFile mpf : files) {
			try {
				mpf.transferTo(new File(ForumService.FILE_PREFIX + mpf.getOriginalFilename()));
			} catch (IllegalStateException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			PostAttachment attachment = new PostAttachment();
			attachment.setFilename(mpf.getOriginalFilename());
			attachment.setFilesize(mpf.getSize());
			post.addAttachment(attachment);
		}
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
	}

}
