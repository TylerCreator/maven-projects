import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {

    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String title) {
        this.title = title;
    }
    public Book() {
    }
}
