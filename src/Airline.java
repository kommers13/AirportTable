import java.util.*;
import java.io.*;
public class Airline {
    private int id;

    private String departurePoint;

    private String destinationPoint;

    private int flightNumber;

    private String planeModel;

    private String timeFlight;

    private final boolean[] days = new boolean[7];

    public Airline(int id, String departurePoint, String destinationPoint, int flightNumber, String planeModel, String timeFlight, boolean[] days) {
        this.id = id;
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.flightNumber = flightNumber;
        this.planeModel = planeModel;
        this.timeFlight = timeFlight;
        setDays(days);
    }

    public static boolean[] nextBool(Scanner File) {
        boolean[] days = new boolean[7];
        for (int i = 0; i < 7; i++) {
            int bool = Integer.parseInt(File.nextLine());
            if (bool == 1) {
                days[i] = true;
            } else {
                days[i] = false;
            }
        }
        return days;
    }

    public void setDays(boolean[] days) {
        this.days[0] = days[0];
        this.days[1] = days[1];
        this.days[2] = days[2];
        this.days[3] = days[3];
        this.days[4] = days[4];
        this.days[5] = days[5];
        this.days[6] = days[6];
    }

    public boolean[] getDays() {
        return days;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String city) {
        this.departurePoint = city;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String city) {
        this.destinationPoint = city;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightIndex) {
        this.flightNumber = flightIndex;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(String timeFlight) {
        this.timeFlight = timeFlight;
    }

    public String toString() {
        return String.format("|%-5d|%-20s|%-20s|%-15d|%-20s|%-15s|%-25s|", getId(), getDeparturePoint(), getDestinationPoint(), getFlightNumber(), getPlaneModel(), getTimeFlight(), formatDays(getDays()));
    }

    private String formatDays(boolean[] days) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < days.length; i++){
            builder.append(days[i] ? "  +" : "  -");
        }
        return builder.toString();
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Airline airline = (Airline) obj;
        return id == airline.id && flightNumber == airline.flightNumber
                && departurePoint.equals(airline.departurePoint) && destinationPoint.equals(airline.destinationPoint)
                && planeModel.equals(airline.planeModel) && timeFlight.equals(airline.timeFlight)
                && Arrays.equals(days, airline.days);
    }




}
