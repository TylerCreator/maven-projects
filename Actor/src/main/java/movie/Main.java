package movie;


import models.Actor;
import models.Role;
import models.Director;
import models.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        getPittsFilm(session);

        session.close();
    }

    public static void getMovies(Session session) {
        Query getAllMovies = session.createQuery("from Movie");
        List<Movie> movies = getAllMovies.list();
        for (Movie i : movies) {
            System.out.println("Фильм: " + i.getName());
        }
    }

    public static void getActors(Session session) {
        Query q = session.createQuery("select m from Movie as m ");

        List<Movie> movies = q.list();
        for (Movie m : movies) {
            Set<Actor> actors = m.getRoles();
            for (Actor a : actors) {
                System.out.println("Актёр: " + a.getFirst_name());
            }
        }
    }

    public static void getJulia(Session session) {
//        Query q = session.createQuery("select a from Actor as a " +
//                "where a.first_name= :name");
//        q.setParameter("name", "Julia");
//        List<Actor> actors = q.list();
//        for (Actor i : actors) {
//            System.out.println("Актёр: " +i.getFirst_name()+" "+ i.getLast_name());
//        }
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> c = cq.from(Actor.class);

        cq.where(cb.equal(c.get("first_name"), "Julia"));
        cq.select(c);
        TypedQuery<Actor> tq = (TypedQuery<Actor>) session.createQuery(cq);
        List<Actor> actors = tq.getResultList();
        for (Actor i : actors) {
            System.out.println("Актёр: " +i.getFirst_name()+" "+ i.getLast_name());
        }
    }

    public static void getPittsFilm(Session session) {
//        Query q = session.createQuery("select a from Actor as a " +
//                "where a.last_name= :name");
//        q.setParameter("name", "Pitt");
//        List<Actor> actors = q.list();
//        for (Actor i : actors) {
//            Set<Movie> movies = i.getMovies();
//            for (Movie m : movies) {
//                System.out.println("Фильмы: " + m.getName());
//            }
//
//        }
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> c = cq.from(Actor.class);

        cq.where(cb.equal(c.get("last_name"), "Pitt"));
        cq.select(c);
        TypedQuery<Actor> tq = (TypedQuery<Actor>) session.createQuery(cq);
        List<Actor> actors = tq.getResultList();
        for (Actor i : actors) {
            Set<Movie> movies = i.getMovies();
            for (Movie m : movies) {
                System.out.println("Фильмы: " + m.getName());
            }
        }
    }

    public static void getTom(Session session) {
        Query q = session.createQuery("select r from Role as r " +
                "where r.role= :r1 or r.role=:r2");
        q.setParameter("r1", "Tom");
        q.setParameter("r2", "Tommy");
        List<Role> roles = q.list();
        for (Role i : roles) {
            Movie m = i.getId().getMovie();
            Set<Director> directors = m.getDirectors();
            for (Director d : directors) {
                System.out.println("Фильмы: " + d.getFname());
            }

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

    public static void getA1999(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
        Root<Movie> c = cq.from(Movie.class);
        cq.where(cb.equal(c.get("year"), 1999));
        cq.select(c);
        //cq.select(c);
        TypedQuery<Movie> tq = (TypedQuery<Movie>) session.createQuery(cq);
        List<Movie> movies = tq.getResultList();
        for (Movie i : movies) {
            Set<Actor> actors = i.getRoles();
            for (Actor a : actors) {
                System.out.println("Актёр: " + a.getFirst_name() + " " + a.getLast_name());
            }
        }
    }

}
