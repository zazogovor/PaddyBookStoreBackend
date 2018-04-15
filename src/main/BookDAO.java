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

    public static void createBook(String title, String author, String ISBN, double price, int stock, String image){
        Book book = new Book(title, author, ISBN, price, stock,  image);
        PersistenceUtil.persist(book);
    }
}
