package ru.isu.auth;


import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.isu.models.Right;
import ru.isu.models.Role;
import ru.isu.models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args){



        auth("ilya", "second");
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        //ADD MENU WITH DISHES
//        session.beginTransaction();
//
//        session.getTransaction().commit();
//        session.close();
        System.out.println("the end");
        System.exit(0);
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return sb.toString();
    }

    public static String getHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return bytesToHexString(md.digest(pass.getBytes()));
    }

    public static void auth(String login, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User as user where user.login = :login ");
        query.setParameter("login", login);
        User user = (User) query.uniqueResult();
        if (user == null) {
            System.out.println("Пользователь не найден");
            return;
        }
        System.out.println("Пользователь: "+ user.getName());
//        try {
//            System.out.println(user.getPassword());
//            System.out.println(getHash(password));
//            System.out.println(user.getPassword().equals(getHash(password)));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

        try {
            if (user.getPassword().equals(getHash(password))){
                Role role = user.getRole();
                System.out.println("Роль: "+ role.getTitle());
                Set<Right> rights = role.getRights();
                System.out.println(rights.size());
                for (Right i :rights){
                    System.out.println("    Право: " + i.getRight());
                }

//                }
            }
            else
                System.out.println("Неверный пароль");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        ;
        session.getTransaction().commit();
        session.close();

    }
}
