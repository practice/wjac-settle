package org.jabberstory.cjac.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

public class WriteSubmitCommand {
	private String id;
	private String title;
	private String body;
	private boolean hidden;
	private List<MultipartFile> files = new ArrayList<MultipartFile>(); // 여러개의 파일을 가변적으로 업로드 할 경우? file0, file1, ... fileN 과 같이 한다?
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public WriteSubmitCommand() {
	}
	
	public void setTitle(String title) {
		this.title = title;
		logger.debug("##### title assigned.");
	}
	public String getTitle() {
		return title;
	}

	public void setBody(String body) {
		this.body = body;
		logger.debug("##### body assigned.");
	}

	public String getBody() {
		return body;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isHidden() {
		return hidden;
	}

}
