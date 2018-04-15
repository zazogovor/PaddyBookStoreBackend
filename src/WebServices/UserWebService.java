package WebServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.User;
import main.UserDAO;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserWebService {

    @POST
    @Path("/user/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@FormParam("username") String username){
        User u = UserDAO.viewUser(username);
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(u);
        return json;
    }

    //Create USER
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String newUser(@FormParam("username") String username,
                          @FormParam("email") String email,
                          @FormParam("password") String password,
                            @FormParam("type") String type){
        UserDAO.createUser(username, email, password, type);
        return "1";
    }

    //Login USER
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String newUser(@FormParam("username") String username,
                          @FormParam("password") String password){
        System.out.println("User LOGIN request...");
        Boolean success = UserDAO.loginUser(username, password);

        if(success == true){
            User u = UserDAO.viewUser(username);
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(u);
            return json;
        }
        else{
            System.out.println("User LOGIN failed...");
            return "0";
        }
    }

    //Delete USER
    @DELETE
    @Path("/delete/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String removeUser(@FormParam("username") String username,
                               @Context HttpServletResponse response){
       UserDAO.deleteUser(username);
       return "1";
    }


}
