package no.sag.treg;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("development")
public class DevelopmentConfiguration
{
    private static final Logger LOG = LoggerFactory.getLogger(ProductionConfiguration.class);

   /* @Bean
    public DataSource dataSource()
    {
        LOG.info("Using development datasource...");

        return DataSourceBuilder.create()
            .url("jdbc:mariadb://localhost:3306/innebandy")
            .driverClassName("org.mariadb.jdbc.Driver")
            .username("root")
            .password("Vinter2015")
            .build();
    }*/

    @Bean
    public DataSource dataSource()
    {
        LOG.info("Using development datasource...");

        final HikariDataSource ds = new HikariDataSource();
       // ds.setMaximumPoolSize(30);
        ds.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
        ds.addDataSourceProperty("url", "jdbc:mariadb://localhost:3306/innebandy");
        ds.addDataSourceProperty("user", "glamseter");
        ds.addDataSourceProperty("password", "qTDYPrLBGk66weq");
      /*  ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        ds.addDataSourceProperty("useServerPrepStmts", true);*/
        return ds;
    }
}
