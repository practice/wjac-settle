package org.jabberstory.cjac.forum.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;

public class MultiFileSupportServletRequestDataBinder extends
		ServletRequestDataBinder {

	public MultiFileSupportServletRequestDataBinder(Object target) {
		super(target);
	}

	public MultiFileSupportServletRequestDataBinder(Object target,
			String objectName) {
		super(target, objectName);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void bindMultipartFiles(Map multipartFiles, MutablePropertyValues mpvs) {
		for (Iterator it = multipartFiles.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			// MultipartFile value = (MultipartFile) entry.getValue();
			List<MultipartFile> value = (List<MultipartFile>)entry.getValue();
			for (MultipartFile file : value) {
				logger.debug("##### " + file.getName() + "=" + file.getOriginalFilename());
			}
			if (isBindEmptyMultipartFiles() || !value.isEmpty()) {
				logger.debug("##### " + key + "=" + value);
//				mpvs.addPropertyValue(key, value);
				mpvs.addPropertyValue(value.get(0).getName(), value);
			}
		}
	}
}
