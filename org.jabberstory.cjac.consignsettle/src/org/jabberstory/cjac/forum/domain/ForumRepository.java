package org.jabberstory.cjac.forum.domain;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
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
	public List<ForumPost> getPosts(int page) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ForumPost.class);
		criteria.addOrder(Order.desc("id"));
		return getHibernateTemplate().findByCriteria(criteria, ForumService.PAGESIZE * (page -1), ForumService.PAGESIZE);
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#getPageCount()
	 */
	@SuppressWarnings("unchecked")
	public Long getPageCount() {
		List result = getHibernateTemplate().find("select count(a) from ForumPost a");
		
		Long postCount = ((Number)result.get(0)).longValue();
		Long pageCount = postCount / ForumService.PAGESIZE;
		if (postCount % ForumService.PAGESIZE != 0)
			pageCount++;
		return pageCount;
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#savePost(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ForumPost createPost(String subject, String body, String userId, List<MultipartFile> files) 
		throws IllegalStateException, IOException {
		ForumPost post = new ForumPost(subject, body, userService.getUser(userId));
		for (MultipartFile mpf : files) {
			mpf.transferTo(new File(ForumService.FILE_PREFIX + mpf.getOriginalFilename()));
			PostAttachment attachment = new PostAttachment();
			attachment.setFilename(mpf.getOriginalFilename());
			attachment.setFilesize(mpf.getSize());
			post.addAttachment(attachment);
		}
		getHibernateTemplate().save(post);
		return post;
	}

	/* (non-Javadoc)
	 * @see org.jabberstory.toy.forum.ForumService#getPost(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public ForumPost getPost(int id) {
		String queryString = "from ForumPost post left join fetch post.user left join fetch post.attachments where post.id = :id";
		List<ForumPost> list = getHibernateTemplate().findByNamedParam(queryString, "id", id);
		if (list.size() > 0) {
			ForumPost post = (ForumPost) list.get(0);
//			post.getAttachments();
			return post;
		}
		else
			return null;
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

}
