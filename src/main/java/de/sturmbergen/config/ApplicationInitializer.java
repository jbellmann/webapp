package de.sturmbergen.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationInitializer implements
	ApplicationContextInitializer<ConfigurableApplicationContext> {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void initialize(
	    final ConfigurableApplicationContext applicationContext) {
	logger.info("APPLICATION CONTEXT STARTED");
    }
}
