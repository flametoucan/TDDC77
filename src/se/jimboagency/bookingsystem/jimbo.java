package se.jimboagency.bookingsystem;

import se.jimboagency.bookingsystem.logic.LogicManager;
import se.jimboagency.bookingsystem.ui.UIManager;

public class jimbo {

	public static void main(String[] args) {
		LogicManager logicmanager = new LogicManager(args);
		UIManager UImanager = new UIManager(logicmanager);
		UImanager.start(args);
	}

}