package se.jimboagency.bookingsystem;

import se.jimboagency.bookingsystem.logic.LogicManager;
import se.jimboagency.bookingsystem.ui.UIManager;

public class Jimbo {

	public static void main(String[] args) {
		/*Klassen Jimbo innehåller inte mycket kod utan main metoden som använder sig av UIManager. Jimbo är ansvarig för
		att instansiera både UIManager och LogicManager. Referensen till LogikManager ska
		skickas till UIManager och sedan lagras i UIManager. 
		
		klassen Jimbo FÅR INTE anropa metoder som ligger i logic paketet direkt. Om behovet
		finns ska det finnas en metod i klassen UIManager som bara vidarebefordrar anropet från
		Jimbo till metoden som ligger i logic paketet. Till exempel autentisering.
		*/
		
		LogicManager logicmanager = new LogicManager(args);
		UIManager UImanager = new UIManager(logicmanager);
		UImanager.showMainMenu();
		
		
	
		
	}

}
