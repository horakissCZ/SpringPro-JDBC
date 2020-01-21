package com.springpro.jdbc;

import com.springpro.jdbc.drivermanagerdatasource.DbConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class DbConfigTest {

    @Test
    public void testOne() throws SQLException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }

    @Test
    public void testTwo() throws SQLException {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);
        testDataSource(dataSource);
        ctx.close();
    }

    private void testDataSource(DataSource dataSource) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT 1");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int mockVal = resultSet.getInt("1");
                assertEquals(1, mockVal);
            }
        } catch (Exception e) {
            log.debug("Something  unexpected happened.", e);
        }
    }
}
