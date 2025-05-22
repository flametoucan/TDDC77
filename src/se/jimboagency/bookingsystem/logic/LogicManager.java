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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Paths;

public class LogicManager {

	//inlogg
	private String[] args;
	private LogicManager logicmanager;
	Airline airline = Airline.getInstance();
	private List<User> users;

    private static final String FLIGHT_FILE = Paths.get("src", "se", "jimboagency", "bookingsystem", "logic", "Flights.json").toString();
    private static final String BOOKING_FILE = Paths.get("src", "se", "jimboagency", "bookingsystem", "logic", "Booking.json").toString();
	private static final Type flightDataType = new TypeToken<Map<String, Map<String, Flight>>>() {}.getType();

	public LogicManager(String[] args) {
		this.args = args;

		users = new ArrayList<>();
		users.add(new User("shipa001", "2eff43"));
		users.add(new User("Ennpe001", "wedr5t"));
		users.add(new User("julno001", "wwr4r3"));
		users.add(new User("johni001", "1k9h6d"));
		users.add(new User("adabe001", "0o3u33"));

		this.airline = Airline.getInstance();

		flightMap = loadFlightsFromJson();
		bookings = loadBookingsFromJson();
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
	private static Map<String, Flight> bookings = new HashMap<>();
	private static final Gson gsonWithAdapters = new GsonBuilder()
    	.registerTypeAdapter(LocalTime.class, new LocalTimeAdapter())
    	.setPrettyPrinting()
    	.create();

   		
   	
	public String CreateFlight(String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureDay, String ArrivalDay, LocalTime DepartureTime, LocalTime ArrivalTime, Long TravelTimeHours,Long TravelTimeMinutes,int Week, int Year, int NumberOfSeats) {

		Flight flight = new Flight(FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay, DepartureTime, ArrivalTime, TravelTimeHours, TravelTimeMinutes, Week, Year, NumberOfSeats);
		
		String airlineName = Airline.getInstance().getAirlineCompany();
		
		Map<String, Flight> airlineFlights = flightMap.getOrDefault(airlineName, new HashMap<>());
		airlineFlights.put(flight.getFlightNumber(), flight);
		flightMap.put(airlineName, airlineFlights);

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
		try (FileWriter file = new FileWriter(FLIGHT_FILE)) {
			String jsonOutput = gsonWithAdapters.toJson(flightMap);
			file.write(jsonOutput);
			file.flush();
			System.out.println("All flight data successfully saved to Flights.json");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file:");
			e.printStackTrace();
		}
	}
	
	
	public static List<String> getAllAirlines() {
		try (FileReader reader = new FileReader(FLIGHT_FILE)) {
			Map<String, Map<String, Flight>> data = gsonWithAdapters.fromJson(reader, flightDataType);
			return new ArrayList<>(data.keySet());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List<String> getFlightsForAirline(String airline) {
		try (FileReader reader = new FileReader(FLIGHT_FILE)) {
			Map<String, Map<String, Flight>> data = gsonWithAdapters.fromJson(reader, flightDataType);
			if (data.containsKey(airline)) {
				return new ArrayList<>(data.get(airline).keySet());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static boolean flightExists(String flightNumber) {
        try (FileReader reader = new FileReader(FLIGHT_FILE)) {
            Map<String, Map<String, Flight>> data = gsonWithAdapters.fromJson(reader, flightDataType);
            for (Map<String, Flight> flights : data.values()) {
                if (flights.containsKey(flightNumber)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

	public static void deleteFlight(String flightNumber) {
		try (FileReader reader = new FileReader(FLIGHT_FILE)) {
			Map<String, Map<String, Flight>> data = gsonWithAdapters.fromJson(reader, flightDataType);

			boolean found = false;

			Iterator<Map.Entry<String, Map<String, Flight>>> iterator = data.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Map<String, Flight>> airlineEntry = iterator.next();
				Map<String, Flight> flights = airlineEntry.getValue();

				if (flights.containsKey(flightNumber)) {
					flights.remove(flightNumber);
					found = true;

					if (flights.isEmpty()) {
						iterator.remove(); // Remove the airline if no flights are left
					}
					break;
				}
			}

			if (found) {
				try (FileWriter writer = new FileWriter(FLIGHT_FILE)) {
					gsonWithAdapters.toJson(data, writer);
				}
				System.out.println("Flight deleted: " + flightNumber);
			} else {
				System.out.println("Flight number not found.");
			}
		} catch (Exception e) {
			e.printStackTrace();
    }
}
	
	public void CreateBooking(String customerName, String flightNumber, String airlineName) {
		Map<String, Map<String, Flight>> allFlights = loadFlightsFromJson();

		if (allFlights.containsKey(airlineName)) {
			Map<String, Flight> airlineFlights = allFlights.get(airlineName);
			if (airlineFlights.containsKey(flightNumber)) {
				Flight selectedFlight = airlineFlights.get(flightNumber);

				bookings.put(customerName, selectedFlight); // Lägg till ny bokning

				saveBookingsToJson(bookings); // Spara till filen

				System.out.println("Bokningen sparades för: " + customerName);
			} else {
				System.out.println("Flightnummer hittades inte.");
			}
		} else {
			System.out.println("Airline finns inte.");
		}
	}


	public Map<String, Map<String, Flight>> loadFlightsFromJson() {
		try (Reader reader = new FileReader(FLIGHT_FILE)) {
			Type type = new TypeToken<Map<String, Map<String, Flight>>>() {}.getType();
			Map<String, Map<String, Flight>> flights = gsonWithAdapters.fromJson(reader, type);
			return flights != null ? flights : new HashMap<>();
		} catch (IOException e) {
			System.out.println("Kunde inte läsa flights.json: " + e.getMessage());
			return new HashMap<>();
		}
	}
	
	

	public Map<String, Flight> loadBookingsFromJson() {
		File file = new File(BOOKING_FILE);
	
	
		try (Reader reader = new FileReader(file)) {
			Type type = new TypeToken<Map<String, Flight>>(){}.getType();
			return gsonWithAdapters.fromJson(reader, type);
		} catch (Exception e) {
			System.out.println("Kunde inte läsa Booking.json: " + e.getMessage());
			return new HashMap<>();
		}
	}	
	
	
	public void saveBookingsToJson(Map<String, Flight> bookings) {
		try (Writer writer = new FileWriter(BOOKING_FILE)) {
			gsonWithAdapters.toJson(bookings, writer);
		} catch (IOException e) {
			System.out.println("Kunde inte spara bokning: " + e.getMessage());
		}
	}
	
	public void SearchBooking() {
		
	}
	
	public void UpdateBooking() {
	
	}
	
	public void ShowBooking() {
		// ska printa i formatet Resenummer — Flygnummer — Avgångs stad(Avgångs dag) — Ankomst stad(Ankomst dag) — Veckonummer — År — Avgångstid — Ankomsttid
	}
	
}


