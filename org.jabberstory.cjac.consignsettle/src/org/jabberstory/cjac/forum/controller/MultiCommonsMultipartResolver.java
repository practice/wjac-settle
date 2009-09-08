package org.jabberstory.cjac.forum.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Borrowed from http://dhruba.name/2008/12/27/implementing-single-and-multiple-file-multipart-uploads-using-spring-25/
 * 
 * @author shawn.won@gmail.com
 *
 */
public class MultiCommonsMultipartResolver extends CommonsMultipartResolver {

	public MultiCommonsMultipartResolver() {
	}

	public MultiCommonsMultipartResolver(ServletContext servletContext) {
		super(servletContext);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected MultipartParsingResult parseFileItems(List fileItems,
			String encoding) {
		Map multipartFiles = new HashMap();
		Map multipartParameters = new HashMap();

		logger.debug("##### parsing file items");
		// Extract multipart files and multipart parameters.
		for (Iterator it = fileItems.iterator(); it.hasNext();) {
			FileItem fileItem = (FileItem) it.next();
			if (fileItem.isFormField()) {
				String value = null;
				if (encoding != null) {
					try {
						value = fileItem.getString(encoding);
					} catch (UnsupportedEncodingException ex) {
						if (logger.isWarnEnabled()) {
							logger.warn("Could not decode multipart item '"
									+ fileItem.getFieldName()
									+ "' with encoding '" + encoding
									+ "': using platform default");
						}
						value = fileItem.getString();
					}
				} else {
					value = fileItem.getString();
				}
				String[] curParam = (String[]) multipartParameters.get(fileItem
						.getFieldName());
				if (curParam == null) {
					// simple form field
					multipartParameters.put(fileItem.getFieldName(),
							new String[] { value });
				} else {
					// array of simple form fields
					String[] newParam = StringUtils.addStringToArray(curParam,
							value);
					multipartParameters.put(fileItem.getFieldName(), newParam);
				}
			} else {
				// multipart file field
				if (fileItem.getSize() == 0)
					continue;
				CommonsMultipartFile file = new CommonsMultipartFile(fileItem);
//				if (multipartFiles.put(fileItem.getName(), file) != null) {
//					throw new MultipartException(
//							"Multiple files for field name ["
//									+ file.getName()
//									+ "] found - not supported by MultipartResolver");
//				}
				List list = (List) multipartFiles.get(file.getName());
				if (list != null) {
					logger.debug("##### added file " + file.getName());
					list.add(file);
				} else {
					logger.debug("##### create new array " + file.getName());
					List fileList = new ArrayList();
					fileList.add(file);
					multipartFiles.put(file.getName(), fileList);
				}
				
				if (logger.isDebugEnabled()) {
					logger.debug("Found multipart file [" + file.getName()
							+ "] of size " + file.getSize()
							+ " bytes with original filename ["
							+ file.getOriginalFilename() + "], stored "
							+ file.getStorageDescription());
				}
			}
		}
		return new MultipartParsingResult(multipartFiles, multipartParameters);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void cleanupFileItems(Collection multipartFiles) {
		for (Iterator it = multipartFiles.iterator(); it.hasNext();) {
//			CommonsMultipartFile file = (CommonsMultipartFile) it.next();
			List fileList = (List) it.next();
			Iterator iter = fileList.iterator();
			while (iter.hasNext()) {
				CommonsMultipartFile file = (CommonsMultipartFile) iter.next();
				if (logger.isDebugEnabled()) {
					logger.debug("Cleaning up multipart file ["
							+ file.getName() + "] with original filename ["
							+ file.getOriginalFilename() + "], stored "
							+ file.getStorageDescription());
				}
				file.getFileItem().delete();
			}
//			file.getFileItem().delete();
		}
	}
	
}
