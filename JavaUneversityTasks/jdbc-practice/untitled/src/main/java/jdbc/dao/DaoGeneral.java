package jdbc.dao;

import entity.*;

import java.util.List;

public interface DaoGeneral {
    List<Customer> findAllCustomer();

    List<Orders> findAllOrders();

    List<Trailer> findAllTrailer();
}
