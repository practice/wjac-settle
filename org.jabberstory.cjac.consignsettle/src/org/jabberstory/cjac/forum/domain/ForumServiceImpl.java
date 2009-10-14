package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.security.AccessDeniedException;
import org.springframework.web.multipart.MultipartFile;

public class ForumServiceImpl implements ForumService {
	private ForumRepository forumRepository;
	private UserService userService;
	private OrganService organService;
	private ForumPermissionService forumPermissionService;

	public void setForumRepository(ForumRepository forumRepository) {
		this.forumRepository = forumRepository;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setOrganService(OrganService organService) {
		this.organService = organService;
	}

	@Override
	public ForumPost createPost(int forumId, String subject, String body, String userId, List<MultipartFile> files, boolean hidden) {
		return forumRepository.createPost(forumId, subject, body, userId, files, hidden);
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
		if (!forumPermissionService.hasReadPermission(getPost(postId)))
			throw new AccessDeniedException("You don't have enough permission to download");
		
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
		Forum forum = forumRepository.getForum(id);
		if (!forumPermissionService.hasReadPermission(forum))
			throw new AccessDeniedException("You don't have enough permission to read this message");
		return forum;
	}

	@Override
	public Forum createForum(String groupId, String forumType, String forumName) {
		return forumRepository.createForum(groupId, forumType, forumName);
	}

	@Override
	public List<Forum> getForumsFor(String userId) {
		String ownerGroupId = "public";
		User user = userService.getUser(userId);
		UserGroup userGroup = user.getUserGroup();
		if (userGroup == null)
			return forumRepository.findForumFor(ownerGroupId);
		if (userGroup.isOwner())
			ownerGroupId = userGroup.getGroupId();
		else if (userGroup.isSubject()) {
			List<Organ> organs = organService.getOrgans(userId, userGroup.getRole());
			if (organs.size() > 0) {
				ownerGroupId = organs.get(0).getOwnerGroup().getGroupId();
			}
		}
		return forumRepository.findForumFor(ownerGroupId);
	}

	@Override
	public List<Forum> getForumsForGroup(String groupId) {
		return forumRepository.findForumFor(groupId);
	}

	@Override
	public List<Forum> getForums(int page) {
		return forumRepository.getForums(page);
	}

	public void setForumPermissionService(ForumPermissionService forumPermissionService) {
		this.forumPermissionService = forumPermissionService;
	}

	@Override
	public void disableForum(UserGroup userGroup) {
		List<Forum> list = forumRepository.findForumFor(userGroup.getGroupId());
		for (Forum forum : list) {
			forum.setEnabled(false);
		}
	}

}
