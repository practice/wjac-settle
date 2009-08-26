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
package org.jabberstory.cjac.consignsettle.common.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * Paging Custom Tag Library
 * 
 * @author HyunBae Shin
 * @since June 4, 2009
 */
public class PagingTag extends RequestContextAwareTag {
	
	private static final long serialVersionUID = 7839641121219862837L;
	
	private String formTagName;
	private String searchFunctionName;
	private Paging pagingList;
	private String imgStart;
	private String imgPrev;
	private String imgNext;
	private String imgEnd;
	private String altStart;
	private String altPrev;
	private String altNext;
	private String altEnd;
	private String pageNoTagName;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.tags.RequestContextAwareTag#doStartTagInternal()
	 */
	@Override
	protected int doStartTagInternal() throws Exception {
		try {			
			JspWriter out = pageContext.getOut();

			out.println("<div class=\"paginate\">"); 
			
			out.println("<a href=\"#\" class=\"btn_ll\" onClick=\"" + getSearchScript(1) + "\"><img src=\"" + getImgStart() + "\" alt=\"" + getAltStart() + "\" width=\"11\" height=\"11\"></a>"); 
			out.println("	<a href=\"#\" class=\"btn_l\" onClick=\"" + getSearchScript(pagingList.getPreviousPage()) + "\"><img src=\"" + getImgPrev() + "\" alt=\"" + getAltPrev() + "\" width=\"11\" height=\"11\"></a>");

			for (int pageNo = pagingList.getStartPage(); pageNo <= pagingList.getEndPage(); pageNo++) {				
				if(pageNo == pagingList.getCurrentPage()){
					out.println("<strong>" + pageNo + "</strong>");
				}else{
					out.println("<a href=\"#\" onClick=\"" + getSearchScript(pageNo) + "\">" + pageNo + "</a>");
				}
		    }
			
			out.println("	<a href=\"#\" class=\"btn_r\" onClick=\"" + getSearchScript(pagingList.getNextPage()) + "\"><img src=\"" + getImgNext() + "\" alt=\"" + getAltNext() + "\" width=\"11\" height=\"11\"></a>"); 
			out.println("	<a href=\"#\" class=\"btn_rr\" onClick=\"" + getSearchScript(pagingList.getTotalPage()) + "\"><img src=\"" + getImgEnd() + "\" alt=\"" + getAltEnd() + "\" width=\"11\" height=\"11\"></a>");
			
			out.println("</div>");			
			
		} catch (IOException e) {
			throw new JspTagException("Error : " + e.getMessage());
		}
		return SKIP_BODY;
	}
	
	private String getSearchScript(int pageNo){		
		return searchFunctionName + "('" + pageNo + "')" + ";" + "return false;";		
	}
	
	public String getFormTagName() {
		if(formTagName == null){
			formTagName = "form[0]";
		}
		return formTagName;
	}

	public void setFormTagName(String formTagName) {
		this.formTagName = formTagName;
	}

	public String getSearchFunctionName() {
		if(searchFunctionName == null){
			searchFunctionName = "";
		}
		return searchFunctionName;
	}

	public void setSearchFunctionName(String searchFunctionName) {
		this.searchFunctionName = searchFunctionName;
	}

	public Paging getPagingList() {
		return pagingList;
	}

	public void setPagingList(Paging pagingList) {
		this.pagingList = pagingList;
	}

	public String getImgStart() {
		if(imgStart == null)
		{
			return this.getRequestContext().getContextPath() + "/images/board_pg_btn_ll.gif";
		}
		return imgStart;
		
	}

	public void setImgStart(String imgStart) {
		this.imgStart = imgStart;
	}

	public String getAltStart() {
		if(altStart == null){
			//return this.getRequestContext().getMessage("button.common.startpage", new String[]{});
			return "시작페이지";
		}
		return altStart;
	}

	public void setAltStart(String altStart) {		
		this.altStart = altStart;
	}

	public String getImgPrev() {
		if(imgPrev == null)
		{
			return this.getRequestContext().getContextPath() + "/images/board_pg_btn_l.gif";
		}
		return imgPrev;
	}

	public void setImgPrev(String imgPrev) {
		this.imgPrev = imgPrev;
	}

	public String getAltPrev() {
		if(altPrev == null){
			//return this.getRequestContext().getMessage("button.common.prevpage", new String[]{});
			return "이전페이지";
		}
		return altPrev;
	}

	public void setAltPrev(String altPrev) {
		this.altPrev = altPrev;
	}

	public String getImgNext() {
		if(imgNext == null)
		{
			return this.getRequestContext().getContextPath() + "/images/board_pg_btn_r.gif";
		}
		return imgNext;
	}

	public void setImgNext(String imgNext) {
		this.imgNext = imgNext;
	}

	public String getAltNext() {
		if(altNext == null){
			//return this.getRequestContext().getMessage("button.common.nextpage", new String[]{});
			return "다음페이지";
		}
		return altNext;
	}

	public void setAltNext(String altNext) {
		this.altNext = altNext;
	}

	public String getImgEnd() {
		if(imgEnd == null)
		{
			return this.getRequestContext().getContextPath() + "/images/board_pg_btn_rr.gif";
		}
		return imgEnd;
	}

	public void setImgEnd(String imgEnd) {
		this.imgEnd = imgEnd;
	}

	public String getAltEnd() {
		if(altEnd == null){
			//return this.getRequestContext().getMessage("button.common.endpage", new String[]{});
			return "끝페이지";
		}
		return altEnd;
	}

	public void setAltEnd(String altEnd) {
		this.altEnd = altEnd;
	}
	
	public String getPageNoTagName() {
		if(pageNoTagName == null){
			pageNoTagName = "pageNo";
		}
		return pageNoTagName;
	}

	public void setPageNoTagName(String pageNoTagName) {
		this.pageNoTagName = pageNoTagName;
	}
	
}
