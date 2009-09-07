package org.jabberstory.cjac.forum.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.bind.ServletRequestDataBinder;

public class MultiFileSupportServletRequestDataBinder extends
		ServletRequestDataBinder {

	public MultiFileSupportServletRequestDataBinder(Object target) {
		super(target);
	}

	public MultiFileSupportServletRequestDataBinder(Object target,
			String objectName) {
		super(target, objectName);
	}

	@Override
	protected void bindMultipartFiles(Map multipartFiles, MutablePropertyValues mpvs) {
		for (Iterator it = multipartFiles.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			// MultipartFile value = (MultipartFile) entry.getValue();
			List value = (List)entry.getValue();
			if (isBindEmptyMultipartFiles() || !value.isEmpty()) {
				mpvs.addPropertyValue(key, value);
			}
		}
	}
}
