package no.sag.treg;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("production")
public class ProductionConfiguration
{
    @Bean
    public DataSource dataSource()
    {
        return DataSourceBuilder.create()
            .url("jdbc:mysql://glamseter.mysql.domeneshop.no:3306/glamseter")
            .driverClassName("com.mysql.jdbc.Driver")
            .username("glamseter")
            .password("qTDYPrLBGk66weq")
            .build();
    }
}
