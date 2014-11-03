package de.sturmbergen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Configuration
// @EnableJpaRepositories("de.sturmbergen.repositories")
@ComponentScan(basePackages = { "de.sturmbergen" }, excludeFilters = {
	@Filter(Controller.class),
	@Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebMvcConfiguration.class) })
@PropertySource("classpath:application.properties")
public class ApplicationComponentConfiguration {
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "de.sturmbergen.domain";

    // @Bean
    // public DataSource dataSource(Environment environment) {
    // BoneCPDataSource dataSource = new BoneCPDataSource();
    // dataSource.setDriverClass(environment
    // .getRequiredProperty("jdbc.driver"));
    // dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
    // dataSource.setUsername(environment.getRequiredProperty("jdbc.user"));
    // dataSource
    // .setPassword(environment.getRequiredProperty("jdbc.password"));
    // return dataSource;
    // }
    //
    // @Bean
    // public JpaTransactionManager transactionManager(
    // LocalContainerEntityManagerFactoryBean entityManagerFactoryBean)
    // throws ClassNotFoundException {
    // JpaTransactionManager transactionManager = new JpaTransactionManager();
    //
    // transactionManager.setEntityManagerFactory(entityManagerFactoryBean
    // .getObject());
    //
    // return transactionManager;
    // }
    //
    // @Bean
    // public LocalContainerEntityManagerFactoryBean entityManagerFactory(
    // Environment environment, DataSource dataSource)
    // throws ClassNotFoundException {
    // LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new
    // LocalContainerEntityManagerFactoryBean();
    //
    // entityManagerFactoryBean.setDataSource(dataSource);
    // entityManagerFactoryBean
    // .setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
    // entityManagerFactoryBean
    // .setPersistenceProviderClass(HibernatePersistenceProvider.class);
    //
    // Properties jpaProterties = new Properties();
    // jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment
    // .getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    // jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment
    // .getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
    // jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment
    // .getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
    // jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment
    // .getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
    //
    // entityManagerFactoryBean.setJpaProperties(jpaProterties);
    //
    // return entityManagerFactoryBean;
    // }

    @Bean
    public RestTemplate restClient() {
	return new RestTemplate();
    }
}
