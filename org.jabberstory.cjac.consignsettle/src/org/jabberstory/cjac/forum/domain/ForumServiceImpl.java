package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ForumServiceImpl implements ForumService {
	private ForumRepository forumRepository;

	public void setForumRepository(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}

	@Override
	public ForumPost createPost(String subject, String body, String userId, List<MultipartFile> files) {
		return forumRepository.createPost(subject, body, userId, files);
	}

	@Override
	public ForumPost createReply(int id, String subject, String body, String userId, List<MultipartFile> files) {
		return forumRepository.createReply(id, subject, body, userId, files);
	}

	@Override
	public Long getPageCount() {
		return forumRepository.getPageCount();
	}

	@Override
	public ForumPost getPost(int id) {
		return forumRepository.getPost(id);
	}

	@Override
	public List<ForumPost> getChildrenPosts(int id) {
		return forumRepository.getChildrenPosts(id);
	}

	@Override
	public PostAttachment getPostAttachment(int postId, int attId) {
		return forumRepository.getPostAttachment(postId, attId);
	}

	@Override
	public List<ForumPost> getTopLevelPosts(int page) {
		return forumRepository.getTopLevelPosts(page);
	}

	@Override
	public void updatePost(int id, String subject, String body) {
		forumRepository.updatePost(id, subject, body);
	}

}
