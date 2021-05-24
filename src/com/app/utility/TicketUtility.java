package com.app.utility;

import java.util.HashMap;

public class TicketUtility {
	private static HashMap<String, Double> distanceMap = new HashMap<>();
	public static final double BASE_DISTANCE = 100.00d;
	public static final double BASE_PRICE = 750.00d;
	public static final double PER_KM_PRICE = 5.00d;

	static {
		distanceMap.put("PUNE-MUMBAI", 120.00d);
		distanceMap.put("PUNE-NASHIK", 200.00d);
		distanceMap.put("MUMBAI-GOA", 350.00d);
		distanceMap.put("MUMBAI-NASHIK", 180.00d);
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, Double> getDistanceMap() {
		return (HashMap<String, Double>) distanceMap.clone();
	}

	public static boolean validateSourceAndDestination(String source, String destination) {
		boolean isValid = distanceMap.entrySet().stream().anyMatch((map) -> 
		        (map.getKey().contains(source.toUpperCase())
				&& map.getKey().contains(destination.toUpperCase())));

		if (!isValid) {
			System.out.println("Source or Destination not found.....");
			System.out.println("Please Enter The Valid Source and Destination.....");
			return false;
		}
		return isValid;
	}
}
