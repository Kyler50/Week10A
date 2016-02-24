package abstract_and_interface;
import java.io.Serializable;
public abstract class Product implements Serializable {
	private String id;
    private String title;
    private Person borrower;
    
    public Product(String title, Person borrower) {
	this.title = title;
	this.borrower = borrower;
	this.id = IdGenerator.generate(this);
    }

    public String getId() {
	return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Person getBorrower() {
        return borrower;
    }
    
    public abstract long getInvestment();
    
}
