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
package org.jabberstory.cjac.consignsettle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.Subject;
import org.jabberstory.cjac.consignsettle.domain.SubjectService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 주관기관 관리 컨트롤러
 *
 * @author HyunBae Shin
 * @since August 28, 2009
 */
public class SubjectMultiActionController extends MultiActionController {

	public SubjectMultiActionController() {
	}

	private SubjectService subjectService;
	
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	public ModelAndView create(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String subjectName = (request.getParameter("subjectName") == null) ? "": request.getParameter("subjectName");
		
		if (subjectName.equals("")){
			return new ModelAndView("createSubject");
		}
		
		Subject subject = new Subject();
		
		bind(request, subject);
		
		subjectService.createSubject(subject);
		
	    return new ModelAndView("redirect:listSubject");
	    
	} 
	
	public ModelAndView show(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String subjectId = request.getParameter("subjectId");

		Subject subject = subjectService.getSubject(subjectId);

		return new ModelAndView("showSubject", "subject", subject);

	}
	
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String subjectId = request.getParameter("subjectId");
		String subjectName = (request.getParameter("subjectName") == null) ? "": request.getParameter("subjectName");
		Subject subject;
		
		if (subjectName.equals("")){
			subject = subjectService.getSubject(subjectId);
			return new ModelAndView("updateSubject", "subject", subject);
		}
		
		subject = new Subject();

		bind(request, subject);

		subjectService.updateSubject(subject);

		return new ModelAndView("redirect:listSubject");

	}
	
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String subjectId = request.getParameter("subjectId");

		subjectService.removeSubject(subjectId);
		
		return new ModelAndView("redirect:listSubject");

	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		List<Subject> subjects = subjectService.getSubjectsByUserId(userId, role);
		
		ModelAndView mv = new ModelAndView("listSubject", "subjects", subjects);
		mv.addObject("subjectCount", subjects.size());

		return mv;

	}
	
	public ModelAndView listPaging(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");

		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		int pageSize = 10;

		Paging pagingList = subjectService.getSubjectsByUserIdWithPaging(userId, role, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("listSubject", "pagingList", pagingList);
		mv.addObject("subjectCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
	
}