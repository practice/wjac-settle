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
package org.jabberstory.cjac.consignsettle.common.util;

import java.util.List;

/**
 * Paging Support Class
 *
 * @author HyunBae Shin
 * @since June 4, 2009
 */
public class Paging {
	
	@SuppressWarnings("unchecked")
	private List items;
	private int totalCount;
	private int currentPage;
	private int totalPage;
	private int sizePerPage = 10;
	private int pageSize = 10;
	private int startPage;
	private int endPage;
	
	@SuppressWarnings("unchecked")
	public Paging(List items, int totalCount, int currentPage, int pageSize, int sizePerPage){
		this(items, totalCount, currentPage);
		this.pageSize = pageSize;
		this.sizePerPage = sizePerPage;
	}
	
	@SuppressWarnings("unchecked")
	public Paging(List items, int totalCount, int currentPage){
		this.items = items;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage = (totalCount - 1)/sizePerPage + 1;
		this.startPage = ((currentPage - 1) / pageSize) * pageSize + 1;
		this.endPage = (startPage - 1) + pageSize;
	}
	
	public boolean hasNextPage() {
		return currentPage < totalPage;
	}

	public boolean hasPreviousPage() {
		return currentPage > 1;
	}

	public int getNextPage() {
		if(hasNextPage()){
			return currentPage + 1;
		}
		
		return currentPage;
	}
	
	public int getPreviousPage() {
		if(hasPreviousPage()){
			return currentPage - 1;
		}
		
		return currentPage;		
	}
	
	@SuppressWarnings("unchecked")
	public List getItems() {
		return items;
	}

	@SuppressWarnings("unchecked")
	public void setItems(List items) {
		this.items = items;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getSizePerPage() {
		return sizePerPage;
	}

	public void setSizePerPage(int sizePerPage) {
		this.sizePerPage = sizePerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return (endPage >= totalPage) ? this.totalPage: this.endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}	
	
}
