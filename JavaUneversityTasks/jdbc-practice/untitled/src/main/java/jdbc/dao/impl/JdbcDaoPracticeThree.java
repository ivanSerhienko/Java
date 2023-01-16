package jdbc.dao.impl;

import static constants.Constants.*;

import entity.Telecast;
import entity.Trailer;
import jdbc.dao.AbstractJdbcDao;
import jdbc.dao.DaoPracticeThree;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JdbcDaoPracticeThree extends AbstractJdbcDao implements DaoPracticeThree {

    @Override
    public void insertTrailer(Trailer trailer) {
        executeUpdateStatement(INSERT_TRAILER_QUERY, Arrays.asList(trailer.getIdTrailer(), trailer.getName(), trailer.getDuration()));
    }

    @Override
    public List<Telecast> findAllTelecast() {
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(FIND_ALL_TELECAST);
            List<Telecast> telecasts = new ArrayList<>();

            while (resultSet.next()) {
                Telecast telecast = new Telecast();
                telecast.setIdTelecast(resultSet.getInt(TELECAST_ID_COLUMN_NAME));
                telecast.setName(resultSet.getString(TELECAST_NAME_COLUMN_NAME));
                telecast.setCostMinute(resultSet.getFloat(TELECAST_COST_PER_MINUTE_COLUMN_NAME));
                telecast.setRate(resultSet.getInt(TELECAST_RATE_COLUMN_NAME));
                telecasts.add(telecast);
            }

            connection.commit();
            return telecasts;
        } catch (SQLException ex) {
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    @Override
    public void printTable(String tableName) {
        Connection connection = null;
        try {
            connection = createConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_DATA_BY_TABLE_NAME + tableName);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int i = 1;
            while (resultSet.next()) {
                System.out.println("COLUMN NAME: " + resultSetMetaData.getColumnName(i) + " TYPE: " + resultSetMetaData.getColumnTypeName(i));
                i++;
            }
        } catch (SQLException ex) {
            try {
                assert connection != null;
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(ex);
            }
        }
    }
}
