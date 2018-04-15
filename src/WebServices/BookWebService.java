package WebServices;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Book;
import main.BookDAO;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
public class BookWebService{

    @POST
    @Path("/listAll/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(){
        List<Book> books = BookDAO.viewBooks();

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(books);
        return json;
    }

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String newReview(@FormParam("title") String title,
                            @FormParam("author") String author,
                            @FormParam("ISBN") String ISBN,
                            @FormParam("price") String price,
                            @FormParam("stock") String stock,
                            @FormParam("image") String image,
                            @Context HttpServletResponse response){
        double price_double = Double.parseDouble(price);
        int stock_int = Integer.parseInt(stock);

        BookDAO.createBook(title, author, ISBN, price_double, stock_int, image);
        return "1";
    }
}
