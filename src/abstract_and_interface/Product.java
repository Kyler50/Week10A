package abstract_and_interface;

public abstract class Product {
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
