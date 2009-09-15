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
package org.jabberstory.cjac.forum.controller;

import javax.servlet.http.HttpServletRequest;

public class ForumUtil {
	
	public static int extractForumId(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String[] pathElement = uri.split("/");
		if (pathElement.length != 5)
			return -1;
		return Integer.parseInt(pathElement[3]);
	}
	
	public static String buildShowPostUrl(int forumId, int postId, int page) {
		return "/forum/" + forumId + "/showpost?id=" + postId + "&page=" + page;
	}
	
	public static String buildListUrl(int forumId) {
		return "/forum/" + forumId + "/list";
	}

	public static String buildListUrl(int forumId, int page) {
		return "/forum/" + forumId + "/list?page=" + page;
	}
}
