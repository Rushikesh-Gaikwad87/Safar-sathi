import java.util.Scanner;
import java.util.ArrayList;

class Driver {
	private String name;
	private long contact;

	Driver(String name, long contact) {
		this.name = name;
		this.contact = contact;
	}

	public void getDriver() {
		System.out.println("\n DRIVER INFO ");
		System.out.println("Driver: " + name);
		System.out.println("Contact: " + contact + "\n");
	}
}

class Cab {
	static int id = 353345;
	private Driver driver;
	private String number;
	private String safarId; // changed from uberId
	private String type;
	private int capacity;
	private String status = "AVAIL";
	private String location = "DECCAN";

	String[] typevechicle = { "hatchback", "sedan", "suv", "muv" };
	int[] vechiclcapcity = { 3, 4, 5, 6 };
	{
		this.safarId = "SAFAR" + id++; // changed from UBER
	}

	Cab(String number, String type, Driver driver) {
		this.number = number;
		this.type = type.toLowerCase();

		int indx = 0;
		for (String element : typevechicle) {
			if (type.toLowerCase().equals(element)) {
				break;
			}
			indx++;
		}
		this.capacity = vechiclcapcity[indx];
		this.driver = driver;
	}

	public void getCabDetails() {
		System.out.println("\n CAB DETAILS ");
		System.out.println("Safar Id :" + safarId); // changed from Uber Id
		System.out.println("Status :" + status);
		System.out.println("Cab Number :" + number);
		System.out.println("Type : " + type);
		System.out.println("Capacity : " + capacity);
		System.out.println("Location :" + location);
		System.out.println("");
	}

	public String getCabNumber() {
		return number;
	}

	public Driver getDriver() {
		return driver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String newStatus) {
		status = newStatus;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getSafarId() { // changed from getUberId
		return safarId;
	}
}

class Passenger {
	private String name;
	private long contact;
	private String email;
	private String pickuplocation;
	private String dropLocation;
	private int seats;

	Passenger(String name, long contact, String email, String pickuplocation, String dropLocation, int seats) {
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.pickuplocation = pickuplocation;
		this.dropLocation = dropLocation;
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long newContact) {
		this.contact = newContact;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public String getPickupLocation() {
		return pickuplocation;
	}

	public void setPickupLocation(String newPickupLocation) {
		this.pickuplocation = newPickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String newDropLocation) {
		this.dropLocation = newDropLocation;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int newSeats) {
		this.seats = newSeats;
	}
}

class Uber {
	ArrayList<Cab> listcabs = new ArrayList<Cab>();
	Passenger passenger;
	Cab currentCab;
	{
		Cab cab1 = new Cab("MH-17-AQ-1234", "sedan", new Driver("Ramesh Joshi", 8800558899l));
		Cab cab2 = new Cab("MH-17-AQ-3455", "hatchback", new Driver("Suresh Joshi", 7766880099l));
		Cab cab3 = new Cab("MH-17-AQ-7799", "muv", new Driver("Ritesh Joshi", 8800588009l));
		Cab cab4 = new Cab("MH-17-AQ-8877", "hatchback", new Driver("Hari Kumar", 7766588009l));
		Cab cab5 = new Cab("MH-17-AQ-1111", "suv", new Driver("Suresh Singh", 7788008899l));
		Cab cab6 = new Cab("MH-17-AQ-2222", "sedan", new Driver("Harsh Singh", 9876543212l));
		listcabs.add(cab1);
		listcabs.add(cab2);
		listcabs.add(cab3);
		listcabs.add(cab4);
		listcabs.add(cab5);
		listcabs.add(cab6);
	}
	{
		System.out.println(" Passenger Details");
		Scanner sc = new Scanner(System.in);
		System.out.print("Name :");
		String name = sc.nextLine();
		System.out.print("Contact :");
		long contact = sc.nextLong();
		sc.nextLine(); // consume newline
		System.out.print("Email :");
		String email = sc.nextLine();
		System.out.print("Pickup Location : ");
		String pickup = sc.nextLine();
		System.out.print("Drop Location : ");
		String drop = sc.nextLine();
		System.out.print("Number Of People :");
		int seats = sc.nextInt();
		sc.nextLine(); // consume newline

		this.passenger = new Passenger(name, contact, email, pickup, drop, seats);
	}

	public void homeModule() {
		System.out.println("\nWELCOME TO SAFARSARTHI\n"); // Capital welcome statement
		for (;;) {
			System.out.println("\n WELCOME \n");
			System.out.println("1.BOOK A RIDE");
			System.out.println("2.CANCLE A RIDE");
			System.out.println("3.RIDE HISTORY");
			System.out.println("4.LOGOUT \n");
			System.out.print("Enter Your Response: ");
			int response = new Scanner(System.in).nextInt();

			switch (response) {
				case 1 -> bookRide();
				case 2 -> cancleRide();
				case 3 -> rideHistroy();
				case 4 -> {
					System.out.println(" THANK U FOR USING SAFARSARTHI");
					System.exit(0);
				}
				default -> System.out.println("INVALID RESPONSE");
			}
		}
	}

	public void bookRide() {
		System.out.println("\n BOOK-A-RIDE MODULE");
		for (Cab element : listcabs) {
			if (element.getStatus().equals("AVAIL") && passenger.getSeats() <= element.getCapacity())
				element.getCabDetails();
		}
		System.out.print("\n Enter the safarId: "); // changed from uberID
		String safarId = new Scanner(System.in).next();
		boolean assump = false;
		for (Cab ele : listcabs) {
			if (ele.getSafarId().equals(safarId)) { // changed from getUberId
				System.out.println("YOUR RIDE HAS BEEN CONFIRMED");
				currentCab = ele;
				assump = true;
				System.out.println("YOUR RIDE DETAILS");
				ele.getCabDetails();
				System.out.println("CAB NUMBER : " + ele.getCabNumber());
				ele.getDriver().getDriver();
				break;
			}
		}
		if (!assump)
			System.out.println("\n INVALID SAFARID \n");
	}

	public void cancleRide() {
		if (currentCab == null) {
			System.out.println("\n NO RIDE HAS BEEN BOOKED \n");
			return;
		}
		System.out.println("\n CANCLE-A-RIDE MODULE \n");
		System.out.println("YOUR RIDE DETAILS");
		currentCab.getCabDetails();
		System.out.println("CAB NUMBER : " + currentCab.getCabNumber());
		currentCab.getDriver().getDriver();
		System.out.println("DO U WANT TO CANCLE YOUR RIDE (YES/NO):");
		String resp = new Scanner(System.in).next();
		if (resp.equalsIgnoreCase("YES")) {
			System.out.println("YOUR RIDE HAS BEEN CANCELLED");
			currentCab = null;
		}
	}

	public void rideHistroy() {
		System.out.println("\n RIDE HISTORY MODULE");
	}
}

class SafarSarthi {
	public static void main(String[] args) {
		Uber uber = new Uber();
		uber.homeModule();
	}
}