package com.ihsmarkit.view;

import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.ihsmarkit.booking.SpaceRentedInterface;
import com.ihsmarkit.parkcingstructure.ParkingStructure;
import com.ihsmarkit.parkcingstructure.ParkingSystem;

public class Main {

	public static void main(String[] args) throws ParseException {
		ParkingSystem pst = new ParkingStructure();
		pst.driveIn("M444444", "small");

		// Second Car
		pst.driveIn("M333333", "small");

		pst.driveOut(101);
		pst.driveIn("M222222", "small");

		pst.driveIn("M111111", "small");
		pst.driveIn("M999999", "small");

		Map<Integer, SpaceRentedInterface> occupiedVehicle = pst.getOccupiedVehicle();

		Set keys = occupiedVehicle.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			int key = (Integer) i.next();
			SpaceRentedInterface value = occupiedVehicle.get(key);
			System.out.println(key + " with values " + value.toString());
		}

	}

}
