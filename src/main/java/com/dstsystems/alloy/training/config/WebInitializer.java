package com.dstsystems.alloy.training.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext apiContext = new AnnotationConfigWebApplicationContext();
		apiContext.register(AppConfig.class, ApiConfig.class);
		apiContext.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("api",
				new DispatcherServlet(apiContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
