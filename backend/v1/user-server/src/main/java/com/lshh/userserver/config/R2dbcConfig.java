package com.lshh.userserver.config;

import io.r2dbc.spi.ConnectionFactory;
import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.lshh.userserver.model.repository")
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Bean
    public MariadbConnectionConfiguration connectionConfiguration() {
        return MariadbConnectionConfiguration.builder()
            .host("localhost")
            .port(3306)
            .username("root")
            .password("1234")
            .database("boilerplate")
            .build();
    }

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new MariadbConnectionFactory(connectionConfiguration());
    }
}