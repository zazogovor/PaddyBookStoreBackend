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

	public List<Review> viewReviewsByBookID(int bookId){
		Book book = PersistenceUtil.findBookById(bookId);

		return book.getReviews();
	}
	
	public static String createReview(String bookId, String posteeID, String comment, String rating){
		int book_id = Integer.parseInt(bookId);
		int user_id = Integer.parseInt(posteeID);
		int rating_int = Integer.parseInt(rating);

		Book book = PersistenceUtil.findBookById(book_id);
		User postee = PersistenceUtil.findUserById(user_id);

		Review r = new Review(postee, comment, rating_int);
		PersistenceUtil.persist(r);

		book.getReviews().add(r);

		book.setRating(0);
		for(int i = 0; i < book.getReviews().size(); i++){
			book.setRating(book.getRating() + book.getReviews().get(i).getRating());
		}
		book.setRating(book.getRating() / book.getReviews().size());

		PersistenceUtil.merge(book);

		return "1";
	}
			

}
