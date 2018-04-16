package HelperClasses;

import entity.PurchaseItem;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<PurchaseItem> books = new ArrayList<PurchaseItem>();

    public Basket(){

    }

    public Basket(List<PurchaseItem> books) {
        this.books = books;
    }

    public List<PurchaseItem> getBooks() {
        return books;
    }

    public void setBooks(List<PurchaseItem> books) {
        this.books = books;
    }
}
