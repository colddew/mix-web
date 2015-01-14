package edu.ustc.mix.front.security;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import edu.ustc.mix.core.security.SystemUser;

public class SystemUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		
		return parameter.hasParameterAnnotation(SystemUser.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, 
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		SystemUser annotation = parameter.getParameterAnnotation(SystemUser.class);
		
		return webRequest.getAttribute(annotation.value(), NativeWebRequest.SCOPE_REQUEST);
	}

}
