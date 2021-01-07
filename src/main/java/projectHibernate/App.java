package projectHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        //System.out.println(factory);
        //creating student
        Student st=new Student();
        st.setId(101);
        st.setCity("gumla");
        st.setName("parul");
        Certificate certificate= new Certificate();
        certificate.setCourse("java");
        certificate.setDuration("1 year");
        st.setCertificate(certificate);
        
        System.out.println(st);
        Session session=factory.openSession();
         Transaction tx=session.beginTransaction();
        session.save(st);
        
        tx.commit();
        session.close();
    }
}
