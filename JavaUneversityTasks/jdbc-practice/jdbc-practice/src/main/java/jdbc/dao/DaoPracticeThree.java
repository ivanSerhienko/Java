package jdbc.dao;

import entity.Telecast;
import entity.Trailer;

import java.util.List;
import java.util.Scanner;

public interface DaoPracticeThree {
    void insertTrailer(Trailer trailer);

    List<Telecast> findAllTelecast();

    void printTable(String tableName);
}
