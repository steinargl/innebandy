package no.sag.treg;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DefaultConfiguration
{
    @Bean
    public DataSource dataSource()
    {
        return DataSourceBuilder.create()
            .url("jdbc:mariadb://localhost:3306/innebandy")
            .driverClassName("org.mariadb.jdbc.Driver")
            .username("root")
            .password("Vinter2015")
            .build();
    }
}
