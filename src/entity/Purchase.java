package entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    private User buyer;


    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PurchaseItem> books = new ArrayList<PurchaseItem>();

    String firstname;
    String surname;
    String address;
    String cardnumber;


    public Purchase(){

    }

    public Purchase(User buyer, List<PurchaseItem> books, String firstname, String surname, String address, String cardnumber) {
        this.buyer = buyer;
        this.books = books;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.cardnumber = cardnumber;
    }


    public void addBookToBasket(Book book, int quantity){
        PurchaseItem item = new PurchaseItem(book, quantity);

        books.add(item);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public List<PurchaseItem> getBooks() {
        return books;
    }

    public void setBooks(List<PurchaseItem> books) {
        this.books = books;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
