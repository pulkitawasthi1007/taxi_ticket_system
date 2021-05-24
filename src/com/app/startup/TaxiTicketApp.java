package com.app.startup;

import java.util.Scanner;
import com.app.model.Ticket;
import com.app.utility.TicketUtility;

public class TaxiTicketApp {


	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in);) {
			
			System.out.println("Enter Source: ");
			String source = scanner.nextLine();
			System.out.println("Enter Destination: ");
			String destination = scanner.nextLine();
	
			boolean isValid = TicketUtility.validateSourceAndDestination(source, destination);
			if (isValid) {
				System.out.println("Enter no. of travellers: ");
				
				String numberOfTraveller = scanner.nextLine();			
				int noOfTravellers = TicketUtility.getNumberOfTraveller(numberOfTraveller); 
				if( noOfTravellers > 0) {
					Ticket ticket = new Ticket(source, destination, noOfTravellers);
					ticket.printTicket();
				} else {
					System.out.println("Please Enter The Valid Number of Travellers. It Should be Numeric Value....");
				}
				
			} else {
				System.out.println("Re-try again......");
			}
	    } catch(Exception e) {
	    	System.out.println("Exception - " + e.getStackTrace());
	    }
		  
	}
}
