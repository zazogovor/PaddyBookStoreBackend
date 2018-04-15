package entity;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@NamedQueries( {
	@NamedQuery(name = "Review.findAll", query = "select o from Review o"),
	@NamedQuery(name = "Review.findById", query = "select o from Review o where o.id=:id"),
	@NamedQuery(name = "Review.findByPostee", query = "select o from Review o where o.postee.username=:username")
})

@Entity
@XmlRootElement
public class Review {
	
	//every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int rating;
	private String comment;
	
	@ManyToOne
	private User postee;
	
	public Review(){
		
	}
	
	public Review(User postee, String comment, int rating){
		super();
		this.rating = rating;
		this.comment = comment;
		this.postee = postee;
	}
	
	
	/*
	* 	GETers and SETers beyond this point
	*/

	@XmlElement
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	@XmlElement
	public int getRating(){
		return this.rating;
	}
	
	public void setRating(int rating){
		this.rating = rating;
	}

	@XmlElement
	public String getComment(){
		return this.comment;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}

	@XmlElement
	public User getPostee(){
		return this.postee;
	}
	
	public void setPostee(User postee){
		this.postee = postee;
	}
}
