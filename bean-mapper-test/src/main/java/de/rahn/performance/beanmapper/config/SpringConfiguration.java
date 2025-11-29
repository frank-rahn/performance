package de.rahn.performance.beanmapper.config;

import https.xmlns_frank_rahn_de.types.testtypes._1.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"de.rahn.performance.beanmapper"})
public class SpringConfiguration {
  @Bean
  ObjectFactory objectFactory() {
    return new ObjectFactory();
  }
}
