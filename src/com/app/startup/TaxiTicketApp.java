package com.app.startup;

import java.util.Scanner;
import com.app.model.Ticket;
import com.app.utility.TicketUtility;

public class TaxiTicketApp {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("Enter Source: ");
			String source = scanner.nextLine();
			System.out.println("Enter Destination: ");
			String destination = scanner.nextLine();
			System.out.println("Enter no. of travellers: ");
			String numberOfTraveller = scanner.nextLine();

			createTicketSystem(source, destination, numberOfTraveller);

		} catch (Exception e) {
			System.out.println("Exception - " + e.getStackTrace());
		}
	}

	/**
	 * createTicketSystem takes 3 arguments
	 * 
	 * @param source            as String
	 * @param destination       as String
	 * @param numberOfTraveller as String. As this application can be run using
	 *                          console. So to handle parse exception it accept
	 *                          value as String and internally it converts into
	 *                          integer.
	 * 
	 */
	public static void createTicketSystem(String source, String destination, String numberOfTraveller) {

		boolean isValid = TicketUtility.validateSourceAndDestination(source, destination);
		if (isValid) {
			int noOfTravellers = TicketUtility.getNumberOfTraveller(numberOfTraveller);
			if (noOfTravellers > 0) {
				Ticket ticket = new Ticket(source, destination, noOfTravellers);
				ticket.printTicket();
			} else {
				System.out.println(
						"Please Enter The Valid Number of Travellers. It Should be Positive Numeric Value....");
			}

		} else {
			System.out.println("Re-try again......");
		}
	}
}
