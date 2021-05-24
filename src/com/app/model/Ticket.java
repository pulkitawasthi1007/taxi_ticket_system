package com.app.model;

import com.app.utility.TicketUtility;

/**
 * 
 * @author Pulkit Awasthi
 * 
 *         Story#2 : 1- We can use the String formatter for providing better
 *         formatting of the String, Integer and Double values. The impact of
 *         this changes will occurs at only 1 place printTicket() Method. 
 *         2- We can use Apache Commons liberary's file reload functionality 
 *         and then we can use the property file instead of hard-coded static 
 *         map for adding/removing/updating the source, destination and the 
 *         distance value in absence of database in the application. 
 *         3. We can improve and add some more functionality as well as flexibility of the
 *         application. e.g. we can provide the type of taxi and then calculate the fare
 *         according to type of taxi. like sedan, mini etc.
 *
 */
public class Ticket {

	private String source;
	private String destination;
	private double distance;
	private int noOfTravellers;
	private double price;

	public Ticket(String source, String destination, int noOfTravellers) {
		this.source = source.toUpperCase();
		this.destination = destination.toUpperCase();
		this.noOfTravellers = noOfTravellers;
		calculateDistance();
		calculatePrice();
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public double getDistance() {
		return distance;
	}

	public int getNoOfTravellers() {
		return noOfTravellers;
	}

	public double getPrice() {
		return price;
	}

	private void calculateDistance() {
		this.distance = TicketUtility.getDistanceMap().containsKey(this.source + "-" + this.destination)
				? TicketUtility.getDistanceMap().get(this.source + "-" + this.destination)
				: TicketUtility.getDistanceMap().get(this.destination + "-" + this.source);
	}

	private void calculatePrice() {
		this.price = this.noOfTravellers * ((this.distance - TicketUtility.BASE_DISTANCE) * TicketUtility.PER_KM_PRICE
				+ TicketUtility.BASE_PRICE);
	}

	public void printTicket() {
		System.out.println("\n\n");
		System.out.println("Taxi Ticket");
		System.out.println("-----------");
		System.out.println("Source: " + this.getSource());
		System.out.println("Destination: " + this.getDestination());
		System.out.println("Kms: " + this.getDistance());
		System.out.println("No. of travellers = " + this.getNoOfTravellers());
		System.out.println("Total = " + this.getPrice() + " INR");
	}
}
