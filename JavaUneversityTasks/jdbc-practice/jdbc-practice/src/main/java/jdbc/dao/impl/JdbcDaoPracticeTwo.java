package jdbc.dao.impl;

import jdbc.dao.AbstractJdbcDao;
import jdbc.dao.DaoPracticeTwo;

import java.sql.*;
import java.util.Arrays;

import static constants.Constants.*;

public class JdbcDaoPracticeTwo extends AbstractJdbcDao implements DaoPracticeTwo {

    @Override
    public void insertNameDuration(String name, Time time) {
        executeUpdateStatement(INSERT_NAME_DURATION_QUERY, Arrays.asList(name, time));
    }

    @Override
    public void insertIntoOrders(String telecast, String trailer, Timestamp timeStamp) {
        executeUpdateStatement(MERGE_INTO_ORDERS_QUERY, Arrays.asList(telecast, trailer, timeStamp));
    }

    @Override
    public void updateCostPerMinuteInTelecast(float perCent, String name) {
        executeUpdateStatement(UPDATE_COST_PER_MINUTE_QUERY, Arrays.asList(perCent, name));
    }

    @Override
    public void deleteTrailerFromDB(String name) {
        Connection connection = null;
        try {
            connection = createConnection();
            //connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            PreparedStatement statement = null;

            for (int i = 0; i < DELETE_TRAILER_QUERY.size(); i++) {
                statement = connection.prepareStatement(DELETE_TRAILER_QUERY.get(i));
                statement.setString(1, name);
                statement.executeUpdate();
            }

            connection.commit();
            //connection.setAutoCommit(true);
        } catch (SQLException ex) {
            assert connection != null;
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
