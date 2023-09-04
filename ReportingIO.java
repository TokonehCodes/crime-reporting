import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is a class used to input and output values for incidents, districts and the report.
 * It has no fields in it, but 4 methods.
 * 1 method is used to record districts and another to record incidents.
 * The other 2 methods are used to check the input types going into the incidents.
 *
 * @author Tokoneh Kalango.
 */
public class ReportingIO {

    /**
     * A method to ensure that the type of data for value is a double.
     * @return a value to go into the record incidents method.
     */
    private Double inputCheckDouble() {
        double input;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                input = scan.nextDouble();
                break;
            } catch (InputMismatchException ime) {
                System.out.print("Enter as a number ");
            }
            scan.nextLine();
        } while (true);
        return input;
    }

    /**
     * A method to ensure that the type of data for year is an integer.
     * @return a year to go into the record Incidents method.
     */
    private int inputCheckInt() {
        int input;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                input = scan.nextInt();
                break;
            } catch (InputMismatchException ime) {
                System.out.print("Enter as a number ");
            }
            scan.nextLine();
        } while (true);
        return input;
    }


    public static void main(String[] args) {
        new ReportingIO().run();
    }

    public void run() {
        Reporting r = new Reporting();

        boolean quit = false;
        Scanner sc = new Scanner(System.in);

        while(!quit){
            Scanner input = new Scanner(System.in);
            menu();
            System.out.println("Please select an option");
            int choice = sc.nextInt();


            switch (choice) {
                case 1 -> r.addDist(recordDistrict());
                case 2 -> {
                    System.out.println("Please input a value to filter by");
                    int value = input.nextInt();
                    System.out.println(r.highIncidents(value));
                }
                case 3 -> {
                    System.out.println("Please input what year you want to " +
                            "get the highest average for");
                    int year = input.nextInt();
                    System.out.println(r.highestAverage(year));
                }
                case 4 -> System.out.println(r.highestValInc());
                case 5 -> {
                    System.out.println("Quitting");
                    quit = true;
                }
                default -> System.out.println("Not a valid option");
            }
        }

    }


    /**
     * A method to record all the data for an incident abstraction.
     * @return An incident to go into the District abstraction.
     */
    private Incident recordIncident() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter the Incident's value in pounds");
        double value = inputCheckDouble();
        System.out.println("Please Enter postcode of the Incident");
        String postcode = sc.next();
        System.out.println("Please Enter the month of the Incident");
        String month = sc.next();
        System.out.println("Finally, the year of the Incident");
        int year = inputCheckInt();
        return new Incident(value, postcode, month, year);
    }

    /**
     * A method to record the name of a district and add incidents to that district abstraction.
     * @return a District to go into the Report abstraction.
     */
    private District recordDistrict() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter the District Name");
        String name = sc.nextLine();
        ArrayList<Incident> rinc = new ArrayList<>();
        rinc.add(recordIncident());

        return new District(name, rinc);

    }
    private void menu() {
        System.out.println("1: Add a District\n" +
                "2: filter all incidents with a given value\n" +
                "3: average value for a given year\n" +
                "4: print highest value incident\n\n");
    }
}
