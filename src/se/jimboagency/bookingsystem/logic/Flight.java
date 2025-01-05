package se.jimboagency.bookingsystem.logic;

public class Flight {
	
	private String FlightNumb;
	private String DepartureCity;
	private String DepartureDay;
	private String DepartureTime;
	private String ArrivalCity;
	private String ArrivalDay;
	private String ArrivalTime;
	private String TravelTime;
	private int Week;
	private int Year;
	private int NumberOfSeats;
	
	public Flight (String FlightNumb, String DepartureCity, String DepartureDay, String DepartureTime, String ArrivalCity, String ArrivalDay, String ArrivalTime, String TravelTime, int Week, int Year, int NumberOfSeats) {
		this.FlightNumb = FlightNumb;
		this.DepartureCity = DepartureCity;
		this.DepartureDay = DepartureDay;
		this.DepartureTime = DepartureTime;
		this.ArrivalCity = ArrivalCity;
		this.ArrivalDay = ArrivalDay;
		this.ArrivalTime = ArrivalTime;
		this.Week = Week;
		this.Year = Year;
		this.NumberOfSeats = NumberOfSeats;
	}

	public void Seats() {
		
	}
	
	public void FlightNumber() {
		
	}
	
	public String getFlightNumb() {
		return FlightNumb;
	}

	public void setFlightNumb(String flightNumb) {
		FlightNumb = flightNumb;
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

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public String getArrivalCity() {
		return ArrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		ArrivalCity = arrivalCity;
	}

	public String getTravelTime() {
		return TravelTime;
	}

	public void setTravelTime(String travelTime) {
		TravelTime = travelTime;
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
	
}
