package de.sturmbergen.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class TemplateEngineConfiguration {
    @Bean
    public ServletContextTemplateResolver templateResolver() {
	ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
	resolver.setPrefix("/WEB-INF/templates/");
	resolver.setSuffix(".html");
	resolver.setTemplateMode("HTML5");
	resolver.setOrder(1);
	return resolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(MessageSource messageSource,
	    ServletContextTemplateResolver templateResolver) {
	SpringTemplateEngine engine = new SpringTemplateEngine();
	engine.setTemplateResolver(templateResolver);
	engine.setMessageSource(messageSource);
	return engine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(
	    SpringTemplateEngine templateEngine) {
	ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	resolver.setTemplateEngine(templateEngine);
	return resolver;
    }
}
