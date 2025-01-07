package se.jimboagency.bookingsystem.ui;

import se.jimboagency.bookingsystem.*;

public class UIManager {


	/*UIManager är en klass som ligger i ui paketet och är ansvarig för att kommunicera med
användaren, läsa in data och skriva ut resultat/felmeddelanden.
● UIManager innehåller bara kod som gäller gränssnitt.
● UIManager innehåller inte statiska metoder fast det kan finnas undantag.
● UIManager instansieras i klassen Jimbo.
● Jimbo har has-a relation med UIManager( composition ).*/

	private LogicManager logicmanager;
	private Boolean val;
	
	public UIManager (LogicManager logicManager) {
		this.logicmanager = logicManager;
	}
	
	public void start(String[] args) {
		
		if(LogicManager.authenticate()) {
			System.out.println("Gött mos programmet får inte överdos :) ");
			showMainMenu();
		}else {
			System.out.println("Gött mos men tyvärr överdos :( ");
			//avsluta programmet på något sätt
		}
		
	}

	private void showMainMenu() {
		// TODO Auto-generated method stub
		
	}
}
