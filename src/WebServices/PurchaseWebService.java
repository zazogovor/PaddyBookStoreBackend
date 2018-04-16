package WebServices;

import main.PurchaseDAO;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/purchase")
public class PurchaseWebService {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String newPurchase(@FormParam("user") String user,
                            @FormParam("items") String items,
                            @FormParam("firstname") String firstname,
                            @FormParam("surname") String surname,
                            @FormParam("address") String address,
                            @FormParam("cardnumber") String cardnumber,
                            @Context HttpServletResponse response){
        String r = PurchaseDAO.createPurchase(user, items, firstname, surname, address, cardnumber);
        return r;
    }
}
