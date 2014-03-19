package noSQL.noSQL;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Person {
	@Id ObjectId id;
	String name;
	List<Address> address;
	 
	public Person(){
		this.address=new ArrayList<Address>();
	};

	public Person(ObjectId id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.address=new ArrayList<Address>();
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
	
	public List<Address> getAddress() {
		return address;
	}
	
	public void add(Address a){
		address.add(a);
	}
}
