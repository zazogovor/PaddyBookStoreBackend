package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Book;
import entity.Review;
import entity.User;


public class PersistenceUtil implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("dt354rel");
	
	
	public static void persist(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		em.close();
	}

	public static void remove(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object mergedEntity = em.merge(entity);
		em.remove(mergedEntity);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Object merge(Object entity) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		entity = em.merge(entity);
		em.getTransaction().commit();		
		em.close();
		return entity;
	}

	public static EntityManager createEM() {
		return emf.createEntityManager();
	}
	

	public static List<User> findAllUsers(){
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) 
				em.createNamedQuery("User.findAll").getResultList();
		em.close();
		
		return users;
		
	}

	public static User userLogin(String username, String password){
		EntityManager em = emf.createEntityManager();
		User u =(User) em.createNamedQuery("User.login").setParameter("username", username)
		.setParameter("password", password).getSingleResult();

		em.close();

		return u;
	}
	
	public static User findUserByUsername(String username){
		
		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>) 
				em.createNamedQuery("User.findByUsername").
				setParameter("username", username).getResultList();
		em.close();
		
		if (users.size() == 0)
			return null;
		else 
			return users.get(0);
	}

	public static User findUserById(int id){

		EntityManager em = emf.createEntityManager();
		List<User> users = (List<User>)
				em.createNamedQuery("User.findById").
						setParameter("id", id).getResultList();
		em.close();

		if (users.size() == 0)
			return null;
		else
			return users.get(0);
	}
	
	
	
	public static List<Review> findAllReviews(){
		EntityManager em = emf.createEntityManager();
		List<Review> reviews = (List<Review>) 
				em.createNamedQuery("Review.findAll").getResultList();
		em.close();
		
		return reviews;
		
	}
	
	public static Review findReviewById(int id){
		
		EntityManager em = emf.createEntityManager();
		List<Review> reviews = (List<Review>) 
				em.createNamedQuery("Review.findById").
				setParameter("id", id).getResultList();
		em.close();
		
		if (reviews.size() == 0)
			return null;
		else 
			return reviews.get(0);
	}
	
	public static List<Review> findReviewsByPostee(String username){
		
		EntityManager em = emf.createEntityManager();
		List<Review> reviews = (List<Review>) 
				em.createNamedQuery("Review.findByPostee").
				setParameter("username", username).getResultList();
		em.close();
		
		if (reviews.size() == 0)
			return null;
		else 
			return reviews;
	}


	public static List<Book> findAllBooks(){
		EntityManager em = emf.createEntityManager();
		List<Book> books = (List<Book>)
				em.createNamedQuery("Book.findAll").getResultList();
		em.close();

		return books;
	}

	public static Book findBookById(int id){

		EntityManager em = emf.createEntityManager();
		List<Book> books = (List<Book>)
				em.createNamedQuery("Book.findById").
						setParameter("id", id).getResultList();
		em.close();

		if (books.size() == 0)
			return null;
		else
			return books.get(0);
	}
}

