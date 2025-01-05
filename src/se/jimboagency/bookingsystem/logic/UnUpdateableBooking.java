package se.jimboagency.bookingsystem.logic;

public class UnUpdateableBooking extends Booking{

	public void UpdateCheck(boolean IsUpdateable) {
		if (IsUpdateable == false) {
			System.out.println("This booking cant be updated due to being a unupdateable booking!");
		}
	}
}
