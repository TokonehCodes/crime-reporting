/**
 * This is a class to represent a Burglary Incident object.
 * It contains fields representing abstract attributes of each burglary
 *
 * @author Tokoneh Kalango
 */

public class Incident {
    private double value;
    private String postcode;
    private String month;
    private int year;

    /**
     *
     * @param value represents the value of everything which has been stolen in an abstract Incident
     * @param postcode represents the postcode of the address of an abstract Incident
     * @param month represents the month that an abstract Incident occurs
     * @param year represents the year that an abstract Incident occurs
     */
    public Incident(double value, String postcode, String month, int year) {
        this.value = value;
        this.postcode = postcode;
        this.month = month;
        this.year = year;
    }



    public double getValue() {
        return value;
    }


    public String getPostcode() {
        return postcode;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * A method to make each Incident object readable for humans.
     *
     * @return string representation of an incident.
     */
    @Override
    public String toString() {
        return "Incident{" +
                "value=" + value +
                ", postcode='" + postcode + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}