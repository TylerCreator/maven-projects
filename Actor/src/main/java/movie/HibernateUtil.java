package movie;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author User05
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;// настройка и работа с сессиями (фабрика сессий)

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	            // получение реестра сервисов (http://docs.jboss.org/hibernate/orm/5.3/integrationsGuide/html_single/)
                .configure() // настройки из hibernate.cfg.xml
                .build();
        try {
            // MetadataSources - для работы с метаданными маппинга объектов

            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            System.out.println("good");
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.

            StandardServiceRegistryBuilder.destroy( registry );
            System.out.println("bad");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
