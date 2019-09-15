package movie;


import models.Director;
import models.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        getD2000(session);

        session.close();
    }

    public static void getMovies(Session session) {
        Query getAllMovies = session.createQuery("from Movie");
        List<Movie> movies = getAllMovies.list();
        for (Movie i : movies) {
            System.out.println("Фильм: " + i.getName());
        }
    }

    public static void getD2000(Session session) {
        Query q = session.createQuery("select m.directors from Movie as m " +
                "where m.year= :year");
        q.setParameter("year", new Long(2000));
        List<Director> directors = q.list();
        for (Director i : directors) {
            System.out.println("Режисер: " + i.getFname());
        }
    }

    public static void getM9520(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> c = cq.from(Movie.class);

        cq.where(cb.between(c.get("year"), 1995, 2000));
        cq.select(c);
        cq.orderBy(cb.asc(c.get("year")));
        //cq.select(c);
        TypedQuery<Movie> tq = (TypedQuery<Movie>) session.createQuery(cq);
        List<Movie> movies = tq.getResultList();
        for (Movie i : movies) {
            System.out.println("Фильм: " + i.getName());
        }
    }

    public static void top5MD(Session session) {
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Director> cq = cb.createQuery(Director.class);
//        Root<Movie> c = cq.from(Movie.class);
//        cq.orderBy(cb.desc(c.get("rank")));
//        Join<Movie,Director> d = c.join("directors");
//        cq.select(d);
//        TypedQuery<Director> tq = (TypedQuery<Director>) session.createQuery(cq);
//        tq.setFirstResult(0).setMaxResults(5);
//        List<Director> dir = tq.getResultList();
//        for (Director i : dir) {
//            System.out.println("Директор: " + i.getFname());
//        }


//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
//        Root<Movie> c = cq.from(Movie.class);
//        cq.orderBy(cb.desc(c.get("rank")));
//        TypedQuery<Movie> tq = (TypedQuery<Movie>) session.createQuery(cq);
//        tq.setFirstResult(0).setMaxResults(5);
//        List<Movie> dir = tq.getResultList();
//        for (Movie i : dir) {
//            Set<Director> dset = i.getDirectors();
//            for (Director j : dset) {
//                System.out.println("Фильм: " + j.getFname());
//            }
//        }

    }
    public static void worse(Session session) {
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Director> cq = cb.createQuery(Director.class);
//        Root<Movie> c = cq.from(Movie.class);
//        cq.orderBy(cb.desc(c.get("rank")));
//        Join<Movie,Director> d = c.join("directors");
//        cq.select(d);
//        TypedQuery<Director> tq = (TypedQuery<Director>) session.createQuery(cq);
//        tq.setFirstResult(0).setMaxResults(5);
//        List<Director> dir = tq.getResultList();
//        for (Director i : dir) {
//            System.out.println("Фильм: " + i.getFname());
//        }


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> c = cq.from(Movie.class);
        cq.orderBy(cb.asc(c.get("rank")));
        TypedQuery<Movie> tq = (TypedQuery<Movie>) session.createQuery(cq);
        tq.setMaxResults(1);
//        List<Movie> dir = tq.getResultList();
        Movie m = tq.getSingleResult();
        System.out.println("Фильм " + m.getName());
//        for (Movie i : dir) {
//            System.out.println("Фильм " + i.getName());
//        }

    }

    public static void davidM(Session session) {



        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> d = cq.from(Movie.class);
        Join<Movie, Director> md = d.join("directors");
        cq.where(cb.equal(md.get("fname"), "David"));
        TypedQuery<Movie> tq = (TypedQuery<Movie>) session.createQuery(cq);
        List<Movie> dir = tq.getResultList();
        for (Movie i : dir) {
            System.out.println("Фильм " + i.getName());
        }
    }

}
