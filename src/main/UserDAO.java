package main;

import java.util.List;
import persistence.PersistenceUtil;
import entity.User;


public class UserDAO {

	public static void userPrinter(User u){
		System.out.println("Username: "+u.getUsername());
		System.out.println("Email: "+u.getEmail());
		System.out.println("");
	}

	public static void viewUsers(){
		List<User> users = PersistenceUtil.findAllUsers();
		for(User u:users){
			userPrinter(u);
		}
	}
	
	public static User viewUser(String username){
		User user = PersistenceUtil.findUserByUsername(username);
		return user;
	}

	public static Boolean loginUser(String username, String password){
		User user = PersistenceUtil.userLogin(username, password);
		if(user != null){
			return true;
		}
		else{
			return false;
		}
	}

	public static void deleteUser(String username){
		User user = PersistenceUtil.findUserByUsername(username);
		PersistenceUtil.remove(user);
		System.out.println("User "+ username + " successfully removed from database.");
	}
	
	public static void createUser(String username, String email, String password, String type){
		User user = new User(username, email, password, type);
		PersistenceUtil.persist(user);
		System.out.println("User registered");
	}
			

}
