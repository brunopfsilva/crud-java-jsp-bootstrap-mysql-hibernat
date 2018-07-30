package coin;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import apoio.DAO;
import coin.Coin;

public class coinDAO extends DAO{
	
	//salva
	public void salvarCoin(Coin coin) {
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(coin);
			em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	//atualizar
	public void updateCoin(Coin coin) {
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Coin c = em.find(Coin.class, coin.getId());
			c.setNome(coin.getNome());
			c.setLink(coin.getLink());
			c.setWallet(coin.getWallet());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	
	//deleta por objeto
	public void deleteCoin(Coin coin) {
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Coin c = em.find(Coin.class, coin.getId());
			em.remove(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	//recupera objeto
	public Coin getById(int idCoin) {
		EntityManager em = geEntityManager().createEntityManager();
		return em.find(Coin.class, idCoin);
	}
	//lista todos
	public List<Coin>exibir(){
		EntityManager em = geEntityManager().createEntityManager();
		
		try {
			Query q = em.createQuery("select object(c) from Coin as c");
			q.setMaxResults(5);
			return q.getResultList();
		} finally {
			em.close();		
		}
	}
	
	//lista todos
	public List<Coin> exibir_by_name(String nome){		
		EntityManager em = geEntityManager().createEntityManager();

		//Session session = null;
		
		//gt() : maior que
		//ge() : maior ou igual que
		//lt() : menor que
		//le() : menor ou igual que
		
		Criteria criteria = getSession().createCriteria(Coin.class);
		//criteria.add(Restrictions.eq("nome", "ethereum"));
		criteria.add(Restrictions.like("nome", "%"+ nome +"%"));
		
		return criteria.list();
	}	

}
