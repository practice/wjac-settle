package org.jabberstory.cjac.forum.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jabberstory.cjac.consignsettle.domain.User;

public class ForumPost {
	private int id;
	private int step;
	private int depth;
	private int rootId;
	private String subject;
	private String body;
	private Timestamp createdDate;
	private int readCount;
	private int replyCount;
	private boolean hidden = false;
	private User user;
	private List<PostAttachment> attachments = new ArrayList<PostAttachment>();
	private Forum forum;
	
	@SuppressWarnings("unchecked")
	private HashMap prop = new HashMap();

//	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * default constructor required.
	 */
	public ForumPost() {
	}
	
	public ForumPost(String subject, String body, User user, boolean hidden) {
		this.step = 0;
		this.depth = 0;
		this.rootId = 0;
		this.subject = subject;
		this.body = body;
		this.createdDate = new Timestamp(System.currentTimeMillis());
		this.readCount = 0;
		this.replyCount = 0;
		this.hidden = hidden;
		this.user = user;
	}
	
	public ForumPost(String subject, String body, User user, ForumPost parent) {
		// TODO build a child post.
	}

	public int getId() {
		return id;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getRootId() {
		return rootId;
	}
	public void setRootId(int rootId) {
		this.rootId = rootId;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCreatedDate() {
		if (createdDate == null)
			return "unknown";
		return dateFormatter.format(createdDate);
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public void addAttachment(PostAttachment attachment) {
		getAttachments().add(attachment);
	}

	public List<PostAttachment> getAttachments() {
		return attachments;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Forum getForum() {
		return forum;
	}

	@SuppressWarnings("unchecked")
	public void setProp(HashMap prop) {
		this.prop = prop;
	}

	@SuppressWarnings("unchecked")
	public HashMap getProp() {
		return prop;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isHidden() {
		return hidden;
	}

}
