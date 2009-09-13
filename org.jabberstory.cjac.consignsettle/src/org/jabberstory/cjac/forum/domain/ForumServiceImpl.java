package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ForumServiceImpl implements ForumService {
	private ForumRepository forumRepository;

	public void setForumRepository(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}

	@Override
	public ForumPost createPost(int forumId, String subject, String body, String userId, List<MultipartFile> files) {
		return forumRepository.createPost(forumId, subject, body, userId, files);
	}

	@Override
	public ForumPost createReply(int forumId, int id, String subject, String body, String userId, List<MultipartFile> files) {
		return forumRepository.createReply(forumId, id, subject, body, userId, files);
	}

	@Override
	public Long getPageCount(int forumId) {
		return forumRepository.getPageCount(forumId);
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
	public List<ForumPost> getTopLevelPosts(int forumId, int page) {
		return forumRepository.getTopLevelPosts(forumId, page);
	}

	@Override
	public ForumPost updatePost(int id, String subject, String body) {
		return forumRepository.updatePost(id, subject, body);
	}

	@Override
	public void removePost(int id) {
		forumRepository.removePost(id);
	}

	@Override
	public boolean isUnix() {
		return forumRepository.isUnix();
	}

	@Override
	public Forum getForum(int id) {
		return forumRepository.getForum(id);
	}

}
