package se.jimboagency.bookingsystem.logic;

import java.util.Random;

public abstract class Booking extends Flight{

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
