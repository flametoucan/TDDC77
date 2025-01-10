package se.jimboagency.bookingsystem.ui;

import se.jimboagency.bookingsystem.*;
import se.jimboagency.bookingsystem.logic.LogicManager;

public class UIManager {


	/*UIManager är en klass som ligger i ui paketet och är ansvarig för att kommunicera med
användaren, läsa in data och skriva ut resultat/felmeddelanden.
● UIManager innehåller bara kod som gäller gränssnitt.
● UIManager innehåller inte statiska metoder fast det kan finnas undantag.
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
		}
		
	}

	private void showMainMenu() {
		
		/*Pseudocode
		+                * bool continue = true;
		+                * while(continue) {
		+                *      Show menu
		+                *      take user input
		+                *      switch(user_choice) {
		+                * ...
		+                * ...
		+                * case "exit" {
		+                *  break;
		+                * }
		+                * };
		+                * }
		+                * */
	}
}
