package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Entities.Reservation;

public class Application {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room Number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy)");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation : check-out date must be after check-in");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			System.out.println("---------------------------------");
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/MM/yyyy)");
			Date checkinUpdate = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy)");
			Date checkoutUpdate = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkinUpdate, checkoutUpdate);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				reservation.updateDates(checkinUpdate, checkoutUpdate);
				System.out.println("Reservation: " + reservation);
			}
		}

	}
}
