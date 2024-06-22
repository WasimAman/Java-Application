/*
 * package com.helper;
 * 
 * import org.hibernate.SessionFactory; import org.hibernate.cfg.Configuration;
 * 
 * public class FactoryProvider { private static SessionFactory factory;
 * 
 * public static SessionFactory getFactory() { if (factory == null) { try {
 * factory = new
 * Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); } catch
 * (Exception e) { e.printStackTrace(); } } return factory; } }
 */
package com.helper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
