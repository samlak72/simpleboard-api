package com.samlasoft.simpleboard.config;

import lombok.extern.java.Log;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.SQLException;

@Log
@Configuration
@Profile("local")
public class H2ServerConfiguration {

    @Value("${spring.h2.port}")
    String port;

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSource() throws SQLException {

        log.info("port: "+port);
        Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", port).start();

        return new com.zaxxer.hikari.HikariDataSource();
    }
}
