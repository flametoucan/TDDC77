package se.jimboagency.bookingsystem.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LogicManager {

	//inlogg
	private static String[] args;
	public LogicManager(String[] args2) {
		//lägg in users typ, kke lite mer grejs
	}
	public static boolean authenticate() {
		if(args.length == 4) {
			if(args[0].equals("-u") && args[2].equals("-p")) {
				User employee = new User(args[1],args[3]);
			} return; // kolla med hjälp av userklassen om inlogg e rätt så att man returnar true om de e sant
			}else if(args[0].equals("-p") && args[2].equals("-u")) {
				User employee = new User(args[3],args[1]);
		} return; // kolla med hjälp av userklassen om inlogg e rätt så att man returnar true om de e sant
		return false;
	} 
	//skapa hashset för allt
	
	private String[] days = {"måndag","tisdag","onsdag","torsdag", "fredag", "lördag", "söndag"};
	public void Sets() {
	HashSet<String> city = new HashSet<String>();
	HashSet<String> day = new HashSet<String>();
	HashSet<String> departure = new HashSet<String>();
	HashSet<String> arrival = new HashSet<String>();
	//lägg till lite dler men måste kolla vilken sort de ska vara
	
	}
	
}













