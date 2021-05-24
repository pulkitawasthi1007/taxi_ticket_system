package com.app.startup;

import java.util.Scanner;
import com.app.model.Ticket;
import com.app.utility.TicketUtility;

public class TaxiTicketApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Source: ");
			String source = scanner.nextLine();
			System.out.println("Enter Destination: ");
			String destination = scanner.nextLine();
	
			boolean isValid = TicketUtility.validateSourceAndDestination(source, destination);
			if (isValid) {
				System.out.println("Enter no. of travellers: ");
				int noOfTravellers = scanner.nextInt();
				Ticket ticket = new Ticket(source, destination, noOfTravellers);
				ticket.printTicket();
			} else {
				System.out.println("Re-try again......");
			}
	    } catch(Exception e) {
	    	System.out.println("Exception -" + e.getMessage());
	    }
		  
	}
}
