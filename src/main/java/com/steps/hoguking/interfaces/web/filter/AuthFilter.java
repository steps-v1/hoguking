package com.steps.hoguking.interfaces.web.filter;

import com.steps.hoguking.domain.LoginService;
import com.steps.hoguking.domain.Token;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class AuthFilter implements Filter {
	public static final String HEADER_AUTHORIZATION = "Authorization";
	public static final String ATTRIBUTE_KEY_TOKEN = "hoguking-token";
	@Autowired
	private LoginService loginService;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		tokenToUserId(servletRequest);

		filterChain.doFilter(servletRequest, servletResponse);

	}

	private void tokenToUserId(ServletRequest servletRequest) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String tokenString = httpServletRequest.getHeader(HEADER_AUTHORIZATION);
		if (StringUtils.isNotBlank(tokenString)) {
			Token token = loginService.getToken(tokenString);
			servletRequest.setAttribute(ATTRIBUTE_KEY_TOKEN, token);
		}
	}
}
