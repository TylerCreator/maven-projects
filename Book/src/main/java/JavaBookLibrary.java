import java.util.List;
import java.util.stream.Collectors;


public class JavaBookLibrary implements BookLibrary {
    List<Book> books;

    public JavaBookLibrary(List<Book> books) {
        this.books=books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public List<Book> search(String title) {
        return this.books.stream().filter(book->book.getTitle().equals(title)).collect(Collectors.toList());
    }
}
