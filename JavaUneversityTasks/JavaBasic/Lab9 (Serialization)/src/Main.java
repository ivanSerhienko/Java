import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Author a = new Author("Andrew");
        Book b1 = new Book("Margag", a);
        Book b2 = new Book("YHJD", a);
        List<Book> books = new ArrayList<Book>();
        books.add(b1); books.add(b2);

        List<Reader> readers = new ArrayList<Reader>();
        readers.add(new Reader("1", books));

        Library l = new Library("RTYUIO",readers);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("save1"));
        o.writeObject(l);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("save1"));
        Library l2 = (Library)in.readObject();
        System.out.println(l2);
    }
}
