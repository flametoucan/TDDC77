package se.jimboagency.bookingsystem.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
<<<<<<< HEAD
=======
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
>>>>>>> mabjo196
import java.time.*;

public class LogicManager {

	//inlogg
	private static String[] args;
		
		public LogicManager(String[] args) {
			LogicManager.args = args; // Assign the argument array to the static field
	}
	
	public static boolean authenticate() {
		if(args.length == 4) {
			if(args[0].equals("-u") && args[2].equals("-p")) {
				User employee = new User(args[1],args[3]);
				return true;
			}  // kolla med hjälp av userklassen om inlogg e rätt så att man returnar true om de e sant
			
			else if(args[0].equals("-p") && args[2].equals("-u")) {
				User employee = new User(args[3],args[1]);
				return true;
			} // kolla med hjälp av userklassen om inlogg e rätt så att man returnar true om de e sant
		}
	return false;
	}
	
	public class CreateFlight {
		
		public static Flight CreateFlight() {
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
			
			Flight flight = new Flight(DepartureCity, ArrivalCity, DepartureDay, DepartureTime, TravelTimeHours, TravelTimeMinutes, Week, NumberOfSeats);
			return flight;
			
		}
		
		public static void main(String[] args) {
	        // Test the createFlight method
	        Flight newFlight = CreateFlight();
	        System.out.println("Flight created: " + newFlight);
	    }
	}
	public static void MainMenu() {

		Scanner input = new Scanner(System.in);

		System.out.println("Menu:");
        System.out.println("1. Create Flight");
        System.out.println("2. Delete Flight");
        System.out.println("3. Create Booking");
        System.out.println("4. Search Booking");
        System.out.println("5. Update Booking");
        System.out.println("6. Show Current Time");
        System.out.println("7. Show Current Date");
        System.out.println("8. ");
        System.out.println("9. Exit");
		
		int val = input.nextInt();

            switch (val) {
				case 1:
				break;
				case 2:
				break;
				case 3:
				break;
				case 4:
				break;
				case 5:
				break;
				case 6:
				break;
				case 7:
				break;
				case 8:
				break;
				case 9:
				break;

			}

	}
	public void DeleteFlight() {
		
	}
	
	public void SearchBooking() {
		
	}
	
	public void CreateBooking() {
		
	}

	public static void UpdateBooking() {
	
	}
	public void ShowBooking() {
		// ska printa i formatet Resenummer — Flygnummer — Avgångs stad(Avgångs dag) — Ankomst stad(Ankomst dag) — Veckonummer — År — Avgångstid — Ankomsttid
	}
	
}













