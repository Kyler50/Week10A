package abstract_and_interface;

public class Book extends Product {
	Person author;

	public Book(Person author, String id, String title, Person person) {
		super(id, title, person);
		this.author = author;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}
	
	public long getiInvestement() {
		return author.getSalary();
	}
	
	public String toString(){
		return "Id: " + id + "\nTitle: " + title + "\nAuthor: " + author;
	}
}