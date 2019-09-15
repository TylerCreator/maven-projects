import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BookReader client = (BookReader) context.getBean("client");
        List<Book> books = client.read();
        System.out.println("Client read: "+ books.size()+" books");
    }
}
