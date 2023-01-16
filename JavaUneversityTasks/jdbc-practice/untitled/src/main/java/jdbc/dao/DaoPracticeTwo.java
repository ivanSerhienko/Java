package jdbc.dao;

import java.sql.Time;
import java.sql.Timestamp;

public interface DaoPracticeTwo {
    void insertNameDuration(String name, Time time);

    void insertIntoOrders(String telecast, String trailer, Timestamp timeStamp);

    void updateCostPerMinuteInTelecast(float perCent, String name);

    void deleteTrailerFromDB(String name);
}
