package kz.reself.springdata.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "kz.reself.springdata")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.reself.springdata.repository")
public class SpringConfig {
}
