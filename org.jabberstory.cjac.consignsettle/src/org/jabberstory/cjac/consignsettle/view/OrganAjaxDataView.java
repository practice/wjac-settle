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
package org.jabberstory.cjac.consignsettle.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.User;
import org.jabberstory.cjac.consignsettle.domain.UserGroup;
import org.springframework.web.servlet.view.AbstractView;


public class OrganAjaxDataView extends AbstractView {

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		response.setHeader("Content-Type", "text/plain;charset=UTF-8");		
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");
		
		Map dataMap = (HashMap)model.get("dataMap");
		String dataType = (String)dataMap.get("dataType");
		List<UserGroup> groups = (List<UserGroup>)dataMap.get("groups");
		List<User> users =(List<User>)dataMap.get("users");
		
		response.getWriter().println("[");
		
		int i = 0;
		
		// parent group(전담기관)
		if("".equals(dataType) || "0".equals(dataType)){		
			for(UserGroup group:groups){
				if(i == 0){
					response.getWriter().println("{id:\"" + group.getGroupId() + "\", value:\"" + group.getGroupName() + "\"}");
				}else{
					response.getWriter().println(", {id:\"" + group.getGroupId() + "\", value:\"" + group.getGroupName() + "\"}");
				}			
				i++;
			}
		}
		
		// 주관기관 담당자
		if("1".equals(dataType) && users.size() > 0){
			User user = users.get(0);
			response.getWriter().println("{organResponsiblePerson:\"" + user.getUsername() + "\"," +
											"organResponsiblePhone1:\"" + user.getPhone1() + "\"," +
											"organResponsiblePhone2:\"" + user.getPhone2() + "\"," +
											"organResponsiblePhone3:\"" + user.getPhone3() + "\"," +
											"organResponsibleEmail:\"" + user.getEmail() + "\"," +
											"organResponsiblePostNumber1:\"" + user.getPostnum1() + "\"," +
											"organResponsiblePostNumber2:\"" + user.getPostnum2() + "\"," +
											"organResponsibleAddress:\"" + user.getAddress() + "\"}");
		}
		
		response.getWriter().println("]");
		
	}

}
