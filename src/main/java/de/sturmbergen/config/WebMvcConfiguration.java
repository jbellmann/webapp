package de.sturmbergen.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@EnableWebMvc
@Configuration
@Import(TemplateEngineConfiguration.class)
@ComponentScan(basePackages = { "de.sturmbergen.web" })
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    private final int COOKIE_ONE_WEEK = 604800;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/assets/**").addResourceLocations(
		"/assets/");
    }

    @Override
    public void configureDefaultServletHandling(
	    final DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
    }

    // @Override
    // public void addArgumentResolvers(
    // List<HandlerMethodArgumentResolver> argumentResolvers) {
    // PageableHandlerMethodArgumentResolver resolver = new
    // PageableHandlerMethodArgumentResolver();
    // resolver.setFallbackPageable(new PageRequest(1, 10));
    // argumentResolvers.add(resolver);
    // }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
	interceptorRegistry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	localeChangeInterceptor.setParamName("locale");
	return localeChangeInterceptor;
    }

    @Bean
    public MessageSource messageSource() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:messages/messages");
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
	CookieLocaleResolver resolver = new CookieLocaleResolver();
	resolver.setDefaultLocale(Locale.ENGLISH);
	resolver.setCookieMaxAge(COOKIE_ONE_WEEK);
	return resolver;
    }

    @Bean
    public HandlerMapping handlerMapping(LocaleChangeInterceptor interceptor) {
	SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
	handlerMapping.setInterceptors(new Object[] { interceptor });
	return handlerMapping;
    }
}
