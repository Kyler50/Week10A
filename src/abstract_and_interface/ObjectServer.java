package abstract_and_interface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ObjectServer
{
	ServerMode mode = ServerMode.LOAD;

	static FileOutputStream fos;
	static ObjectOutputStream oos;

	public ObjectServer()
	{
		System.out.printf("Startig server.\nDefault server mode: " + mode.toString() + "\n");
		try
		{
			ServerSocket serverSocket = new ServerSocket(3305);
			Socket socket = serverSocket.accept();
			System.out.println("Client connected");

			ObjectOutputStream streamtoClient = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream streamFromClient = new ObjectInputStream(socket.getInputStream());

			fos = new FileOutputStream("sample.ser", true);
			oos = new ObjectOutputStream(fos);

			while (true)
			{
				if (streamFromClient.read() > -1)
				{
					Object objectFromClient = streamFromClient.readObject();
					if (objectFromClient instanceof Command && ((Command) objectFromClient) == Command.EXIT)
					{
						System.out.println("EXIT");
						break;
					}
					else if (objectFromClient instanceof Command && ((Command) objectFromClient) == Command.GET)
					{
						mode = ServerMode.LOAD;
						Object o = load();
						System.out.println("Load data from file to client.");
						List<Object> castedList = (List<Object>) o;
						streamtoClient.writeObject(o);
					}
					else if (objectFromClient instanceof Command && ((Command) objectFromClient) == Command.PUT)
					{
						mode = ServerMode.SAVE;
						System.out.println("Switch to save mode.");
						System.out.printf("Server mode: " + mode + "\n");

					}
					else if (mode == ServerMode.SAVE)
					{
						System.out.println("Save client's data to file.");
						save(objectFromClient);
					}

				}

			}
			serverSocket.close();
		}
		catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public ServerMode getMode()
	{
		return mode;
	}

	public void setMode(ServerMode mode)
	{
		this.mode = mode;
	}

	public static List<Object> load() throws IOException, ClassNotFoundException

	{
		List<Object> listWithObjects = new ArrayList<>();

		try
		{
			FileInputStream fis = new FileInputStream("sample.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true)
			{
				try
				{
					listWithObjects.add(ois.readObject());
				}
				catch (Exception e)
				{
					break;
				}
			}
			ois.close();
			fis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return listWithObjects;
	}

	public static void save(Object o)
	{
		try
		{
			oos.writeObject(o);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new ObjectServer();
	}
}
