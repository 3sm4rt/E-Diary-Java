package hu.citec.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler { 
	private static final Logger logger = LogManager.getLogger();

	@Override
	public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AccessDeniedException e) throws IOException {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 

		if (auth != null) {
			
			logger.warn("User: " + auth.getName() + " attempted to access the protected URL: " + httpServletRequest.getRequestURI());
		}

	
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");
	}
	
	
	private String TargetUrl (Authentication authentication) {
		Map <String, String> AccesMap = new HashMap<>();
		AccesMap.put("ADMIN", "/adminHome");
		AccesMap.put("DIAK", "/userHome");
		AccesMap.put("TANAR", "/teacherHome");
		
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grandtedAuthority : authorities) {
			String authority = grandtedAuthority.getAuthority();
			if(AccesMap.containsKey(authority)) {
				String roletTarget = AccesMap.get(authority);
				return roletTarget;
			}
		}
		throw new IllegalStateException();
		
	}
}
