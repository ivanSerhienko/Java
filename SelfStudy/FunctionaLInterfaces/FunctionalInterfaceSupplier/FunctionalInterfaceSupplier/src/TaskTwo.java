import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TaskTwo implements Supplier<String> {
    private List<String> strings;
    private Predicate<String> predicate;
    private int index = 0;

    private TaskTwo() {}

    public TaskTwo(List<String> strings, Predicate<String> predicate) {
        this.strings = strings;
        this.predicate = predicate;
    }

    @Override
    public String get() {
        if(predicate.test(strings.get(index))) {
            index++;
            return strings.get(index);
        }

        if(index != strings.size() - 1) {
            index++;
            new TaskTwo().get();
        }

        return null;
    }

    private void incrementIndex() {
        if(index != strings.size() - 1 && !predicate.test(strings.get(index)))
            index --;
    }
}