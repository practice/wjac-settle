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
package org.jabberstory.cjac.consignsettle.domain;

public class OrganAttachment {
	private int id;
	private String filename;
	private long filesize;
	private String dir;
	private Organ organ;
	
	public OrganAttachment() {
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

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getDir() {
		return dir;
	}

	public Organ getOrgan() {
		return organ;
	}

	public void setOrgan(Organ organ) {
		this.organ = organ;
	}

	@Override
	public String toString() {
		return "OrganAttachment [dir=" + dir + ", filename=" + filename
				+ ", filesize=" + filesize + ", id=" + id + "]";
	}
	
}