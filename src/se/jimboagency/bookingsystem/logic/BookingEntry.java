package se.jimboagency.bookingsystem.logic;

public class BookingEntry {
    private String customerName;
    private Flight flight;
    private boolean updatable;

    public BookingEntry(String customerName, Flight flight, boolean updatable) {
        this.customerName = customerName;
        this.flight = flight;
        this.updatable = updatable;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }
}
