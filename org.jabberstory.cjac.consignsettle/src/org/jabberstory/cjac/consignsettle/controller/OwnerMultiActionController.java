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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.Owner;
import org.jabberstory.cjac.consignsettle.domain.OwnerService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 전담기관 관리 컨트롤러
 *
 * @author HyunBae Shin
 * @since August 24, 2009
 */
public class OwnerMultiActionController extends MultiActionController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	public OwnerMultiActionController() {
	}

	private OwnerService ownerService;
	
	public void setOwnerService(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	public ModelAndView create(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String ownerName = (request.getParameter("ownerName") == null) ? "": request.getParameter("ownerName");
		
		if (ownerName.equals("")){
			return new ModelAndView("createOwner");
		}
		
		Owner owner = new Owner();
		
		bind(request, owner);
		
		ownerService.createOwner(owner);
		
	    return new ModelAndView("redirect:listOwner");
	    
	} 
	
	public ModelAndView show(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String ownerId = request.getParameter("ownerId");

		Owner owner = ownerService.getOwner(ownerId);

		return new ModelAndView("showOwner", "owner", owner);

	}
	
	public ModelAndView update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String ownerId = request.getParameter("ownerId");
		String ownerName = (request.getParameter("ownerName") == null) ? "": request.getParameter("ownerName");
		Owner owner;
		
		if (ownerName.equals("")){
			owner = ownerService.getOwner(ownerId);
			return new ModelAndView("updateOwner", "owner", owner);
		}
		
		owner = new Owner();

		bind(request, owner);

		ownerService.updateOwner(owner);

		return new ModelAndView("redirect:listOwner");

	}
	
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String ownerId = request.getParameter("ownerId");

		ownerService.removeOwner(ownerId);

		return new ModelAndView("redirect:listOwner");

	}

	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		List<Owner> owners = ownerService.getOwnersByUserId(userId, role);
		
		ModelAndView mv = new ModelAndView("listOwner", "owners", owners);
		mv.addObject("ownerCount", owners.size());

		return mv;

	}
	
	public ModelAndView listPaging(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String pageNo = (request.getParameter("pageNo") == null) ? "1": request.getParameter("pageNo");
		String sortColumn = (request.getParameter("sortColumn") == null) ? "": request.getParameter("sortColumn");

		String userId = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		String role = ""; // UserService 사용자정보 쿼포함되어야 하지 않을까?
		
		int pageSize = 10;

		Paging pagingList = ownerService.getOwnersByUserIdWithPaging(userId, role, Integer.parseInt(pageNo), pageSize, sortColumn);
		
		ModelAndView mv = new ModelAndView("listOwner", "pagingList", pagingList);
		mv.addObject("ownerCount", pagingList.getTotalCount());
		mv.addObject("sortColumn", sortColumn);
		
		return mv;

	}
	
}

