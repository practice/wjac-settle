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

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		List<UserGroup> groups = (List<UserGroup>)model.get("groups");
		
		response.getWriter().println("[");
		
		int i = 0;
		
		for(UserGroup group:groups){
			if(i == 0){
				response.getWriter().println("{id:\"" + group.getGroupId() + "\", value:\"" + group.getGroupName() + "\"}");
			}else{
				response.getWriter().println(", {id:\"" + group.getGroupId() + "\", value:\"" + group.getGroupName() + "\"}");
			}			
			i++;
		}
		
		response.getWriter().println("]");
		
	}

}
