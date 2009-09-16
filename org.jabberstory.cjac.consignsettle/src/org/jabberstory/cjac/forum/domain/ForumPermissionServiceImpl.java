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
		String logonId = SecurityContextHolder.getContext().getAuthentication().getName();
		GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if ("ROLE_ADMIN".equals(authority.getAuthority()))
				return true;
		}
		if (post.getUser().getUserId().equals(logonId)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasReadPermission(Forum forum) {
		GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if ("ROLE_ADMIN".equals(authority.getAuthority()))
				return true;
		}
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
		return hasReadPermission(forum);
	}

	@Override
	public boolean hasBrowserForumPermission() {
		GrantedAuthority[] authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if ("ROLE_ADMIN".equals(authority.getAuthority()))
				return true;
		}
		return false;
	}

}
