import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {

    private String name;
    private transient List<Book> books;
    private List<Reader> readers;

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

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public Library(){}

    public Library(String name, List<Reader> readers) {
        this.name = name;
        this.readers = readers;
        CollectBooks();
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + books +
                ", readers=" + readers +
                '}';
    }

    private void CollectBooks(){
        List<Book> books = new ArrayList<Book>();

        for(Reader reader: this.readers)
            for(Book book: reader.getBooks())
                books.add(book);

        this.books = books;
    }

    private void writeObject(ObjectOutputStream OutputStream) throws IOException
    {
        OutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException
    {
        inputStream.defaultReadObject();
        CollectBooks();
    }
//
//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeUTF(this.name);
//        out.writeObject(this.readers);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        this.name = in.readUTF();
//        this.readers = (List<Reader>) in.readObject();
//        CollectBooks();
//    }
}
