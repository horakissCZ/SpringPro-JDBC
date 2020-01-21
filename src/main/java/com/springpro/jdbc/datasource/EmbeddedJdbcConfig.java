package com.springpro.jdbc.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class EmbeddedJdbcConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        return databaseBuilder
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:db/h2/schema.sql", "classpath:db/h2/test-data.sql")
                .build();
    }

    @Bean
    public SingerDao singerDao() {
        JdbcSingerDao singerDao = new JdbcSingerDao();
        singerDao.setDataSource(dataSource());
        return singerDao;
    }
}
