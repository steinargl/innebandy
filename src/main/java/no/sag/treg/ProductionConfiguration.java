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
@Profile("production")
public class ProductionConfiguration
{
    private static final Logger LOG = LoggerFactory.getLogger(ProductionConfiguration.class);

  /*  @Bean
    public DataSource dataSource()
    {
        LOG.info("Using production datasource...");

            return DataSourceBuilder.create()
            .url("jdbc:mariadb://glamseter.mysql.domeneshop.no:3306/glamseter")
            .driverClassName("org.mariadb.jdbc.Driver")
            .username("glamseter")
            .password("qTDYPrLBGk66weq")
            .build();
    }*/

    @Bean
    public DataSource dataSource()
    {
        LOG.info("Using production datasource...");

        final HikariDataSource ds = new HikariDataSource();
       // ds.setMaximumPoolSize(30);
        ds.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
        ds.addDataSourceProperty("url", "jdbc:mariadb://glamseter.mysql.domeneshop.no:3306/glamseter");
        ds.addDataSourceProperty("user", "glamseter");
        ds.addDataSourceProperty("password", "qTDYPrLBGk66weq");
      /*  ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        ds.addDataSourceProperty("useServerPrepStmts", true);*/
        return ds;
    }



}
