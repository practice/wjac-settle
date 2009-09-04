package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ForumService {

	public static final String FILE_PREFIX = "C:/temp/simpleforum/";
	public static final int PAGESIZE = 5;

	public ForumPost getPost(int id);
	public List<ForumPost> getPosts(int page);
	public Long getPageCount();
	public ForumPost createPost(String subject, String body, String userId, MultipartFile multipartFile, MultipartFile multipartFile2);
	public PostAttachment getPostAttachment(int postId, int attId);
}