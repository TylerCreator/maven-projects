/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.isu.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.isu.mav.HibernateUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



@Getter
@Setter
@ToString(of="name")
public class Menu implements Serializable {
    private Long id;
    private String name;
    private java.util.Date date;
    private List menuItems;

    public List getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List menuItems) {
        this.menuItems = menuItems;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Menu(){
    }

    public Menu(String name, String date) {
        this.name = name;
        try {
            this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public Menu(String name) {
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Menu addMenu(String name, String date, List dishes){
        Menu menu = new Menu(name, date);;
        menu.setMenuItems(dishes);
        return menu;
    }

    public static Menu getMenu(Session session, Long id){
        Menu menu = (Menu)session.get(Menu.class,  new Long(id) );
        System.out.println("Меню: " + menu.getName());
        List menuItems = menu.getMenuItems();
        for (Iterator iterator2 = menuItems.iterator(); iterator2.hasNext();){
            MenuItem mi = (MenuItem) iterator2.next();
            System.out.println("    Блюдо: " + mi.getName());
        }
        return menu;
    }

    public static Menu addMenuItem(Session session, Long id, String name){
        Menu menu = (Menu)session.get(Menu.class,  new Long(id) );
        System.out.println("Меню: " + menu.getName());
        List menuItems2 = menu.getMenuItems();
        menuItems2.add(new MenuItem(name));
        return menu;
    }
}
