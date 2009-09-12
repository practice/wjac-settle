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

import org.jabberstory.cjac.consignsettle.common.util.Paging;
import org.jabberstory.cjac.consignsettle.domain.ZipCodeService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * 우편번호 컨트롤러
 *
 * @author HyunBae Shin
 * @since June 4, 2009
 */
public class ZipCodeListController extends SimpleFormController {
	
	private ZipCodeService zipCodeService;
	
	public void setZipCodeService(ZipCodeService zipCodeService){
		this.zipCodeService = zipCodeService;
	}
	
	public ZipCodeListController() {
		setCommandClass(ZipCodeCommand.class);
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String openerZipCode1 = request.getParameter("openerZipCode1");
		String openerZipCode2 = request.getParameter("openerZipCode2");
		String openerAddr = request.getParameter("openerAddr");
		ZipCodeCommand keyword = (ZipCodeCommand)command;
		
		if (keyword.getKeyword() != null && keyword.getKeyword().trim().length() > 0) {
			int pageSize = 10;
			String pageNo = (keyword.getPageNo() == null || keyword.getPageNo() == "")?"1":keyword.getPageNo();
			Paging zipCodes = zipCodeService.getZipCodesWithPaging(keyword.getKeyword(), Integer.parseInt(pageNo), pageSize);
			ModelAndView mv = new ModelAndView("organ/zipCodeList", "zipCodes", zipCodes);
			mv.addObject("keyword", keyword.getKeyword());
			mv.addObject("openerZipCode1", openerZipCode1);
			mv.addObject("openerZipCode2", openerZipCode2);
			mv.addObject("openerAddr", openerAddr);
			return mv;
		}
		return new ModelAndView("organ/zipCodeList");		
	}
}
