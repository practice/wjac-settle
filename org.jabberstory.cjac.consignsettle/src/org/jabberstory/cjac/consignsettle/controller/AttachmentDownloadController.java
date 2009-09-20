package org.jabberstory.cjac.consignsettle.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jabberstory.cjac.consignsettle.domain.OrganAttachment;
import org.jabberstory.cjac.consignsettle.domain.OrganService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;

public class AttachmentDownloadController implements Controller, ApplicationContextAware {
	private OrganService organService;
	private WebApplicationContext appContext;

	public void setOrganService(OrganService organService) {
		this.organService = organService;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
				this.appContext = (WebApplicationContext) applicationContext;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String organId = request.getParameter("organId");
		String attId = request.getParameter("attId");
		OrganAttachment attachment = organService.getOrganAttachment(organId, attId);

		File file;
		if (organService.isUnix()) {			
			file = new File(OrganService.FILE_PREFIX_UNIX + attachment.getDir() + "/" + attachment.getFilename());
		} else {
			file = new File(OrganService.FILE_PREFIX_WIN + attachment.getDir() + "/" + attachment.getFilename());
		}
		
		return new ModelAndView((View)appContext.getBean("downloadView"), "file", file);	// here we do not use view name. Instead use view object.
	}

}
