package abstract_and_interface;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import abstract_and_interface.Genre;
import abstract_and_interface.Gender;


public class RentManager {
    
    public static long calculatePrice(List<Buyable> buyableProducts) {
	long price = 0;
	for (Buyable buyable : buyableProducts) {
	    price += buyable.getPrice();
	}
	return price;
    }
    
    public static void main(String[] args) {
    Person willsmith = new Person("Will", "Smith", Gender.MALE, 1113);
    Person bridgetmoynahan = new Person("Bridget", "Moynahan", Gender.FEMALE, 400);
    Person flambardgammidge = new Person("Flambard", "Gammidge", Gender.MALE, 143);
    Person ryanreynolds = new Person("Ryan", "Reynolds", Gender.MALE, 1211);
    Person morenabaccarin = new Person("Morena", "Baccarin", Gender.FEMALE, 200);
    Person toboldsandyman = new Person("Tobold", "Sandyman", Gender.MALE, 140);
    Person patrickwilson = new Person("Patrick", "Wilson", Gender.MALE, 1000);
    Person rosebyrne = new Person("Rose", "Byrne", Gender.FEMALE, 888);
    Person lauratook = new Person("Laura", "Took", Gender.FEMALE, 294);
    Person pervincahayward = new Person("Pervinca", "Hayward", Gender.FEMALE, 351);
    Person tobyjones = new Person("Toby", "Jones", Gender.MALE, 1496);
    Person suzannecollins = new Person("Suzanne", "Collins", Gender.FEMALE, 4611);
	Person jkrowling = new Person("Joanne", "Kathleen Rowling", Gender.FEMALE, 3248);
	Person harperlee = new Person("Harper", "Lee", Gender.FEMALE, 9348);
	
	List<Person> IrobotCast = new ArrayList<Person>();
	IrobotCast.add(willsmith);
	IrobotCast.add(bridgetmoynahan);
	
	List<Person> DeadpoolCast = new ArrayList<Person>();
	DeadpoolCast.add(ryanreynolds);
	DeadpoolCast.add(morenabaccarin);
	
	List<Person> InsidiousCast = new ArrayList<Person>();
	InsidiousCast.add(patrickwilson);
	InsidiousCast.add(rosebyrne);
	
	Product Irobot = new Movie("I, Robot", flambardgammidge, Genre.ACTION, 130, 7.1, IrobotCast, 50);
	System.out.println(Irobot);
	
	Product Deadpool = new Movie("Deadpool", toboldsandyman, Genre.COMEDY, 164, 8.6, DeadpoolCast, 83);
	System.out.println(Deadpool);
	
	Product Insidious = new Movie("Insidious", lauratook, Genre.HORROR, 112, 6.8, InsidiousCast, 61);
	System.out.println(Insidious);
	
	List<Person> lolStaff = new ArrayList<Person>();
	lolStaff.add(pervincahayward);
	lolStaff.add(tobyjones);
	
	List<Person> csgoStaff = new ArrayList<Person>();
	csgoStaff.add(rosebyrne);
	csgoStaff.add(flambardgammidge);
	
	List<Person> f4Staff = new ArrayList<Person>();
	f4Staff.add(ryanreynolds);
	f4Staff.add(morenabaccarin);
	
	Product LoL = new Game("Leauge Of Legends", pervincahayward, false, lolStaff, 17);
	System.out.println(LoL);
	
	Product csgo = new Game("Counter Strike: Global Offensive", bridgetmoynahan, true, csgoStaff, 26);
	System.out.println(csgo);
	
	Product fallout4 = new Game("Fallout 4", tobyjones, true, f4Staff, 114);
	System.out.println(fallout4);
	
	Product thehungergames = new Book("The Hunger Games", flambardgammidge, suzannecollins);
	System.out.println(thehungergames);
	
	Product harrypotterandtheorderofthephoenix  = new Book("Harry Potter and the Order of the Phoenix ", toboldsandyman, jkrowling);
	System.out.println(harrypotterandtheorderofthephoenix );
	
	Product tokillamockingbird = new Book("To Kill a Mockingbird", lauratook, harperlee);
	System.out.println(tokillamockingbird);
	
	
	try
	{
		Socket clientSocket = new Socket("localhost", 3305);
		System.out.println("Connected to Server\n");
		ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		Thread.sleep(3000);
		send(outToServer, Command.PUT);
		send(outToServer, rosebyrne);
		send(outToServer, Command.GET);
		Object readFromServer = inFromServer.readObject();
		if (readFromServer instanceof List)
		{

			List<Object> dataFromServer = (List<Object>) readFromServer;
			for (Object object : dataFromServer)
			{

				System.out.println(object);
			}
		}
		send(outToServer, Command.EXIT);
	}
	catch (IOException | ClassNotFoundException | InterruptedException e)
	{
		e.printStackTrace();
	}
}
    
	
	public static void send(ObjectOutputStream x, Object object) throws IOException
	{
	x.write(0);
	x.writeObject(object);
	}
	
	
}
