package com.digital.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private HibernateUtil() {
	}
	
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
            // Create the SessionFactory from hibernate.cfg.xml
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("Initial SessionFactory creation success.");
            return sessionFactory;

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }


}
