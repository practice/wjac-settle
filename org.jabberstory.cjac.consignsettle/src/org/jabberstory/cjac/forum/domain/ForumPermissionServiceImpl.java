package org.jabberstory.cjac.forum.domain;

import java.util.List;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;

public class ForumPermissionServiceImpl implements ForumPermissionService {
	
	private ForumService forumService;
	
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@Override
	public boolean hasModificationPermission(ForumPost post) {
		if (hasAdminRole())
			return true;
		String logonId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (post.getUser().getUserId().equals(logonId)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasReadPermission(Forum forum) {
		if (hasAdminRole())
			return true;
		String logonId = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Forum> myForums = forumService.getForumsFor(logonId);
		for (Forum myForum : myForums) {
			if (myForum.getId() == forum.getId()) {
				System.out.println("######## " + myForum.getId() + ":" + forum.getId());
				return true;
			}
		}
		return false;
	}
	
	private boolean hasAdminRole() {
		GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if ("ROLE_ADMIN".equals(authority.getAuthority()))
				return true;
		}
		return false;
	}

	@Override
	public boolean hasReadPermission(ForumPost post) {
		Forum forum = post.getForum();
		return hasReadPermission(forum);
	}

	@Override
	public boolean hasRemovePermission(ForumPost post) {
		return hasModificationPermission(post);
	}

	@Override
	public boolean hasWritePermission(Forum forum) {
		if (hasAdminRole())
			return true; 
		if (forum.getForumType().equals("qna"))
			return hasReadPermission(forum);
		return false;
	}

	@Override
	public boolean hasBrowserForumPermission() {
		return hasAdminRole();
	}

}
