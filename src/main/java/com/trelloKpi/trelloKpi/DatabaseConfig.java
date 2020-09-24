package com.trelloKpi.trelloKpi;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value(("${spring.datasource.driverClassName}"))
    private String driver;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        String uri = System.getenv("DATABASE_URL");
        String url = "jdbc:postgresql://" + uri.split("@")[1];
        String username = uri.split("@")[0].replace("postgres://", "").split(":")[0];
        String password = uri.split("@")[0].replace("postgres://", "").split(":")[1];
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);
        config.setUsername(username);
        config.setPassword(password);
        return new HikariDataSource(config);
    }

}
