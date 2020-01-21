package com.springpro.jdbc.exceptionhandling;

import com.springpro.jdbc.datasource.SingerDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class JdbcSingerDao implements SingerDao, InitializingBean {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        MySQLErrorCodesTranslator mySQLErrorCodesTranslator = new MySQLErrorCodesTranslator();
        mySQLErrorCodesTranslator.setDataSource(dataSource);
        jdbcTemplate.setExceptionTranslator(mySQLErrorCodesTranslator);
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
