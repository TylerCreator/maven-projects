import commands.Command;
import commands.CommandFactory;
import commands.CommandOne;
import commands.CommandTwo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import models.Dates;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import models.Currency;
import models.Dates;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

public class Main {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        Session session = HibernateUtil.getSessionFactory().openSession();


        session.beginTransaction();
        Scanner in = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse("2018-10-18"));
        getValue(session,1,1);
        String s = in.next();
        getCurrency(session,1,s);
        String s1 = in.next();
        String s2 = in.next();
        getBetween(session,1,s1,s2);
        session.close();

    }

    public static void getValue(Session session, long id, double val) {
        Currency currency = (Currency) session.get(Currency.class, id);
        Set<Dates> dates =currency.getDates();
//        Calendar t = Calendar.getInstance();
//        try {
//            t.setTime(sdf.parse("2018-09-01"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Date t = null;
        try {
            t = sdf.parse("2010-09-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Dates max = new Dates(t);
        for (Dates i : dates) {
            Date c = i.getDate();
            if (c.compareTo(max.getDate())==1){
                max.setValue(i.getValue());
                max.setDate(i.getDate());
            }
        }
        System.out.println(val*max.getValue()*currency.getNominal());
    }

    public static void getCurrency(Session session, long id, String date) {
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(date);
            d2 = DateUtils.addDays(d1,-5);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println(sdf.format(d1)+"\n"+sdf.format(d2));
        Query q =session.createQuery("select d from Dates as d inner join d.currency as c  where c.id =:id and d.date between :startD and :endD");
        q.setParameter("id", id);
        q.setParameter("startD", d2);
        q.setParameter("endD", d1);
        List<Dates> dates = q.list();
        for(Dates d : dates){
            Currency c = d.getCurrency();
            System.out.println(sdf.format(d.getDate())+": "+d.getValue()*c.getNominal());
        }
    }

    public static void getBetween(Session session, long id, String date1, String date2) {
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = sdf.parse(date1);
            d2 =  sdf.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Query q =session.createQuery("select d from Dates as d inner join d.currency as c  where c.id =:id and d.date between :startD and :endD");
        q.setParameter("id", id);
        q.setParameter("startD", d2);
        q.setParameter("endD", d1);
        List<Dates> dates = q.list();
        for(Dates d : dates){
            Currency c = d.getCurrency();
            System.out.println(sdf.format(d.getDate())+": "+d.getValue()*c.getNominal());
        }
    }


}
