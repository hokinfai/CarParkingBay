package com.ihsmarkit.parkingspace;

public class ParkingSpace implements ParkingSpaceInterface {
	private double hourlyRate;

	private String size;

	private int spaceNumber;

	public ParkingSpace(double hourlyRate, String size, int spaceNumber) {
		super();
		this.hourlyRate = hourlyRate;
		this.size = size;
		this.spaceNumber = spaceNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSpace other = (ParkingSpace) obj;
		if (Double.doubleToLongBits(hourlyRate) != Double.doubleToLongBits(other.hourlyRate))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (spaceNumber != other.spaceNumber)
			return false;
		return true;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

	public String getSize() {
		return size;
	}

	public int getSpaceNumber() {
		return spaceNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(hourlyRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + spaceNumber;
		return result;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}

	@Override
	public String toString() {
		return "ParkingSpace [hourlyRate=" + hourlyRate + ", size=" + size + ", spaceNumber=" + spaceNumber + "]";
	}

}
