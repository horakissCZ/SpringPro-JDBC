package com.springpro.jdbc.init;

import com.springpro.jdbc.common.Singer;
import com.springpro.jdbc.common.SingerDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class JdbcSingerDao implements SingerDao, InitializingBean {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Singer> findAll() {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        var sql =
                """
                select first_name || ' ' || last_name from MUSICDB.SINGER where id = :singerId
                """;
        var namedParameters = Map.of("singerId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
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

    @Override
    public void afterPropertiesSet() {
        if (namedParameterJdbcTemplate ==  null) {
            throw new BeanCreationException ("Null NamedParameterJdbcTemplate on  SingerDao");
        }
    }
}
