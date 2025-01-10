package se.jimboagency.bookingsystem.logic;

public class User {
	
	private String ett;
	private String två;
	
	public String inlogg() {
		return (this.ett + " " + this.två);
	}
	
	public User(String ett, String två) {
		this.ett = ett;
		this.två = två;
	}
	//gör metod som kollar om värdena stämmer
}
