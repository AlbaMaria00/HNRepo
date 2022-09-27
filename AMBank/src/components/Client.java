package components;

//1.1.1 Creation of the client class
public class Client {

	private String name;
	private String firstName;
	private int number;

	public Client(String name, String firstName, int number) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.number = number++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", firstName=" + firstName + ", number=" + number + "]";
	}
	
	

}
