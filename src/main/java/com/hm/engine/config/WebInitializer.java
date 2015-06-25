package com.hm.engine.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author ant_shake_tree
 */
public class WebInitializer implements WebApplicationInitializer {
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
	private static final String DISPATCHER_SERVLET_MAPPING = "/services/*";
	
	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(HmEngineConfig.class);
//		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext)
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

//		FilterRegistration.Dynamic security = servletContext.addFilter(
//				"springSecurityFilterChain", new DelegatingFilterProxy());
//		EnumSet<DispatcherType> securityDispatcherTypes = EnumSet.of(
//				DispatcherType.REQUEST, DispatcherType.FORWARD);
//		security.addMappingForUrlPatterns(securityDispatcherTypes, true, "/*");

		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}
