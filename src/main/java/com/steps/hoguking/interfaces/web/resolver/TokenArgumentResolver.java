package com.steps.hoguking.interfaces.web.resolver;

import com.steps.hoguking.domain.Token;
import com.steps.hoguking.interfaces.web.filter.AuthFilter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class TokenArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().isAssignableFrom(Token.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter,
	                              ModelAndViewContainer modelAndViewContainer,
	                              NativeWebRequest nativeWebRequest,
	                              WebDataBinderFactory webDataBinderFactory) throws Exception {

		HttpServletRequest request
				= (HttpServletRequest) nativeWebRequest.getNativeRequest();

		return request.getAttribute(AuthFilter.ATTRIBUTE_KEY_TOKEN);
	}
}
