package entity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@NamedQueries( {
		@NamedQuery(name = "User.findAll", query = "select o from User o"),
		@NamedQuery(name = "User.findById", query = "select o from User o where o.id=:id"),
		@NamedQuery(name = "User.findByUsername", query = "select o from User o where o.username=:username"),
		@NamedQuery(name = "User.edit", query = "select o from User o"),
		@NamedQuery(name = "User.login", query = "SELECT o FROM User o WHERE o.username = :username AND o.password = :password")
})

@Entity
@XmlRootElement
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	private String email;
	private String type;
	
	public User(){
		
	}
	
	public User(String username,String email, String password, String type) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	/*
	* 	GETers and SETers beyond this point
	*/
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
