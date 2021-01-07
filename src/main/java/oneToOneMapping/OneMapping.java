package oneToOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneMapping {

	public static void main(String[] args)
	{
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Question q=new Question();
        q.setQuestionId(123);
        q.setQuestion("what is java");
        
        Answer answer= new Answer();
        answer.setAnswerId(345);
        answer.setAnswer("java is a programming language");
        answer.setQuestion(q);
        q.setAnswer(answer);
        
        
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
       session.save(q);
       session.save(answer);
       
       tx.commit();
       session.close();
	}
}
