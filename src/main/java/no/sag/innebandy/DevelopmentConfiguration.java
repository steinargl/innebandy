package no.sag.innebandy;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("development")
public class DevelopmentConfiguration
{
    private static final Logger LOG = LoggerFactory.getLogger(ProductionConfiguration.class);

    @Bean
    public DataSource dataSource()
    {
        LOG.info("Using development datasource...");

        final HikariDataSource ds = new HikariDataSource();
        ds.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
        ds.addDataSourceProperty("url", "jdbc:mariadb://localhost:3306/innebandy");
        ds.addDataSourceProperty("user", "root");
        ds.addDataSourceProperty("password", "Vinter2015");
        return ds;
    }
}
