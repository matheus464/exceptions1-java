package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd//MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd//MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

<<<<<<< HEAD
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);

		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd//MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd//MM/yyyy): ");
		checkOut = sdf.parse(sc.next());
=======
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd//MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd//MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			 if (error != null) {
				 System.out.println("Error in reservation: " + error);
			 } 
			 else {
				 System.out.println("Reservation: " + reservation);						 
			 } 
		}
>>>>>>> 47f5b998dbe57824d8ef4025f76b4814f7ad35a0

		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();

	}

}
