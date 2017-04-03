package com.ihsmarkit.parkcingstructure;

import java.util.List;
import java.util.Map;

import com.ihsmarkit.booking.SpaceRentedInterface;

public interface ParkingSystem {

	boolean checkAvailability();

	void driveIn(String licenseNumber, String size);

	void driveOut(int spaceNumber);

	List<Integer> getAvailableSpace();

	int getFreeSpaceNumber();

	int getOccupiedSpaceNumber();

	int getTotalSpace();

	Map<Integer, SpaceRentedInterface> getOccupiedVehicle();

	void welcomeWord();

}