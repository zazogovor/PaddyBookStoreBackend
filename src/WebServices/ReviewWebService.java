package WebServices;

import main.ReviewDAO;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/review")
public class ReviewWebService {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String newReview(@FormParam("book") String book_id,
                        @FormParam("postee") String postee_id,
                        @FormParam("comment") String comment,
                        @FormParam("rating") String rating,
                        @Context HttpServletResponse response){
        String r = ReviewDAO.createReview(book_id, postee_id, comment, rating);
        return r;
    }
}
