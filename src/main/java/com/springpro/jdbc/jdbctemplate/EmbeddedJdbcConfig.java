package com.springpro.jdbc.jdbctemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class EmbeddedJdbcConfig {

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
            return databaseBuilder.setType(EmbeddedDatabaseType.H2).addScripts("classpath:db/h2/schema.sql", "classpath:db/h2/test-data.sql").build();
        } catch (Exception e) {
            log.error("Embedded data source cannot be created. " + e.getMessage());
            return null;
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public JdbcSingerDao singerDao() {
        JdbcSingerDao singerDao = new JdbcSingerDao();
        singerDao.setJdbcTemplate(jdbcTemplate());
        return singerDao;
    }
}
