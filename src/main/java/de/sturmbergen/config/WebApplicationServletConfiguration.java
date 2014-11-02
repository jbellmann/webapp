package de.sturmbergen.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationServletConfiguration extends
	AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class<?>[] { WebMvcConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/*" };
    }

    public void onStartup(final ServletContext servletContext)
	    throws ServletException {
	super.onStartup(servletContext);

    }

}
