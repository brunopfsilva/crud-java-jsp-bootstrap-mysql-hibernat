package pool;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import apoio.DAO;
import coin.Coin;

public class poolDAO extends DAO{
	//salva
	public void salvarPool(Pool pool) {
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(pool);
			em.getTransaction().commit();
			
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	//atualizar
	public void updatePool(Pool pool) {
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Pool p = em.find(Pool.class, pool.getId());
			p.setNome(pool.getNome());
			p.setLink(pool.getLink());
			p.setSoftware(pool.getSoftware());
			p.setCommando(pool.getCommando());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	
	//deleta por objeto
	public void deletePool(Pool pool) {
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Pool p = em.find(Pool.class, pool.getId());
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	//recupera objeto
	public Pool getById(int idPool) {
		EntityManager em = geEntityManager().createEntityManager();
		return em.find(Pool.class, idPool);
	}
	//lista todos
	public List<Pool>exibir(){
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			Query q = em.createQuery("select object(p) from Pool as p");
			q.setMaxResults(5);
			//long count = (long) q.getResultList().get(0);
			//if(count >0) {
				
	//		}
			return q.getResultList();
		} finally {
			em.close();		
		}
	}
	
	//lista todos
	public List<Pool> exibir_by_name(String nome){		
		EntityManager em = geEntityManager().createEntityManager();

		//Session session = null;
		
		//gt() : maior que
		//ge() : maior ou igual que
		//lt() : menor que
		//le() : menor ou igual que
		
		Criteria criteria = getSession().createCriteria(Pool.class);
		//criteria.add(Restrictions.eq("nome", "ethereum"));
		criteria.add(Restrictions.like("nome", "%"+ nome +"%"));
		return criteria.list();
	}	

}
