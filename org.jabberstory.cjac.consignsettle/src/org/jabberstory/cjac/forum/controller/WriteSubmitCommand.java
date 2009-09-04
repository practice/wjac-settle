package org.jabberstory.cjac.forum.controller;

import org.springframework.web.multipart.MultipartFile;

public class WriteSubmitCommand {
	private String title;
	private String body;
	private MultipartFile file0; // 여러개의 파일을 가변적으로 업로드 할 경우? file0, file1, ... fileN 과 같이 한다?
	private MultipartFile file1;
	
	public WriteSubmitCommand() {
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setFile0(MultipartFile file) {
		this.file0 = file;
	}

	public MultipartFile getFile0() {
		return file0;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile1() {
		return file1;
	}

}
