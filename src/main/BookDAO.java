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

    public static Book getBook(int id){
        Book book = PersistenceUtil.findBookById(id);
        return book;
    }

    public static List<Book> viewBooks(){
        List<Book> books = PersistenceUtil.findAllBooks();
        return books;
    }

    public static void createBook(String title, String author, String ISBN, String price, String stock, String image){
        double price_double = Double.parseDouble(price);
        int stock_int = Integer.parseInt(stock);
        Book book = new Book(title, author, ISBN, price_double, stock_int,  image);
        PersistenceUtil.persist(book);
    }

    public static void editBook(String id, String title, String author, String ISBN, String price, String stock){
        int book_id = Integer.parseInt(id);
        double price_double = Double.parseDouble(price);
        int stock_int = Integer.parseInt(stock);

        Book book = PersistenceUtil.findBookById(book_id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setPrice(price_double);
        book.setQuantity(stock_int);

        PersistenceUtil.merge(book);
    }
}
