package noSQL.noSQL;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnknownHostException
    {
    	Morphia morphia = new Morphia();
    	Mongo mongo = new Mongo();
    	morphia.map(Person.class).map(Address.class);
    	Datastore ds = morphia.createDatastore(mongo, "my_database");
    	
    	Address address = new Address();
    	address.setStreet("123 Some street");
    	address.setCity("Some city");
    	address.setPostCode("123 456");
    	address.setCountry("Some country");
    	//set address
    	Person p = new Person();
    	p.setName("Pauline");
    	p.add(address);
    	
    	//article
    	Article a = new Article();
    	a.setName("Journal de la femme");
    	a.setStars(5);
    	a.add(p);
    	// Save the POJO
    	ds.save(p);
    	ds.save(a);
    	ds.save(address);
    	for (Person e : ds.find(Person.class)){
	    	System.err.println(e.getId());
	    	System.err.println(e.getName());
	    
    	}
    	
    	for (Article article : ds.find(Article.class)){
	    	System.err.println(article.getId());
	    	System.err.println(article.getName());
	    	System.err.println(article.getStars());
	    
    	}
    	for (Address addr : ds.find(Address.class)){
	    	System.err.println(addr.getId());
	    	System.err.println(addr.getCity());
	    	System.err.println(addr.getCountry());
	    	System.err.println(addr.getPostCode());
	    	System.err.println(addr.getStreet());
	    
    	}
    	
    }
}
