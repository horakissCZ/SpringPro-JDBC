package com.springpro.jdbc.plain;

import com.springpro.jdbc.common.Singer;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PlainSingerDao implements SingerDao {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("Problem loading DB driver! " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/MUSICDB?useSSL=true",
                "prospring5", "prospring5");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Problem closing the connection to the database!" + e.getMessage());
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from SINGER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDay(resultSet.getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException e) {
            log.error("Problem with executing SELECT!" + e.getMessage());
        } finally {
            closeConnection(connection);
        }

        return result;
    }

    @Override
    public String findNameById(Long id) {
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
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    """
                    insert into SINGER (first_name, last_name, birth_date)
                    values (?, ?, ?)
                    """,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDay());
            statement.execute();

            ResultSet generateKeys = statement.getGeneratedKeys();
            if (generateKeys.next()) {
                singer.setId(generateKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException e) {
            log.error("Problem executing INSERT! " + e.getMessage());
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from SINGER where id = ?");
            statement.setLong(1, singerId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            log.error("Problem to execute DELETE! " + e.getMessage());
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
