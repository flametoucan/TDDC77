package se.jimboagency.bookingsystem.logic;

import java.time.LocalTime;
import java.util.Random;

public abstract class Booking extends Flight{

	public Booking(String FlightNumber, String DepartureCity, String ArrivalCity, String DepartureDay,
			String ArrivalDay, LocalTime DepartureTime, LocalTime ArrivalTime, long TravelTimeHours,
			long TravelTimeMinutes, int Week, int Year, int NumberOfSeats) {
		super(FlightNumber, DepartureCity, ArrivalCity, DepartureDay, ArrivalDay, DepartureTime, ArrivalTime, TravelTimeHours, TravelTimeMinutes, Week, Year, NumberOfSeats);
		// TODO Auto-generated constructor stub
	}
	private String TravelNumber;
	private boolean IsUpdatable;
	
	public String CreateBookingNumber() {
		Random random = new Random();
		
		char letter1 = (char) ('A' + random.nextInt(26)); // Random letter between 'A' and 'Z'
        char letter2 = (char) ('A' + random.nextInt(26)); // Random letter between 'A' and 'Z'

        // Generate three random digits
        int number = random.nextInt(1000); // Skapar ett nummer mellan 000 och 999

        // Sätter ihop bokstäverna och numret och returnerar värdet som "XX000"
        return String.format("%c%c%03d", letter1, letter2, number);
	}
	
	public String getTravelNumber() {
		return TravelNumber;
	}
	public void setTravelNumber(String travelNumber) {
		TravelNumber = travelNumber;
	}
	
}
