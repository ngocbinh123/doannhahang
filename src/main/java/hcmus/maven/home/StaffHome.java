package hcmus.maven.home;


import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import hcmus.maven.pojo.*;
import hcmus.maven.home.HibernateHome;;
public class StaffHome {
	public static Staff dangNhap(Staff s){
		Session session = HibernateHome.getSessionFactory().openSession();
		try{
			String _sql = "from Staff s where s.accName=:name and s.password=:pass";
			Query query= session.createQuery(_sql)
					.setParameter("name", s.getAccName()) 
					.setParameter("pass", s.getPassword());
			s = (Staff) query.uniqueResult();
			return s;
		}catch(Exception ex){
			 System.err.println(ex);
		}finally {
			session.close();
		}
		return null;
		
	}
}
