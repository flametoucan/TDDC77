package se.jimboagency.bookingsystem.ui;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
	Airline airline = Airline.getInstance();

	public UIManager (LogicManager logicmanager) {
		this.setLogicmanager(logicmanager);
	}
	
	public UIManager (Airline airline) {
		this.setAirline(airline);
	}

	private static final Scanner scanner = new Scanner(System.in);

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
			System.out.println("4. Search Booking");
			System.out.println("5. Update Booking");
			System.out.println("6. Show Current Time");
			System.out.println("7. Show Current Date");
			System.out.println("8. Exit");
			
			int val = input.nextInt();
			
			switch (val) {
				case 1:
					if (airline == null) {
					    airline = new Airline();
					}
					CreateFlight();
					
				break;
				case 2:
					deleteFlightName();
                
				break;
				case 3:
					CreateBooking();
					
				break;
				case 4:
					Scanner scanner = new Scanner(System.in);
					System.out.print("Sök bokning efter kundnamn eller flightnummer: ");
					String input = scanner.nextLine();
					
					logicmanager.SearchBooking(input);
				
				break;
				case 5:
					Scanner scanname = new Scanner(System.in);
					System.out.print("Sök bokning efter kundnamn: ");
					String inputname = scanname.nextLine();

					Scanner scannumb = new Scanner(System.in);
					System.out.print("Skriv in den nya flighten du vill boka: ");
					String inputnumb = scannumb.nextLine();

					Scanner scanair = new Scanner(System.in);
					System.out.print("skriv in den nya airlinen du vill boka: ");
					String inputair = scanair.nextLine();

					logicmanager.UpdateBooking(inputname, inputnumb, inputair);
				break;
				case 6:
				LocalTime currentTime = LocalTime.now();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				String formattedTime = currentTime.format(formatter);
		
				System.out.println("Formatted time: " + formattedTime);
				break;
				case 7:
				LocalDate currentDate = LocalDate.now();

	        	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   		     	String formattedDate = currentDate.format(formatter2);

        		System.out.println("Current Date: " + formattedDate);
				break;
				case 8:
					continueLoop = false;
				break;

			}
		}

	}
	
	public void CreateBooking() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Välj flygbolag:");
		System.out.println("1. SAS");
		System.out.println("2. Lufthansa");
		System.out.println("3. Emirates");
		System.out.println("4. Ryanair");
		System.out.println("5. KLM");

		int AirlineChoice = input.nextInt();

		String airline = switch (AirlineChoice) {
			case 1 -> "SAS";
			case 2 -> "Lufthansa";
			case 3 -> "Emirates";
			case 4 -> "Ryanair";
			case 5 -> "KLM";
			default -> {
				System.out.println("Ogiltigt val.");
				yield "Okänt flygbolag";
			}
		};

		// Visa flights
		Map<String, Map<String, Flight>> allFlights = logicmanager.loadFlightsFromJson();
		Map<String, Flight> airlineFlights = allFlights.get(airline);

		if (airlineFlights == null || airlineFlights.isEmpty()) {
			System.out.println("Inga flights tillgängliga för detta bolag.");
			return;
		}

		System.out.println("Tillgängliga flights:");
		for (Map.Entry<String, Flight> entry : airlineFlights.entrySet()) {
			System.out.println("FlightNumber: " + entry.getKey() + ", Från: " + entry.getValue().getDepartureCity() + ", Till: " + entry.getValue().getArrivalCity());
		}

		System.out.print("Skriv in flightnummer du vill boka: ");
		String flightNumber = scanner.nextLine();

		System.out.print("Skriv in ditt namn: ");
		String customerName = scanner.nextLine();

		logicmanager.CreateBooking(customerName, flightNumber, airline); 
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

    List<String> validAirports = Arrays.asList("LKP", "ARN", "CPH", "OSL", "GOT", "HEL");
    List<String> validDays = Arrays.asList("Måndag", "Tisdag", "Onsdag", "Torsdag", "Fredag", "Lördag", "Söndag");

    airline.ChooseAirline();

    String FlightNumber = flight1.FlightNumber();
    System.out.println(FlightNumber);

    String DepartureCity;
    while (true) {
        System.out.println("Enter departure city (LKP, ARN, CPH, OSL, GOT, HEL): ");
        DepartureCity = scanner.nextLine().trim().toUpperCase();
        if (validAirports.contains(DepartureCity)) break;
        System.out.println("Invalid airport code. Try again.");
    }

    String ArrivalCity;
    while (true) {
        System.out.println("Enter arrival city (LKP, ARN, CPH, OSL, GOT, HEL): ");
        ArrivalCity = scanner.nextLine().trim().toUpperCase();
        if (validAirports.contains(ArrivalCity)) break;
        System.out.println("Invalid airport code. Try again.");
    }

    String DepartureDay;
    while (true) {
        System.out.println("Enter departure day (Måndag - Söndag): ");
        DepartureDay = scanner.nextLine().trim();
        if (validDays.contains(DepartureDay)) break;
        System.out.println("Invalid day. Try again.");
    }

    String ArrivalDay;
    while (true) {
        System.out.println("Enter arrival day (Måndag - Söndag): ");
        ArrivalDay = scanner.nextLine().trim();
        if (validDays.contains(ArrivalDay)) break;
        System.out.println("Invalid day. Try again.");
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime DepartureTime = null;

    while (DepartureTime == null) {
        try {
            System.out.print("Enter departure time (HH:mm): ");
            String departureTimeInput = scanner.nextLine();
            DepartureTime = LocalTime.parse(departureTimeInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Please use HH:mm format.");
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

    logicmanager.CreateFlight(
        FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay,
        DepartureTime, ArrivalTime, TravelTimeHours, TravelTimeMinutes,
        Week, Year, NumberOfSeats
    );
}

	
	public static void deleteFlightName() {
		List<String> airlines = LogicManager.getAllAirlines();

		if (airlines.isEmpty()) {
			System.out.println("No airlines available.");
			return;
		}

		System.out.println("Choose an airline:");
		for (int i = 0; i < airlines.size(); i++) {
			System.out.println((i + 1) + ". " + airlines.get(i));
		}

		System.out.print("Enter your choice (number): ");
		int choice = Integer.parseInt(scanner.nextLine());

		if (choice < 1 || choice > airlines.size()) {
			System.out.println("Invalid airline choice.");
			return;
		}

		String selectedAirline = airlines.get(choice - 1);
		List<String> flights = LogicManager.getFlightsForAirline(selectedAirline);

		if (flights.isEmpty()) {
			System.out.println("No flights found for airline: " + selectedAirline);
			return;
		}

		System.out.println("Flights under " + selectedAirline + ":");
		for (String flight : flights) {
			System.out.println("  - " + flight);
		}

		System.out.print("Enter the flight number you want to delete: ");
		String flightNumber = scanner.nextLine();

		if (flights.contains(flightNumber)) {
			LogicManager.deleteFlight(flightNumber);
		} else {
			System.out.println("Invalid flight number.");
		}
	}
}