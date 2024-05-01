import java.io.*;
import java.util.*;

public class Main {
    public static String header(){
        return String.format("|%-5s|%-20s|%-20s|%-15s|%-20s|%-15s|%-25s|", "Id", "DeparturePoint", "DestinationPoint", "FlightNumber", "PlaneModel", "TimeFlight", "  MO TU WE TH FR SA SU");
    }
    public static String headAndEndAndMed(){
        return  String.format("+-----+--------------------+--------------------+---------------+--------------------+---------------+-------------------------+");
    }
    public static void main(String[] args) throws Exception{

        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        int numberAirlines = Integer.parseInt(input.nextLine());
        Airline[] airlines = new Airline[numberAirlines];
        for(int i = 0; i < numberAirlines; i++){
            input.nextLine();
            int id = Integer.parseInt(input.nextLine());
            String departurePoint = input.nextLine();
            String destinationPoint = input.nextLine();
            int flightNumber = Integer.parseInt(input.nextLine());
            String planeModel = input.nextLine();
            String timeFlight = input.nextLine();
            boolean[] days = Airline.nextBool(input);
            airlines[i] = new Airline(id, departurePoint, destinationPoint, flightNumber, planeModel, timeFlight, days);
        }


        // EXAMPLE

        // List of all entries
        System.out.println(headAndEndAndMed());
        System.out.println(header());
        for(Airline airline : airlines){
            System.out.println(headAndEndAndMed());
            System.out.println(airline);
        }
        System.out.println(headAndEndAndMed());
        System.out.println('\n');

        // List of flights set destination point
        System.out.println(headAndEndAndMed());
        System.out.println(header());
        String destination = "Москва";
        for(Airline airline : airlines){
            if(airline.getDestinationPoint().equals((destination))){
                System.out.println(headAndEndAndMed());
                System.out.println(airline);
            }
        }
        System.out.println(headAndEndAndMed());
        System.out.println('\n');

        // List of flights set day a week
        System.out.println(headAndEndAndMed());
        System.out.println(header());
        int dayWeek = 2; // Tuesday
        for(Airline airline : airlines){
            if(airline.getDays()[dayWeek]) {
                System.out.println(headAndEndAndMed());
                System.out.println(airline);
            }
        }
        System.out.println(headAndEndAndMed());
        System.out.println('\n');

        // List of flights, because sent more than 3 times a week
        System.out.println(headAndEndAndMed());
        System.out.println(header());
        for(Airline airline : airlines){
            int cntBool = 0;
            for(boolean day: airline.getDays()){
                if(day){
                    cntBool++;
                }
            }
            if(cntBool >= 3){
                System.out.println(headAndEndAndMed());
                System.out.println(airline);
            }
        }
        System.out.println(headAndEndAndMed());
        System.out.println('\n');

        // List all entries, sorted of departure point
        System.out.println(headAndEndAndMed());
        System.out.println(header());
        for(int i = 0; i < airlines.length - 1; i++){
            for(int j = 0; j < airlines.length - i - 1; j++){
                if(airlines[j].getDeparturePoint().compareTo(airlines[j + 1].getDeparturePoint()) > 0){
                    Airline temp = airlines[j];
                    airlines[j] = airlines[j + 1];
                    airlines[j + 1] = temp;
                }
            }
        }
        for(Airline airline : airlines){
            System.out.println(headAndEndAndMed());
            System.out.println(airline);
        }
        System.out.println(headAndEndAndMed());


        input.close();


    }
}
