package ru.isu.mav;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.isu.models.Menu;
import ru.isu.models.MenuItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static ru.isu.models.Menu.addMenu;
import static ru.isu.models.Menu.getMenu;

public class Main {
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //ADD MENU WITH DISHES
        session.beginTransaction();

        List<MenuItem> set1 = new ArrayList();
        set1.add(new MenuItem("вок"));
        set1.add(new MenuItem("салат"));
        set1.add(new MenuItem("салат"));

        Menu menu = addMenu("НовоеМеню", "2017-05-24", set1);

        session.save(menu);
        session.getTransaction().commit();



        //FIND MENU BY ID
        session.beginTransaction();
        menu = (Menu)session.get(Menu.class,  new Long(26) );
        System.out.println("Меню: " + menu.getName());
        List menuItems = menu.getMenuItems();
        for (Iterator iterator2 = menuItems.iterator(); iterator2.hasNext();){
            MenuItem mi = (MenuItem) iterator2.next();
            System.out.println("    Блюдо: " + mi.getName());
        }

        session.getTransaction().commit();


        //ADD MENUITEM INTO MENU
        session.beginTransaction();
        Menu menu2 = (Menu)session.get(Menu.class,  new Long(26) );
        System.out.println("Меню: " + menu2.getName());
        List menuItems2 = menu2.getMenuItems();
        menuItems2.add(new MenuItem(" печенька"));
        session.save(menu2);
        session.getTransaction().commit();

        //FIND MENU BY ID
        session.beginTransaction();
        Menu menu3 = (Menu)session.get(Menu.class,  new Long(26) );
        System.out.println("Меню: " + menu3.getName());
        List menuItems3 = menu3.getMenuItems();
        for (Iterator iterator2 = menuItems3.iterator(); iterator2.hasNext();){
            MenuItem mi = (MenuItem) iterator2.next();
            System.out.println("    Блюдо: " + mi.getName());
        }
        session.getTransaction().commit();

        session.close();
//
//        session.close();
//        System.out.println(getMenu((long) 10));
//        System.out.println(getMenu((long) 10).getMenuItems());
        System.out.println("the end");
        System.exit(0);
    }
}
