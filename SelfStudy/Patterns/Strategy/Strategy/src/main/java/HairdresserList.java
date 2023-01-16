import java.util.ArrayList;
import java.util.List;

public class HairdresserList extends ArrayList<Hairdresser> {
    private int id;
    List <Hairdresser> hairdressers;
    public HairdresserList(int id) {
        this.id = id;
        hairdressers = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void sortHairdresserByAlphabet () {
        //some impl
    }
    public void sortHairdresserByAlphabetReverse  () {
        //some impl
    }
    public void sortHairdresserByRatingFromUpToLow  () {
        //some impl
    }
    public void sortHairdresserByRatingFromLowToUp () {
        //some impl
    }
}
