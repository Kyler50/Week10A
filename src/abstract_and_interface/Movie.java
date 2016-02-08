package abstract_and_interface;
import java.util.ArrayList;
import java.util.List;

public class Movie extends Product implements Buyable{
	Genre genre;
	long duration;
	double rate;
	List <Person> cast = new ArrayList<Person>();
	int price;
	

	
	public Movie(String id, String title, Person person, Genre genre, long duration, double rate, List<Person> cast,
		int price) {
		super(id, title, person);
		this.genre = genre;
		this.duration = duration;
		this.rate = rate;
		this.cast = cast;
		this.price = price;
	}

	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public long getDuration() {
		return duration;
	}
	
	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public String toString(){
		return "Id: " + id + "\nTitle: " + title + "\nProducer: " + person + "\nGenre: " + genre + "\nLong: " + duration + "\nRate: " + rate + "\nCast: " + cast;
	}

	public List<Person> getCast() {
		return cast;
	}

	public void setCast(List<Person> cast) {
		this.cast = cast;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public long getiInvestement() {
		long summaSalary = 0;
		for (Person person : cast) {
			summaSalary += person.getSalary();
		}
		return summaSalary;
	}
}
