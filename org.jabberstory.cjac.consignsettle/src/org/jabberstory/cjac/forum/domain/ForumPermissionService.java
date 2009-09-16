package org.jabberstory.cjac.forum.domain;

public interface ForumPermissionService {

	public boolean hasReadPermission(Forum forum);

	public boolean hasReadPermission(ForumPost post);

	public abstract boolean hasWritePermission(Forum forum);

	public abstract boolean hasModificationPermission(ForumPost post);

	public abstract boolean hasRemovePermission(ForumPost post);

	public boolean hasBrowserForumPermission();

}