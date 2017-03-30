package com.accenture.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;

import org.springframework.boot.context.embedded.ServletContextInitializer;

public class SessionTrackingConfigListener implements ServletContextInitializer {
	
	  //@Override
	    public void onStartup(ServletContext servletContext)throws ServletException {
	        SessionCookieConfig sessionCookieConfig = servletContext
	                .getSessionCookieConfig();
	        sessionCookieConfig.setHttpOnly(true);
	        sessionCookieConfig.setName("SAMPLESESSIONID");
	        Set<SessionTrackingMode> stmSet = new HashSet<SessionTrackingMode>();
	        stmSet.add(SessionTrackingMode.COOKIE);
	        servletContext.setSessionTrackingModes(stmSet);
	    }

}
