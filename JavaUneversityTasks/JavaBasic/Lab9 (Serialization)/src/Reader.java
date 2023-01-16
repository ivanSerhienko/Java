import java.io.*;
import java.util.List;

public class Reader implements Externalizable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Book> books;

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Reader(){}

    public Reader(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeObject(books);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.books = (List<Book>) in.readObject();
    }
}
