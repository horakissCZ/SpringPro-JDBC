package com.springpro.jdbc.init.config;

import com.springpro.jdbc.common.SingerDao;
import com.springpro.jdbc.init.JdbcSingerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static com.springpro.jdbc.common.Constants.SCHEMA_DB_SCRIPT_PATH;
import static com.springpro.jdbc.common.Constants.TEST_DATA_SCRIPT_PATH;

@Slf4j
@Configuration
public class EmbeddedJdbcConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        return databaseBuilder
                .setType(EmbeddedDatabaseType.H2)
                .addScripts(SCHEMA_DB_SCRIPT_PATH, TEST_DATA_SCRIPT_PATH)
                .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public SingerDao singerDao() {
        return new JdbcSingerDao(dataSource(), jdbcTemplate());
    }

}
