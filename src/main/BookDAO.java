package main;

import entity.Book;
import entity.Review;
import persistence.PersistenceUtil;

import java.util.List;

public class BookDAO {

    public void purchaseBook(int id, int quantity){
        Book book = PersistenceUtil.findBookById(id);
        book.reduceQuantity(quantity);

        PersistenceUtil.merge(book);
    }

    public static List<Book> viewBooks(){
        List<Book> books = PersistenceUtil.findAllBooks();
        return books;
    }

    public static void deleteBook(int id){
        Book book = PersistenceUtil.findBookById(id);
        PersistenceUtil.remove(book);
    }

    public static void createBook(String ISBN, String title, String author, int rating, String image, List<Review> reviews, int quantity){
        Book book = new Book(ISBN, title, author, rating, image, reviews, quantity);
        PersistenceUtil.persist(book);
        System.out.println("Book created");
    }
}
