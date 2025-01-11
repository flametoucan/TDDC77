package se.jimboagency.bookingsystem.logic;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.*;
import se.jimboagency.bookingsystem.logic.Flight;
import se.jimboagency.bookingsystem.ui.*;

public class LogicManager {

	//inlogg
	private String[] args;
	private LogicManager logicmanager;
	private List<User> users;
		
	public LogicManager(String[] args) {
		this.args = args;

		users = new ArrayList<>();
		users.add(new User("shipa001", "2eff43"));
		users.add(new User("Ennpe001", "wedr5t"));
		users.add(new User("julno001", "wwr4r3"));
		users.add(new User("johni001", "1k9h6d"));
		users.add(new User("adabe001", "0o3u33"));

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
		
	public String CreateFlight(String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureDay, String ArrivalDay, LocalTime DepartureTime,LocalTime ArrivalTime, Long TravelTimeHours,Long TravelTimeMinutes,int Week, int Year, int NumberOfSeats) {
        // Test the createFlight method
        //Flight newFlight = CreateFlight();
		Flight flight = new Flight(FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay, DepartureTime, ArrivalTime, TravelTimeHours, TravelTimeMinutes, Week, Year, NumberOfSeats);
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
       //System.out.println("Flight created: " + newFlight);
				return "";
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













