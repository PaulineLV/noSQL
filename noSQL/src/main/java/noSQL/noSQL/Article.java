package noSQL.noSQL;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity
public class Article {
	@Id ObjectId id;
	String name;
	int stars;
	@Reference List<Person> buyers;
	
	public Article(){
		this.buyers=new ArrayList<Person>();
	};
	
	public Article(ObjectId id, String name, int stars) {
		super();
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.buyers=new ArrayList<Person>();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public List<Person> getBuyers() {
		return buyers;
	}
	
	public void add(Person p){
		buyers.add(p);
	}
}
