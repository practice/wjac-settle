/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package org.jabberstory.cjac.forum.domain;

public class Forum {
	public static String PUBLIC_TYPE = "public";
	public static String QNA_TYPE = "qna";
	public static String FILES_TYPE = "files";
	
	private int id;
	private String name;
	private String groupId; // owner group id.
	private String forumType;	// public, qna, files
	
	public Forum() {
	}
	
	public Forum(String groupId, String forumType, String forumName) {
		this.groupId = groupId;
		this.forumType = forumType;
		this.name = forumName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setForumType(String forumType) {
		this.forumType = forumType;
	}
	public String getForumType() {
		return forumType;
	}
}
