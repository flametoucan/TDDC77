package se.jimboagency.bookingsystem.ui;

import se.jimboagency.bookingsystem.logic.LogicManager;

public class UIManager extends LogicManager {


	/*UIManager är en klass som ligger i ui paketet och är ansvarig för att kommunicera med
användaren, läsa in data och skriva ut resultat/felmeddelanden.
● UIManager innehåller bara kod som gäller gränssnitt.
● UIManager innehåller inte statiska metoder fast det kan finnas undantag.
● UIManager instansieras i klassen Jimbo.
● Jimbo har has-a relation med UIManager( composition ).*/

	

	public showMainMenu() {
		
		
	}
	private Boolean val;
	
	public void showMainMenu() {
		
		if(LogicManager.authenticate()) {
			switch(val) {
			
			}
		}
		
		
	}
}
