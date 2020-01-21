package com.springpro.jdbc.jdbctemplate;

import com.springpro.jdbc.common.Singer;
import com.springpro.jdbc.plain.SingerDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcSingerDao implements SingerDao, InitializingBean {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select first_name || ' ' || last_name from MUSICDB.SINGER where id = ?",
                new Object[]{id}, String.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public List<Singer> findAll() {
        return null;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {

    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
