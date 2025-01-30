package se.jimboagency.bookingsystem.ui;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import se.jimboagency.bookingsystem.logic.LogicManager;
import se.jimboagency.bookingsystem.logic.Flight;
import se.jimboagency.bookingsystem.logic.Airline;

public class UIManager {

	/*UIManager är en klass som ligger i ui paketet och är ansvarig för att kommunicera med
användaren, läsa in data och skriva ut resultat/felmeddelanden.
● UIManager innehåller bara kod som gäller gränssnitt.
● UIManager innehåller inte statiska metoder fast det kan finnas undantag.
● Jimbo har has-a relation med UIManager( composition ).*/

	private LogicManager logicmanager;
	private Airline airline;

	public UIManager (LogicManager logicmanager) {
		this.setLogicmanager(logicmanager);
	}
	
	public UIManager (Airline airline) {
		this.setAirline(airline);
	}

	public void start(String[] args) {

		if (logicmanager.authenticate()) {
			System.out.println("Inloggning godkänd.");
			showMainMenu();
		} else {
			System.out.println("Fel användarnamn eller lösenord.");
		}
	}
	
	private Flight flight;
	
	Flight flight1 = new Flight(null, null, null, null, null, null, null, 0, 0, 0, 0, 0);

	public UIManager (Flight flight) {
		this.setFlight(flight);
	}

	private Scanner input = new Scanner(System.in);

	public void showMainMenu() {
		boolean continueLoop = true;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while(continueLoop) {
			
			System.out.println("Tryck enter för Main Menu.");
		    
		    if (input.hasNextLine()) { 
		        input.nextLine(); // Töm bufferten om det behövs
		    }
		    
		    input.nextLine(); // Väntar på att användaren trycker Enter
		    
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
					//airline.ChooseAirline();
					CreateFlight();
				break;
				case 2:
					//DeleteFlight();
					//System.out.println("Flight deleted: " + Flight.getFlightNumber());
				break;
				case 3:
					//CreateBooking();
				break;
				case 5:
					//SearchBooking();
				break;
				case 6:
					//UpdateBooking();
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
	
	public LogicManager getLogicmanager() {
		return logicmanager;
	}

	public void setLogicmanager(LogicManager logicmanager) {
		this.logicmanager = logicmanager;
	}
	
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public int Choice() {
		return 0;

	}

	public void CreateFlight() {
		Scanner scanner = new Scanner(System.in);
		
		String FlightNumber = flight1.FlightNumber();
		System.out.println(FlightNumber);

		System.out.println("Enter departure city: ");
		String DepartureCity = scanner.nextLine();
		
		System.out.println("Enter arrival city: ");
		String ArrivalCity = scanner.nextLine();
		
		System.out.println("Enter departure day: ");
		String DepartureDay = scanner.nextLine();

		System.out.println("Enter arrival day: ");
		String ArrivalDay = scanner.nextLine();
		
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

		System.out.println("Enter which year: ");
		int Year = scanner.nextInt();
		
		System.out.println("Enter number of seats: ");
		int NumberOfSeats = scanner.nextInt();

		//Flight flight = new Flight(DepartureCity, ArrivalCity, DepartureDay, DepartureTime, TravelTimeHours, TravelTimeMinutes, Week, NumberOfSeats);
		logicmanager.CreateFlight(FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay, DepartureTime, ArrivalTime, TravelTimeHours, TravelTimeMinutes, Week, Year, NumberOfSeats);
		//return flight;
	}
}