import java.util.function.Supplier;

public class TaskOne implements Supplier<String> {
    private String string;

    public TaskOne(String string) {
        this.string = string;
    }

    @Override
    public String get() {
        return string.split(" ")[0];
    }
}
