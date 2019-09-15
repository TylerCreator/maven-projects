import java.util.List;

public class BookReader {
    BookLibrary bookLibrary;

    public BookReader(BookLibrary bookLibrary) {
        this.bookLibrary = bookLibrary;
    }

    public List<Book> read(){
        return this.bookLibrary.search("top");
    }

}
