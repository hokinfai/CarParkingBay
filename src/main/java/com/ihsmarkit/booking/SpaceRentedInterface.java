package com.ihsmarkit.booking;

import java.util.Date;

public interface SpaceRentedInterface {

	Date getInTime();

	Date getOutTime();

	String getLicenseNumber();

	void setLicenseNumber(String licenseNumber);

	long getDuration();

	void setOutTime(Date outTime);

	void setInTime(Date inTime);

}