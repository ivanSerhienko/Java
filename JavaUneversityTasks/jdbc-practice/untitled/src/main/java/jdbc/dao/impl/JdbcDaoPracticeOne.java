package jdbc.dao.impl;

import jdbc.dao.AbstractJdbcDao;
import jdbc.dao.DaoPracticeOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.Constants.*;

public class JdbcDaoPracticeOne extends AbstractJdbcDao implements DaoPracticeOne {

    @Override
    public Map<String, Integer> findTelecastsByCost(int cost) {
        try (Connection connection = createConnection(); PreparedStatement statement = connection.prepareStatement(FIND_TELECAST_BY_COST_QUERY)) {
            statement.setInt(1, cost);
            ResultSet resultSet = statement.executeQuery();
            Map<String, Integer> map = new HashMap<>();

            while (resultSet.next())
                map.put(resultSet.getString(TELECAST_NAME_COLUMN_NAME), resultSet.getInt(TELECAST_RATE_COLUMN_NAME));

            return map;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<String> findTelecastsByTrailer(String trailer) {
        try (Connection connection = createConnection(); PreparedStatement statement = connection.prepareStatement(FIND_TELECAST_BY_TRAILER_QUERY)) {
            statement.setString(1, trailer);
            ResultSet resultSet = statement.executeQuery();
            List<String> strings = new ArrayList<>();
            while (resultSet.next()) {
                strings.add("NAME: " + resultSet.getString(TELECAST_NAME_COLUMN_NAME));
                strings.add("RELEASE_DATE: " + resultSet.getString(ORDERS_RELEASE_DATE_COLUMN_NAME));
            }
            return strings;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<String> findTranslationCostByName(String name) {
        try (Connection connection = createConnection(); PreparedStatement statement = connection.prepareStatement(FIND_TRANSLATION_COST_BY_NAME_QUERY)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            List<String> strings = new ArrayList<>();
            while (resultSet.next()) {
                strings.add("NAME: " + resultSet.getString(TELECAST_NAME_COLUMN_NAME));
                strings.add("TRANSLATION_COST: " + resultSet.getInt(TRANSLATION_COST_COLUMN_NAME));
            }
            return strings;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int findAmountTelecastsUponRate(int rate) {
        try (Connection connection = createConnection(); PreparedStatement statement = connection.prepareStatement(FIND_AMOUNT_TELECASTS_UPON_RATE_QUERY)) {
            statement.setInt(1, rate);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(AMOUNT_TELECASTS_COLUMN_NAME);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<String> findTelecastsAndTrailerByReleaseDate(Timestamp timeStamp) {
        try (Connection connection = createConnection(); PreparedStatement statement = connection.prepareStatement(FIND_TELECASTS_AND_TRAILER_BY_RELEASE_DARE_QUERY)) {
            statement.setTimestamp(1, timeStamp);
            ResultSet resultSet = statement.executeQuery();
            List<String> strings = new ArrayList<>();
            while (resultSet.next()) {
                strings.add("TELECAST: " + resultSet.getString(TELECAST_COLUMN_NAME));
                strings.add("TRAILER: " + resultSet.getString(TRAILER_COLUMN_NAME));
            }
            return strings;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
