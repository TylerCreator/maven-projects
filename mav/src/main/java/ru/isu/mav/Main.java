package ru.isu.mav;

import org.hibernate.Session;
import ru.isu.models.Author;
import ru.isu.models.Book;

public class Main {
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Author a = new Author();
        a.setName("Cool");
        session.save(a);
        Book b = new Book();
        b.setName("Букварь");
        b.setAuthor(a);
        session.save(b);
        session.getTransaction().commit();
        session.close();
        System.out.println("the end");
        System.exit(0);
    }
}
