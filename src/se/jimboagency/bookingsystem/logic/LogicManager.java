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

public class LogicManager {

	//inlogg
	private static String[] args;
	public LogicManager(String[] args2) {
		//lägg in users typ, kke lite mer grejs
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
	//skapa hashset för allt
	
	private String[] days = {"måndag","tisdag","onsdag","torsdag", "fredag", "lördag", "söndag"};
	public void Sets() {
	HashSet<String> city = new HashSet<String>();
	HashSet<String> day = new HashSet<String>();
	HashSet<String> departure = new HashSet<String>();
	HashSet<String> arrival = new HashSet<String>();
	//lägg till lite dler men måste kolla vilken sort de ska vara
	
	}
	
	public class CreateFlight {
		
		public static Flight CreateFlight() {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter flightnumber: ");
			String FlightNumb = scanner.nextLine();
			
			System.out.println("Enter departure city: ");
			String DepartureCity = scanner.nextLine();
			
			System.out.println("Enter departure day: ");
			String DepartureDay = scanner.nextLine();
			
			System.out.println("Enter departure time: ");
			String DepartureTime = scanner.nextLine();
			
			System.out.println("Enter week number: ");
			int Week = scanner.nextInt();
			
			System.out.println("Enter number of seats: ");
			int NumberOfSeats = scanner.nextInt();
			
			System.out.println("Enter arrival city: ");
			String ArrivalCity = scanner.nextLine();
			
			Flight flight = new Flight(FlightNumb, DepartureCity, DepartureDay, DepartureTime, Week, NumberOfSeats, ArrivalCity);
			return flight;
			
		}
		
		public static void main(String[] args) {
	        // Test the createFlight method
	        Flight newFlight = CreateFlight();
	        System.out.println("Flight created: " + newFlight);
	    }
	}
	
	public void DeleteFlight() {
		
	}
	
	public void SearchBooking() {
		
	}
	
	public void CreateBooking() {
		
	}

	public void UpdateBooking() {
	
	}
	public void ShowBooking() {
		// ska printa i formatet Resenummer — Flygnummer — Avgångs stad(Avgångs dag) — Ankomst stad(Ankomst dag) — Veckonummer — År — Avgångstid — Ankomsttid
	}
}













