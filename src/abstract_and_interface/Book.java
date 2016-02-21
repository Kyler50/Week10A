package abstract_and_interface;

public class Book extends Product {
    private Person author;
    
    public Book(String title, Person borrower, Person author) {
	super(title, borrower);
	this.author = author;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public long getInvestment() {
	return author.getSalary();
    }

    @Override
    public String toString() {
	StringBuffer buffer = new StringBuffer();
	buffer.append("Book [author=").append(author).append(", ID=").append(getId())
	.append(", title=").append(getTitle()).append(", borrower=").append(getBorrower()).append("]");
	return buffer.toString();
    }

}