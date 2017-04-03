package com.ihsmarkit.payment;

import java.util.Scanner;

public class Payment implements PaymentEstablishment {
	private double amount;

	public Payment(double amount) {
		this.amount = amount;
	}

	public boolean paymentProcess() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please pay " + amount + " for your parking.");
		double customerPaid = (scan.nextDouble());
		if (customerPaid > amount) {
			System.out.println(
					"Thank you! Payment amount: " + customerPaid + " has been accepted.  Have a safe journey!");
			return true;
		} else {
			System.out.println("Sorry, insuffient funding. Please pay again");
			return false;
		}
	}

}
