package se.jimboagency.bookingsystem.logic;

public class UpdateableBooking extends Booking{

	public void UpdateCheck(boolean IsUpdateable) {
		if (IsUpdateable == true) {
			LogicManager.UpdateBooking();
			/*Hitta något sätt att koppla till updatebooking i logicmanager*/
		}
	}
	 /* Kanske även skapa ett fält där alla ombokningsbara bokningar
	  * fixa samma för de som inte går att boka om
	  */
}
