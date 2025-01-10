package se.jimboagency.bookingsystem.logic;

import java.util.Random;
import java.time.*;

public class Flight extends Airline {
	
	private String FlightNumber;
	private String DepartureCity;
	private String DepartureDay;
	private LocalTime DepartureTime;
	private String ArrivalCity;
	private String ArrivalDay;
	private String ArrivalTime;
	private long TravelTimeHours;
	private long TravelTimeMinutes;
	private int Week;
	private int Year;
	private int NumberOfSeats;
	
	public Flight (String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureDay, String ArrivalDay, LocalTime DepartureTime, long TravelTimeHours, long TravelTimeMinutes, int Week, int Year) {
		this.FlightNumber = FlightNumber;
		this.DepartureCity = DepartureCity;
		this.DepartureDay = DepartureDay;
		this.DepartureTime = DepartureTime;
		this.ArrivalCity = ArrivalCity;
		this.ArrivalDay = ArrivalDay;
		this.ArrivalTime = ArrivalTime;
		this.TravelTimeHours = TravelTimeHours;
		this.TravelTimeMinutes = TravelTimeMinutes;
		this.Week = Week;
		this.Year = Year;
		this.NumberOfSeats = NumberOfSeats;
	}

	public void Seats() {
		
	}
	
	public String FlightNumber() {
		Random random = new Random();
		
		char letter1 = (char) ('A' + random.nextInt(26)); // Random letter between 'A' and 'Z'
        char letter2 = (char) ('A' + random.nextInt(26)); // Random letter between 'A' and 'Z'

        // Generate three random digits
        int number = random.nextInt(1000); // Skapar ett nummer mellan 000 och 999

        // Sätter ihop bokstäverna och numret och returnerar värdet som "XX000"
        return String.format("%c%c%03d", letter1, letter2, number);
	}
	
	public String getFlightNumber() {
		return FlightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		FlightNumber = flightNumber;
	}

	public String getDepartureCity() {
		return DepartureCity;
	}

	public void setDepartureCity(String departureCity) {
		DepartureCity = departureCity;
	}

	public String getDepartureDay() {
		return DepartureDay;
	}

	public void setDepartureDay(String departureDay) {
		DepartureDay = departureDay;
	}

	public LocalTime getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		DepartureTime = departureTime;
	}

	public String getArrivalCity() {
		return ArrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		ArrivalCity = arrivalCity;
	}
	
	public String getArrivalDay() {
		return ArrivalDay;
	}

	public void setArrivalDay(String arrivalDay) {
		ArrivalDay = arrivalDay;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public long getTravelTimeHours() {
		return TravelTimeHours;
	}

	public void setTravelTimeHours(long travelTimeHours) {
		TravelTimeHours = travelTimeHours;
	}
	
	public long getTravelTimeMinutes() {
		return TravelTimeMinutes;
	}

	public void setTravelTimeMinutes(long travelTimeMinutes) {
		TravelTimeMinutes = travelTimeMinutes;
	}

	public int getWeek() {
		return Week;
	}

	public void setWeek(int week) {
		Week = week;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getNumberOfSeats() {
		return NumberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		NumberOfSeats = numberOfSeats;
	}
	
	@Override
	public String toString() {
		return "Flight created: " +FlightNumber +" { \n" + 
		"Departure city = " +DepartureCity +"\t" +
		"Arrival city = " +ArrivalCity +"\n" +
		"Departure day = " +DepartureDay +"\t" +
		"Arrival day = " +ArrivalDay +"\n" +
		"Departure time = " +DepartureTime +"\t" +
		"Arrival time = " +ArrivalTime +"\n" +
		"Departure week = " +Week +"\t" +
		"Number of seats = " +NumberOfSeats +"\t";
	
	}
}
