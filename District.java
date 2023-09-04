import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class to represent a District that an incident occurs in.
 * It contains the fields that the district would have, being a name and a list of incidents.
 * It also contains related methods to return certain values from the district.
 * The values include a highest value for an incident,
 * an average value for burglaries in a year
 * and a list of burglaries above a given price value.
 *
 * @author Tokoneh Kalango
 *
 */
public class District {
    private String name;
    private ArrayList<Incident> incidents;

    /**
     *
     * @param name represents the name of the district abstraction
     * @param incidents represents a list of all burglary incidents in the district abstraction
     */
    public District(String name, ArrayList<Incident> incidents) {
        this.name = name;
        this.incidents = incidents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(ArrayList<Incident> incidents) {
        this.incidents = incidents;
    }

    /**
     * A method to make each District object abstraction readable to humans.
     *
     * @return a string representation of the district.
     */
    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", incidents=" + incidents +
                '}';
    }


    /**
     * A method to add an incident to the district abstraction
     * @param i represents an instance of an incident
     * @return true/false for whether the instance has been added to the list of incidents
     */
    public boolean addBurg(Incident i) {
        if (!incidents.contains(i)) {
            return incidents.add(i);
        } else {
            return false;
        }
    }

    /**
     * A method to return the incident that has the highest value in a given district
     * @return incident with value greater than all other values.
     */
    public Incident highestValueIncident () {

        ArrayList<Incident> g = new ArrayList<>();

        for (Incident i : incidents) {
            g.add(i);
            g.sort(Comparator.comparing(Incident :: getValue).reversed());
        }return g.get(0);
    }

    /**
     * A method to return the average value for a given year in a given district
     *
     * @param year represents the year that you want to get the average value for
     * @return the representation of the average value as a double
     */
    public double averageValue(int year) {
        ArrayList<Incident> h = new ArrayList<>();

        for (Incident a : incidents) {
            if (a.getYear()==(year)) {
                h.add(a);
            }
        }
        double sum = 0;
        for (Incident s : h) {
            sum += s.getValue();

        }return sum/ h.size();

    }

    /**
     * A method to filter out all the Incidents worth more than a certain value.
     *
     * @param value represents the value we want to filter the list by.
     * @return a list of all Incidents that don't get filtered out by the method.
     */
    public ArrayList<Incident> filterIncidentValues(double value) {

        ArrayList<Incident> tmp = new ArrayList<>();

        for (Incident i : incidents) {
            if (i.getValue() > value) {
                tmp.add(i);
            }
        }
        return tmp;
    }

}
