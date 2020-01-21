package com.springpro.jdbc.datasource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import javax.sql.DataSource;

public class JdbcSingerDao implements SingerDao, InitializingBean {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set data source on SingerDao");
        }
    }
}
