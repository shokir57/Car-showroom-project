
import java.util.ArrayList;
import java.util.Scanner;

public class carshowroom {

    static ArrayList<Car> thecarlist;

    public static void main(String[] args) {

        thecarlist = new ArrayList<>();

        for (;;) {

            printmainmenu();

            Scanner scanmainmenu = new Scanner(System.in);
            int MMselect = scanmainmenu.nextInt();

            if (MMselect == 6) {
                break;

            } else {

                switch (MMselect) {
                    case 1:
                        AddCar();
                        break;
                    case 2:
                        EditCar();
                        break;
                    case 3:
                        DisplayList();
                        break;
                    case 4:
                        SearchForCar();
                        break;
                    case 5:
                        RemoveCar();
                        break;
                    default:
                        System.out.println("Please enter a valid number");

                }

            }
        }

    }

//         FIRST METHOD
    public static void printmainmenu() {
        System.out.println("---------------------------------");
        System.out.println("Welcome to Car Showroom Main Menu.\n"
                + "Please select a number below:\n"
                + "\n1) Add Car\n2) Edit Car\n3) Display List\n"
                + "4) Search for Car\n5) Remove Car\n6) Quit\n");
    }

//         THE SECOND METHOD
    public static void AddCar() {

        System.out.println("Please enter car details\n");

        Car newcar = new Car();

        Scanner scaninput = new Scanner(System.in);

        System.out.println("> Model: ");
        newcar.Model = scaninput.nextLine();

        System.out.println("> NumberPlate: ");
        newcar.NumberPlate = scaninput.nextLine();

        System.out.println("> Year: ");
        newcar.Year = scaninput.nextInt();

        System.out.println("> Colour: ");
        newcar.Colour = scaninput.next();

        System.out.println("> Doors: ");
        newcar.NumOfDoors = scaninput.nextInt();

        System.out.println("> Engine Size: ");
        newcar.EngineSize = scaninput.nextDouble();

        System.out.println("> Is it Automatic? ");
        newcar.isAutomatic = scaninput.nextBoolean();

        System.out.println("> Is it High Insurance? ");
        newcar.isHighInsurance = scaninput.nextBoolean();

        System.out.println("Do you want to add this car to the list? ");
//          Scanner scantoadd = new Scanner(System.in); 
        Boolean sure_to_add = scaninput.nextBoolean();  // we can use same scaninput

        if (sure_to_add) {
            thecarlist.add(newcar);
            System.out.println("The car has been ADDED!\n");
//              System.out.println(thecarlist);

        } else {
            System.out.println("The car has NOT been ADDED!\n");
        }

    }

//         THE THIRD METHOD
    public static void EditCar() {

        System.out.println("Please enter the NumberPlate of a Car to Edit.");
        Scanner scanedt = new Scanner(System.in);
        String scanedtinpt = scanedt.next();

        boolean carfound;

        for (Car c : thecarlist) {
            if (scanedtinpt.equals(c.NumberPlate)) {
                System.out.println("---- Car Details ----");
                PrintTheDetails(c);
                carfound = true;

                if (carfound) {
                    System.out.println("---------------------");
                    System.out.println("Please type the new NumberPlate.");
                    Scanner newscan = new Scanner(System.in);
                    String newscaninpt = newscan.next();

                    c.NumberPlate = newscaninpt;

                    System.out.println("---------------------------------");
                    System.out.println("NumberPlate has been changed Successfully!");
                }
            } else {
                System.out.println("Car NOT FOUND");
            }

        }

    }

//         THE FOURTH METHOD
    public static void DisplayList() {

        System.out.println("DisplayList\n");

        for (Car c : thecarlist) {

            System.out.println("********************");

            System.out.println("Model: " + c.Model);

            System.out.println("NumberPlate: " + c.NumberPlate);

            System.out.println("Year: " + c.Year);

            System.out.println("Colour: " + c.Colour);

            System.out.println("Doors: " + c.NumOfDoors);

            System.out.println("Engine Size: " + c.EngineSize);

            System.out.println("Automatic: " + c.isAutomatic);

            System.out.println("High Insurance: " + c.isHighInsurance);

            System.out.println("********************");
//              System.out.println("Press Enter for next"); 

        }
    }

//         THE FIFTH METHOD
    public static void SearchForCar() {

        System.out.println("Please enter the NumberPlate of the car to Search for.");
        Scanner scannpe = new Scanner(System.in);
        String npe = scannpe.next();

        for (Car c : thecarlist) {
            if (npe.equals(c.NumberPlate)) {

                System.out.println("-----------------------");
                System.out.println("       Car FOUND!      ");
                System.out.println("-----------------------");
                PrintTheDetails(c);

            } else {
                System.out.println("Car NOT FOUND!");
            }
        }
    }

//         THE SIXTH METHOD
    public static void RemoveCar() {

        boolean foundcar = false;

        System.out.println("Please enter the NumberPlate of the car to REMOVE.");
        Scanner rmv = new Scanner(System.in);
        String npentered = rmv.next();

        Car CarToRemove = null;

        for (Car c : thecarlist) {
            if (c.NumberPlate.equals(npentered)) {
//              thecarlist.remove(c);  // can't remove from thecarlist until the loop is over
                CarToRemove = c;
                foundcar = true;
            }
        }
        if (foundcar) {
            thecarlist.remove(CarToRemove);
            System.out.println("The car has been REMOVED!\n");
        } else {
            System.out.println("NumberPlate does NOT MATCH!\n");
        }

    }

//        EXTRA METHOD
    public static void PrintTheDetails(Car c) {

        System.out.println("Model: " + c.Model);
        System.out.println("NumberPlate: " + c.NumberPlate);
        System.out.println("Year: " + c.Year);
        System.out.println("Colour: " + c.Colour);
        System.out.println("Doors: " + c.NumOfDoors);
        System.out.println("Engine Size: " + c.EngineSize);
        System.out.println("Automatic: " + c.isAutomatic);
        System.out.println("High Insurance: " + c.isHighInsurance);
    }

}
