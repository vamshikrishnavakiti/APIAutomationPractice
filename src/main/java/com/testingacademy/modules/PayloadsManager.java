package com.testingacademy.modules;

import com.google.gson.Gson;
import com.testingacademy.pojos.Booking;
import com.testingacademy.pojos.BookingDates;
import com.testingacademy.pojos.BookingResponse;

public class PayloadsManager {
	Gson gson = new Gson();
	
	public String createPayloadBookingAsString() {

		Booking booking = new Booking();
		booking.setFirstname("Vamshi");
		booking.setLastname("Krishna");
		booking.setTotalprice(150);
		booking.setDepositpaid(true);

		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin("2024-01-01");
		bookingDates.setCheckout("2024-01-10");

		booking.setBookingdates(bookingDates);
		booking.setAdditionalneeds("Break Fast");

		return gson.toJson(booking);

	}
	
	public String updateFullPayloadBookingAsString() {

		Booking booking = new Booking();
		
		booking.setFirstname("Vamshi Vakiti");
		booking.setLastname("Krishna");
		booking.setTotalprice(150);
		booking.setDepositpaid(true);

		BookingDates bookingDates = new BookingDates();
		bookingDates.setCheckin("2024-01-01");
		bookingDates.setCheckout("2024-01-10");

		booking.setBookingdates(bookingDates);
		booking.setAdditionalneeds("Break Fast");
		gson = new Gson();
		return gson.toJson(booking);
		
		

	}
	
	public BookingResponse bookingResponseJava (String responseString) {
		gson = new Gson();
		BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
				return bookingResponse;
	}



}
