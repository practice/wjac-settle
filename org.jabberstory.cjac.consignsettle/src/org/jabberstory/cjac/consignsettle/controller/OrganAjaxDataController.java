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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.jabberstory.cjac.consignsettle.domain.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

public class OrganAjaxDataController implements Controller{
	
	private UserService userService;
	private View organAjaxDataView;
	
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	public void setOrganAjaxDataView(View organAjaxDataView){
		this.organAjaxDataView = organAjaxDataView;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String groupId = (request.getParameter("groupId") == null)?"":request.getParameter("groupId");
		String dataType = (request.getParameter("dataType") == null)?"":request.getParameter("dataType");
				
		Map dataMap = new HashMap();
		dataMap.put("dataType", dataType);
		if("".equals(dataType) || "0".equals(dataType)){
			dataMap.put("groups", userService.getGroupsByParentGroupId(groupId));
		}
		if("1".equals(dataType)){
			dataMap.put("users", userService.getUsersByGroupId(groupId));
		}
		
		return new ModelAndView(organAjaxDataView,"dataMap",dataMap);
	}
	
}
