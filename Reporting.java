import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class to represent a Report.
 * A report contains 1 field, which is a list of all the districts.
 * There are methods which are carried out on that list of all districts.
 * The methods include:
 * A method to get the Incident which has the highest value amongst all districts.
 * A method to get the District which contains the highest average burglaries for a given year
 * A method to filter out all Incidents above a certain value amongst all districts.
 *
 * @author Tokoneh Kalango
 */
public class Reporting {
    private ArrayList<District> districts = new ArrayList<>();


    public ArrayList<District> getDistricts() {
        return districts;
    }


    /**
     * A method to add the Districts to the district list in Reporting class.
     * @param d represents a district in the list of districts
     */
    public void addDist(District d) {
      districts.add(d);
    }

    /**
     * A method to get the Incident which has the highest value amongst all districts.
     * @return the Incident with the highest value ever.
     */
    public Incident highestValInc() {

        List<Incident> dists = new ArrayList<>();

        for (District d : districts) {
            dists.add(d.highestValueIncident());
            dists.sort(Comparator.comparing(Incident :: getValue).reversed());
        } return dists.get(0);
    }

    /**
     * A method to get the District which contains the highest average burglaries for a given year
     * @param year represents the year we want to get the value for
     * @return the district with the highest year average
     */
    public District highestAverage(int year) {
        District dist = districts.get(0);

        for (District d : districts) {
            if (d.averageValue(year) > dist.averageValue(year)) {
                dist = d;
            }
        } return dist;
    }

    /**
     * A method to filter out all Incidents above a certain value amongst all districts.
     * @param value represents a value to filter the incidents by
     * @return a list of Incidents which are above a certain value.
     */
    public List<ArrayList<Incident>> highIncidents(double value) {

        List<ArrayList<Incident>> valuable = new ArrayList<>();

        for (District d : districts) {
            valuable.add(d.filterIncidentValues(value));
        }return valuable;
    }

    public static void main(String[] args) {
        ArrayList<District> report = new ArrayList<>();
        Reporting r1 = new Reporting();

        Incident i1 = new Incident(724.3, "NE45TG", "January", 2021);
        Incident i2 = new Incident(300, "NE16BA", "December", 2019);
        Incident i3 = new Incident(412.53, "NE37HH", "October", 2020);
        Incident i4 = new Incident(1452.6, "NW34RX", "November", 2020);
        Incident i5 = new Incident(2467, "SW12AB", "March", 2020);
        Incident i6 = new Incident(6623.4, "SE12BJ", "September", 2020);
        Incident i7 = new Incident(935.53, "LE123GT", "June", 2020);
        Incident i8 = new Incident(325.45, "LE112VS", "October", 2019);
        Incident i9 = new Incident(1085.6, "LE46JD", "April", 2020);

        ArrayList<Incident> NCLinc = new ArrayList<>();
        ArrayList<Incident> LDNinc = new ArrayList<>();
        ArrayList<Incident> LEEinc = new ArrayList<>();
        District d1 = new District("Newcastle", NCLinc);
        District d2 = new District("London", LDNinc);
        District d3 = new District("Leeds", LEEinc);

        d1.addBurg(i1);
        d1.addBurg(i2);
        d1.addBurg(i3);

        d2.addBurg(i4);
        d2.addBurg(i5);
        d2.addBurg(i6);

        d3.addBurg(i7);
        d3.addBurg(i8);
        d3.addBurg(i9);

        r1.addDist(d1);
        r1.addDist(d2);
        r1.addDist(d3);


        System.out.println(d1.highestValueIncident());
        System.out.println(d2.averageValue(2020));
        System.out.println(d3.filterIncidentValues(500));

        System.out.println("\n Reporting methods: \n");

        System.out.println(r1.highestValInc());
        System.out.println(r1.highestAverage(2022));
        System.out.println(r1.highIncidents(1000));

    }
}
