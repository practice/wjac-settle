package org.jabberstory.cjac.forum.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = (File) model.get("file");
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setContentLength((int)file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + 
				new String(file.getName().getBytes(), "8859_1") + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		FileInputStream inputStream = new FileInputStream(file);
		ServletOutputStream outputStream = response.getOutputStream();
		FileCopyUtils.copy(inputStream, outputStream);
		if (inputStream != null) {
			inputStream.close();
		}
		outputStream.flush();
	}

}
