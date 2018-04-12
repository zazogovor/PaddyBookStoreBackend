package main;

import java.util.List;

import com.sun.org.apache.regexp.internal.RE;
import entity.Book;
import persistence.PersistenceUtil;
import entity.Review;
import entity.User;


public class ReviewDAO {

	public void reviewPrinter(Review r){
		System.out.println("Poster: "+r.getPostee().getUsername());
		System.out.println("Rating: "+r.getRating());
		System.out.println("Comment: "+r.getComment());
		System.out.println("");
	}
	
	public List<Review> viewReviews(){
		List<Review> reviews = PersistenceUtil.findAllReviews();
		return reviews;
	}
	
	public Review viewReviewById(int id){
		Review review = PersistenceUtil.findReviewById(id);
		return review;
	}
	
	public void viewReviewsByPostee(String username){
		List<Review> reviews = PersistenceUtil.findReviewsByPostee(username);
		for(Review r:reviews){
			System.out.println("Review with ID:"+r.getId()+ " was posted by " + username);
		}
	}

	public List<Review> viewReviewsByBookID(int bookId){
		Book book = PersistenceUtil.findBookById(bookId);

		return book.getReviews();
	}

	public void deleteReview(int id){
		Review review = PersistenceUtil.findReviewById(id);
		PersistenceUtil.remove(review);
	}
	
	public void createReview(int bookId, int rating, String comment, String posteeUsername){
		Book book = PersistenceUtil.findBookById(bookId);
		User postee = PersistenceUtil.findUserByUsername(posteeUsername);

		Review r = new Review(book, rating, comment, postee);
		PersistenceUtil.persist(r);

		book.getReviews().add(r);
		PersistenceUtil.merge(book);
	}
			

}
