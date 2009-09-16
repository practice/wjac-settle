package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ForumService {

	public static final String FILE_PREFIX_WIN = "D:/temp/cjac/forum/";
	public static final String FILE_PREFIX_UNIX = "/home/rnd/forum/";
	
	public static final int PAGESIZE = 10;

	public List<Forum> getAllForums();
	public Forum getForum(int id);
	public ForumPost getPost(int id);
	public List<ForumPost> getChildrenPosts(int id);
	public List<ForumPost> getTopLevelPosts(int forumId, int page);
	public Long getPageCount(int forumId);
	public ForumPost createPost(int forumId, String subject, String body, String userId, List<MultipartFile> files);
	public PostAttachment getPostAttachment(int postId, int attId);
	public ForumPost createReply(int forumId, int id, String subject, String body, String userId, List<MultipartFile> files);
	public ForumPost updatePost(int id, String subject, String body);
	public void removePost(int id);
	public boolean isUnix();
	public Forum createForum(String groupId, String forumType, String forumName);
	public List<Forum> getForumsFor(String userId);
}