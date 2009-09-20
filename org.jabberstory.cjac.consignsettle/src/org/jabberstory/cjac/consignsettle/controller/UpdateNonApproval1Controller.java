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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.Organ;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdateNonApproval1Controller extends SimpleFormController{
	
	private OrganService organService;
	
	public void setOrganService(OrganService organService){
		this.organService = organService;
	}
	
	public UpdateNonApproval1Controller() {
		setCommandClass(OrganFileCommand.class);
		setCommandName("updateNonApproval1");
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		if (isFormSubmission(request)) {
			return super.formBackingObject(request);
		}
		Organ organ = organService.getOrgan(request.getParameter("organId"));
		OrganFileCommand command = new OrganFileCommand();
		command.setOrganId(request.getParameter("organId"));
		//if(organ.getAttachments().size() != 0 && organ.getAttachments().get(0) != null){
		//	command.setFiles(organ.getAttachments());
		//}		
		return command;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		OrganFileCommand ofc = (OrganFileCommand)command;
		Organ organ = organService.getOrgan(ofc.getOrganId());
		organService.updateOrganNonApproval1(ofc.getOrganId(), "", ofc.getFiles().get(0));
		return new ModelAndView("organ/showNonApproval1", "organ", organ);
	}

}
