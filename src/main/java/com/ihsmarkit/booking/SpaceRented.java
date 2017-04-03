package com.ihsmarkit.booking;

import java.util.Date;

public class SpaceRented implements SpaceRentedInterface {
	private Date inTime;
	private Date outTime;
	private String licenseNumber;
	private String vehiclaSize;

	public SpaceRented(String licenseNumber, String vehiclaSize) {
		super();
		this.licenseNumber = licenseNumber;
		this.vehiclaSize = vehiclaSize;
	}

	public long getDuration() {
		long diff = Math.abs(outTime.getTime() - inTime.getTime());
		long diffDays = diff / (24 * 60 * 60 * 1000);
		return diffDays;
	}

	public Date getInTime() {
		return inTime;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public Date getOutTime() {
		return outTime;
	}

	public String getVehiclaSize() {
		return vehiclaSize;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public void setVehiclaSize(String vehiclaSize) {
		this.vehiclaSize = vehiclaSize;
	}

	@Override
	public String toString() {
		return "SpaceRented [inTime=" + inTime + ", outTime=" + outTime + ", licenseNumber=" + licenseNumber
				+ ", vehiclaSize=" + vehiclaSize + "]";
	}
}
