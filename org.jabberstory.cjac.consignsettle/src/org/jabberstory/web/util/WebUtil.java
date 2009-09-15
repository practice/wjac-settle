package org.jabberstory.web.util;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public static int getIntParam(HttpServletRequest request, String paramName, int defVal) {
		String paramVal = request.getParameter(paramName);
		try {
			return Integer.parseInt(paramVal);
		} catch (NumberFormatException e) {
			return defVal;
		}
	}
}
