package edu.ustc.mix.front.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFilter extends LogoutFilter {
	
	private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		
		Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
        
		try {
			if(null != subject.getPrincipal()) {
				subject.logout();
	            issueRedirect(request, response, redirectUrl);
	            return false;
			} else {
				return true;
			}
		} catch (SessionException ise) {
            log.debug("Encountered session exception during login.", ise);
            return false;
        }
	}
}
