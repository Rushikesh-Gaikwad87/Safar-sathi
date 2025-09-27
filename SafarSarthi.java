import java.util.Scanner;

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
    private String uberId;
    private String type;
    private int capacity;
    private String status = "AVAIL";
    private String location = "DECCAN";

    String[] typevechicle = { "hatchback", "sedan", "suv", "muv" };
    int[] vechiclcapcity = { 3, 4, 5, 6 };
    {
        this.uberId = "UBER" + id++;
    }

    Cab(String number, String type) {
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
        System.out.println("Enter the driver details: ");
        System.out.print("Enter a name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Enter The Contact number : ");
        long contact = new Scanner(System.in).nextLong();
        this.driver = new Driver(name, contact);
    }

    public void getCabDetails() {
        System.out.println("\n CAB DETAILS ");
        System.out.println("Uber Id :" + uberId);
        System.out.println("Status :" + status);
        System.out.println("Cab Number :" + number);
        System.out.println("Type : " + type);
        System.out.println("Capacity : " + capacity);
        System.out.println("Location :" + location);
        driver.getDriver();
        System.out.println("");
    }
}

class SafarSarthi {
    public static void main(String[] args) {
        System.out.println("\n  WELCOME ");
        System.out.print("Enter Cab Number: ");
        String CabNumber = new Scanner(System.in).next();
        System.out.print("Type of Cab: ");
        String type = new Scanner(System.in).next();
        Cab cab1 = new Cab(CabNumber, type);
        cab1.getCabDetails();
    }
}