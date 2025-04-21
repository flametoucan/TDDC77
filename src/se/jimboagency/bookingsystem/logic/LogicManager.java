package se.jimboagency.bookingsystem.logic;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.*;
import se.jimboagency.bookingsystem.logic.*;
import se.jimboagency.bookingsystem.ui.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import java.io.*;


public class LogicManager {

	//inlogg
	private String[] args;
	private LogicManager logicmanager;
	Airline airline = Airline.getInstance();
	private List<User> users;
		
	public LogicManager(String[] args) {
		this.args = args;

		users = new ArrayList<>();
		users.add(new User("shipa001", "2eff43"));
		users.add(new User("Ennpe001", "wedr5t"));
		users.add(new User("julno001", "wwr4r3"));
		users.add(new User("johni001", "1k9h6d"));
		users.add(new User("adabe001", "0o3u33"));

		airline = new Airline();
	}
	
	public boolean authenticate() {
		if(args.length == 4) {

			String username = null;
			String password = null;

			if(args[0].equals("-u") && args[2].equals("-p")) {
				username = args[1];
				password = args[3];
				
			}  
			
			else if(args[0].equals("-p") && args[2].equals("-u")) {
				username = args[3];
				password = args[1];
				
			} 

			if(username != null && password != null) {
				for (User user : users) {
					if(user.getUsername().equals(username) && user.getPassword().equals(password));
					return true;
				}
			}
		} 
	return false;
	}

	private static Map<String, Map<String, Flight>> flightMap = new HashMap<>();
   	private static final Gson gson = new GsonBuilder()
   			.registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
   			.setPrettyPrinting()
   			.create();
   		
   	
	public String CreateFlight(String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureDay, String ArrivalDay, LocalTime DepartureTime, LocalTime ArrivalTime, Long TravelTimeHours,Long TravelTimeMinutes,int Week, int Year, int NumberOfSeats) {

		Flight flight = new Flight(FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay, DepartureTime, ArrivalTime, TravelTimeHours, TravelTimeMinutes, Week, Year, NumberOfSeats);
		
		//Savemethod to json file here
		
		String airlineName = Airline.getInstance().getAirlineCompany();
		
		Map<String, Flight> airlineFlights = flightMap.getOrDefault(airlineName, new HashMap<>());
		airlineFlights.put(flight.getFlightNumber(), flight);
		flightMap.put(airlineName, airlineFlights);
		
		//FIXA SKITEN RADERAR ALLTID

		saveFlightsToJson();

		System.out.println(
			"Flight created: " +flight.getFlightNumber() +" { \n" + 
			"Departure city = " +flight.getDepartureCity() +"\t" +
			"Arrival city = " +flight.getArrivalCity() +"\n" +
			"Departure day = " +flight.getDepartureDay() +"\t" +
			"Arrival day = " +flight.getArrivalDay() +"\n" +
			"Departure time = " +flight.getDepartureTime() +"\t" +
			"Arrival time = " +flight.getArrivalTime() +"\n" +
			"Departure week = " +flight.getWeek() +"\t" +
			"Number of seats = " +flight.getNumberOfSeats() +"\t");
				return "";
    }

	private static void saveFlightsToJson() {
        try (FileWriter file = new FileWriter("Flights.json")) {
            String jsonOutput = gson.toJson(flightMap);
            file.write(jsonOutput);
            file.flush();
            System.out.println("All flight data successfully saved to Flights.json");
        } 
		catch (IOException e) {
            System.out.println("An error occurred while writing to the file:");
            e.printStackTrace();
        }	
		}
	
	public void DeleteFlight() {
		
	}
	
	public void CreateBooking() {
		
	}

	public void SearchBooking() {
		
	}
	
	public void UpdateBooking() {
	
	}
	public void ShowBooking() {
		// ska printa i formatet Resenummer — Flygnummer — Avgångs stad(Avgångs dag) — Ankomst stad(Ankomst dag) — Veckonummer — År — Avgångstid — Ankomsttid
	}
	
}


