package parallel;

class BookingSystem {
	static private int ticketsLeft = 3;
	
	static boolean reserveTickets (int tickets) {
		if (ticketsLeft >= tickets && tickets > 0) {
			
			System.out.println("BOOKING: Ticket Purchase Successful!\nTickets Left: "+ticketsLeft);
			ticketsLeft -= tickets;
			return true;
		}
		System.out.println("BOOKING: Ticket Purchase Failed!");
		System.out.println("Tickets Left: "+ticketsLeft);
		return false;
	}
}

class Customer extends Thread{
	int id;
	int ticketsToPurchase = 2;
	int ticketsOwned = 0;
	
	Customer(int id){
		this.id = id;
	}
	
	public void run() {
		while (BookingSystem.reserveTickets(ticketsToPurchase)) {
			System.out.println("Customer %d: Purchasing Ticket!".formatted(id));
			ticketsOwned+=ticketsToPurchase;
		}
		System.out.println("Customer %d: Hoard Success! Owned Tickets %d".formatted(id, ticketsOwned));
		
	}
}

public class LaunchBooking {
	public static void main(String[] args) {
		
		Customer c1 = new Customer(1);
		Customer c2 = new Customer(2);
		
		c1.start();
		c2.start();
		
	}
}
