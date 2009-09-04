package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ForumServiceImpl implements ForumService {
	private ForumRepository forumRepository;

	public void setForumRepository(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}

	@Override
	public ForumPost createPost(String subject, String body, String userId,
			MultipartFile file0, MultipartFile file1) {
		return forumRepository.createPost(subject, body, userId, file0, file1);
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
	public PostAttachment getPostAttachment(int postId, int attId) {
		return forumRepository.getPostAttachment(postId, attId);
	}

	@Override
	public List<ForumPost> getPosts(int page) {
		return forumRepository.getPosts(page);
	}

}
