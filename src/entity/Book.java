package entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries( {
        @NamedQuery(name = "Book.findAll", query = "select o from Book o"),
        @NamedQuery(name = "Book.findById", query = "select o from Book o where o.id=:id")
})

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String ISBN;

    private String title;
    private String author;
    private double price;
    private int quantity;
    private int rating = 0;
    private String image;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Review> reviews = new ArrayList<Review>();


    public Book(String title, String author, String ISBN, double price, int quantity, String image) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public Book() {
    }

    public void reduceQuantity(int q){
        this.quantity = this.quantity - q;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
