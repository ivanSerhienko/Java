package jdbc.dao.impl;

import entity.Customer;
import entity.Orders;
import entity.Telecast;
import entity.Trailer;
import jdbc.dao.AbstractJdbcDao;
import jdbc.dao.DaoGeneral;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static constants.Constants.*;

public class JdbcDaoGeneral extends AbstractJdbcDao implements DaoGeneral {
    @Override
    public List<Customer> findAllCustomer() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_CUSTOMER);
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(resultSet.getInt(ID_CUSTOMER_COLUMN_NAME));
                customer.setFirm(resultSet.getString(CUSTOMER_FIRM_COLUMN_NAME));
                customer.setContactPerson(resultSet.getString(CUSTOMER_CONTACT_PERSON_COLUMN_NAME));
                customer.setTelephone(resultSet.getString(CUSTOMER_TELEPHONE_COLUMN_NAME));
                customer.setCode(resultSet.getInt(CUSTOMER_CODE_COLUMN_NAME));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Orders> findAllOrders() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_ORDERS);
            List<Orders> orders = new ArrayList<>();
            while (resultSet.next()) {
                Orders order = new Orders();
                order.setRefCustomer(resultSet.getInt(ORDERS_REF_CUSTOMER_COLUMN_NAME));
                order.setRefTelecast(resultSet.getInt(ORDERS_REF_TELECAST_COLUMN_NAME));
                order.setRefTrailer(resultSet.getInt(ORDERS_REF_TRAILER_COLUMN_NAME));
                order.setReleaseDate(resultSet.getTimestamp(ORDERS_RELEASE_DATE_COLUMN_NAME));
                orders.add(order);
            }
            return orders;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }



    @Override
    public List<Trailer> findAllTrailer() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_TRAILER);
            List<Trailer> trailers = new ArrayList<>();
            while (resultSet.next()) {
                Trailer trailer = new Trailer();
                trailer.setIdTrailer(resultSet.getInt(ID_TRAILER_COLUMN_NAME));
                trailer.setName(resultSet.getString(TRAILER_NAME_COLUMN_NAME));
                trailer.setDuration(resultSet.getTime(TRAILER_DURATION_COLUMN_NAME));
                trailers.add(trailer);
            }
            return trailers;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
