package org.jabberstory.cjac.forum.domain;

public class PostAttachment {
	private int id;
	private String filename;
	private long filesize;
	private String dir;
	private ForumPost post;
	
	public PostAttachment() {
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setPost(ForumPost post) {
		this.post = post;
	}

	public ForumPost getPost() {
		return post;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}

}
