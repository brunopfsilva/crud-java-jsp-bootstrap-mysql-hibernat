package apoio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

import pool.*;
import coin.*;

public class DAO {
	
	private static EntityManagerFactory emf = null; //objecto de valor unico não vai criar varias conexoes
	
	public EntityManagerFactory geEntityManager() { // fabrica de conexoes

		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("grupominer3x");//nome da conexao contido no arquivo persistence.xm
		}
		return emf;
	}
	
	public DAO() {

	}
	
	//forma de acessar todos os metodos do hibernate
	public Session getSession(){
	    Session session = null;
	    
	    if (geEntityManager().createEntityManager().getDelegate() instanceof EntityManagerImpl) {
	        EntityManagerImpl entityManagerImpl = (EntityManagerImpl) geEntityManager().createEntityManager().getDelegate();
	       return entityManagerImpl.getSession();
	    } else {
	    	return (Session) geEntityManager().createEntityManager().getDelegate();
	    }
	}
}
