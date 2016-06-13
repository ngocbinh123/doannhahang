package hcmus.maven.home;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateHome {
	private static final SessionFactory sessionFactory;
	static { 
		 try {
			 sessionFactory = new Configuration()
			            .configure()
			            .buildSessionFactory();
		 } catch (Throwable ex) {
			 throw new ExceptionInInitializerError(ex);
		 	}
	 }
	 public static SessionFactory getSessionFactory() {
		 return sessionFactory;
	 }
	 
	 public static Session getSession(){
		 Session session = sessionFactory.openSession();
		 return session;
	 }
}
