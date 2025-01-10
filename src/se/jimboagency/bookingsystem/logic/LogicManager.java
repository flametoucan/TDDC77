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
		
	public LogicManager(String[] args) {
		this.args = args;
	}
	
	public boolean authenticate() {
		if(args.length == 4) {
			if(args[0].equals("-u") && args[2].equals("-p")) {
				User employee = new User(args[1],args[3]);
				return true;
			}  
			
			else if(args[0].equals("-p") && args[2].equals("-u")) {
				User employee = new User(args[3],args[1]);
				return true;
			} 
		} //employee has nothing in it currently
	return false;
	}
		
		/*public void CreateFlight() {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter departure city: ");
			String DepartureCity = scanner.nextLine();
			
			System.out.println("Enter arrival city: ");
			String ArrivalCity = scanner.nextLine();
			
			System.out.println("Enter departure day: ");
			String DepartureDay = scanner.nextLine();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
			LocalTime DepartureTime = null;
			
			while (DepartureTime == null) {
	            try {
	                System.out.print("Enter departure time: ");
	                String departureTimeInput = scanner.nextLine();
	                DepartureTime = LocalTime.parse(departureTimeInput, formatter);
	            } catch (DateTimeParseException e) {
	                System.out.println("Invalid time format. Please use HH:mm format! ");
	            }
			}
	            
			System.out.println("Enter travel time (hours): ");
			long TravelTimeHours = scanner.nextLong();
			
			System.out.println("Enter travel time (minutes): ");
			long TravelTimeMinutes = scanner.nextLong();
			
			LocalTime ArrivalTime = DepartureTime.plusHours(TravelTimeHours).plusMinutes(TravelTimeMinutes);
			
			System.out.println("Enter week number: ");
			int Week = scanner.nextInt();
			
			System.out.println("Enter number of seats: ");
			int NumberOfSeats = scanner.nextInt();
			
			//scanner.close(); 

			//Flight flight = new Flight(DepartureCity, ArrivalCity, DepartureDay, DepartureTime, TravelTimeHours, TravelTimeMinutes, Week, NumberOfSeats);

			//return flight;
		}*/
		
		public String CreateFlight(String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureDay, String ArrivalDay, LocalTime DepartureTime,Long TravelTimeHours,Long TravelTimeMinutes,int Week, int NumberOfSeats) {
	        // Test the createFlight method
	        //Flight newFlight = CreateFlight();
			Flight flight = new Flight(FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay, DepartureTime, TravelTimeHours, TravelTimeMinutes, Week, NumberOfSeats);
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
	
	public void MainMenu() {
		boolean continueLoop = true;
		Scanner input = new Scanner(System.in);
		while(continueLoop) {
			System.out.println("Menu:");
			System.out.println("1. Create Flight");
			System.out.println("2. Delete Flight");
			System.out.println("3. Create Booking");
			System.out.println("5. Search Booking");
			System.out.println("6. Update Booking");
			System.out.println("7. Show Current Time");
			System.out.println("8. Show Current Date");
			System.out.println("9. Exit");
			
			//UImanager.Choice();

			int val = input.nextInt();

			switch (val) {
				case 1:
					//CreateFlight();
					/*System.out.println(
						"Flight created: " +Flight.getFlightNumber() +" { \n" + 
						"Departure city = " +Flight.getDepartureCity() +"\t" +
						"Arrival city = " +Flight.getArrivalCity() +"\n" +
						"Departure day = " +Flight.getDepartureDay() +"\t" +
						"Arrival day = " +Flight.getArrivalDay() +"\n" +
						"Departure time = " +Flight.getDepartureTime() +"\t" +
						"Arrival time = " +Flight.getArrivalTime() +"\n" +
						"Departure week = " +Flight.getWeek() +"\t" +
						"Number of seats = " +Flight.getNumberOfSeats() +"\t");*/
				break;
				case 2:
					DeleteFlight();
					//System.out.println("Flight deleted: " + Flight.getFlightNumber());
				break;
				case 3:
					CreateBooking();
				break;
				case 5:
					SearchBooking();
				break;
				case 6:
					UpdateBooking();
				break;
				case 7:
				LocalTime currentTime = LocalTime.now();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				String formattedTime = currentTime.format(formatter);
		
				System.out.println("Formatted time: " + formattedTime);
				break;
				case 8:
				LocalDate currentDate = LocalDate.now();

	        	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   		     	String formattedDate = currentDate.format(formatter2);

        		System.out.println("Current Date: " + formattedDate);
				break;
				case 9:
					continueLoop = false;
				break;

			}
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













