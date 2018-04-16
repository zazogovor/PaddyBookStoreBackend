package main;

import HelperClasses.Basket;
import com.google.gson.Gson;
import entity.Book;
import entity.Purchase;
import entity.User;
import persistence.PersistenceUtil;


public class PurchaseDAO {

    public static String createPurchase(String userID, String books, String firstname, String surname, String address, String cardnumber){
        int id = Integer.parseInt(userID);
        User user = PersistenceUtil.findUserById(id);

        Gson gson = new Gson();
        Basket b = gson.fromJson(books, Basket.class);

        for(int i = 0; i < b.getBooks().size(); i++){
            PurchaseItemDAO.createPurchaseItem(b.getBooks().get(i));
            Book book = BookDAO.getBook(b.getBooks().get(i).getBook().getId());
            book.setQuantity(book.getQuantity() - b.getBooks().get(i).getAmount());
            PersistenceUtil.merge(book);
        }
        Purchase p = new Purchase(user, b.getBooks(), firstname, surname, address, cardnumber);
        PersistenceUtil.persist(p);

        return "1";
    }
}
