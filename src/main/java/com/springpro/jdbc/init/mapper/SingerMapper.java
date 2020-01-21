package com.springpro.jdbc.init.mapper;

import com.springpro.jdbc.common.Singer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class SingerMapper implements RowMapper<Singer> {

    @Override
    public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Singer.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .birthDay(rs.getDate("birth_date"))
                .build();
    }
}
