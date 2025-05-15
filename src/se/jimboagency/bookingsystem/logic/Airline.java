package se.jimboagency.bookingsystem.logic;

import java.util.Scanner;

public class Airline {

	private static Airline instance;
	private String AirlineCompany;
	private transient Scanner input = new Scanner(System.in);

	//KANSKE SKITFEL INGEN KONSTRUKTUR MEN DÅ BLEV ALLT BAJS
	
	public static Airline getInstance() {
        if (instance == null) {
            instance = new Airline();
        }
        return instance;
    }
	
	public void ChooseAirline() {
		
		System.out.println("Airlines:");
		System.out.println("1. SAS");
		System.out.println("2. Lufthansa");
		System.out.println("3. Emirates");
		System.out.println("4. Ryanair");
		System.out.println("5. KLM");
		
		int choice = input.nextInt();
		
		switch (choice) {
			case 1:
				setAirlineCompany("SAS");
				
			break;
			case 2:
				setAirlineCompany("Lufthansa");
				
			break;
			case 3:
				setAirlineCompany("Emirates");
				
			break;
			case 4:
				setAirlineCompany("Ryanair");
				
			break;
			case 5:
				setAirlineCompany("KLM");
				
			break;
		}
		
		//KANSKE INTE VÄLJA BOLAG 2 GÅNGER!?!?!?
	}

	public String getAirlineCompany() {
		return AirlineCompany;
	}

	public void setAirlineCompany(String airlineCompany) {
		AirlineCompany = airlineCompany;
	}
}
