/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.security.oauth2.resourceserver.web;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * A request matcher for detecting when the request may contain a
 * bearer token
 *
 * @since 5.1
 * @author Josh Cummings
 */
public class BearerTokenRequestMatcher implements RequestMatcher {

	@Override
	public boolean matches(HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader("Authorization"))
				.filter(header -> header.startsWith("Bearer "))
				.isPresent();
	}
}
