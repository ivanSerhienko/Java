package jdbc.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface DaoPracticeOne {
    Map<String, Integer> findTelecastsByCost(int cost);

    List<String> findTelecastsByTrailer(String trailer);

    List<String> findTranslationCostByName(String name);

    int findAmountTelecastsUponRate(int rate);

    List<String> findTelecastsAndTrailerByReleaseDate(Timestamp timeStamp);
}
