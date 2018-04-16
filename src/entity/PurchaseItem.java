package entity;

import javax.persistence.*;

import entity.Book;

@Entity
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Book book;

    private int amount;

    public PurchaseItem(Book book, int amount) {
        this.amount = amount;
        this.book = book;
    }

    public PurchaseItem() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
