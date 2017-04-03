package com.ihsmarkit.parkcingstructure;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ihsmarkit.booking.SpaceRented;
import com.ihsmarkit.booking.SpaceRentedInterface;
import com.ihsmarkit.parkingspace.ParkingSpace;
import com.ihsmarkit.parkingspace.ParkingSpaceInterface;
import com.ihsmarkit.payment.Payment;

public class ParkingStructure implements ParkingSystem {
	private final static int totalSpace = 5;
	private static Map<Integer, ParkingSpaceInterface> spaceList = new HashMap<Integer, ParkingSpaceInterface>();
	private static List<Integer> freeSpace = new LinkedList<Integer>();;
	private static Map<Integer, SpaceRentedInterface> occupiedSpace = new HashMap<Integer, SpaceRentedInterface>();
	private int[] spaceId = { 101, 102, 103, 201, 202 };

	public ParkingStructure() {
		spaceList.put(spaceId[0], new ParkingSpace(2.12, "small", spaceId[0]));
		spaceList.put(spaceId[1], new ParkingSpace(1.0, "medium", spaceId[1]));
		spaceList.put(spaceId[2], new ParkingSpace(2.0, "large", spaceId[2]));
		freeSpace.add(spaceId[0]);
		freeSpace.add(spaceId[1]);
		freeSpace.add(spaceId[2]);

	}

	public boolean checkAvailability() {
		welcomeWord();
		if (freeSpace.size() > 0)
			return true;
		else {
			System.out.println("Sorry, we are currently full!");
			return false;
		}
	}

	public void driveIn(String licenseNumber, String size) {
		if (checkAvailability()) {
			SpaceRentedInterface newRent = new SpaceRented(licenseNumber, size);
			newRent.setInTime(new Date());
			Integer allocatedSpace = freeSpace.get(0);
			occupiedSpace.put(allocatedSpace, newRent);
			freeSpace.remove(0);
			System.out.println("Park successfully\n");
		}
	}

	public void driveOut(int spaceNumber) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR, 19);
		date.set(Calendar.MINUTE, 15);
		date.set(Calendar.MONTH, 3);
		date.set(Calendar.DAY_OF_MONTH, 5);
		date.set(Calendar.YEAR, 2017);
		Date d = date.getTime();

		// Date Testing
		SpaceRentedInterface existingRent = occupiedSpace.get(spaceNumber);
		existingRent.setOutTime(d);
		long duration = existingRent.getDuration();
		double amount = spaceList.get(spaceNumber).getHourlyRate() * Math.round(duration);
		while (true) {
			if (new Payment(amount).paymentProcess()) {
				break;
			}
		}
		freeSpace.add(spaceNumber);
		occupiedSpace.remove(spaceNumber);
	}

	public List<Integer> getAvailableSpace() {
		return freeSpace;
	}

	public int getFreeSpaceNumber() {
		return freeSpace.size();
	}

	public int getOccupiedSpaceNumber() {
		return occupiedSpace.size();
	}

	public int getTotalSpace() {
		return totalSpace;
	}

	public Map<Integer, SpaceRentedInterface> getOccupiedVehicle() {
		return occupiedSpace;
	}

	public void welcomeWord() {
		System.out.println("Thank you for choosing our car park.");
		System.out.println("Can I please confirm you that we have " + freeSpace + " free Spaces at the moment!");
	}
}
