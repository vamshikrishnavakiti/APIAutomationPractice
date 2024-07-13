package com.testingacademy.modules;

import com.google.gson.Gson;
import com.testingacademy.pojos.*;

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
  public String setAuthPayload(){
		Auth auth = new Auth();
		auth.setUsername("admin");
		auth.setPassword("password123");
  String jsonPayloadString= gson.toJson(auth);
		gson= new Gson();
	  System.out.println("Payload set to"+jsonPayloadString);
	  return jsonPayloadString;
  }

  public String getTokenFromJson(String tokenResponse){
	gson = new Gson();
	// Response (Json)--> Object Token Response
	  // De serialization;
	  TokenResponse tokenResponse1=gson.fromJson(tokenResponse,TokenResponse.class);
	  return tokenResponse1.getToken();


  }
  public Booking getResponseFromJSON(String getResponse){
		gson = new Gson();
		Booking booking = gson.fromJson(getResponse,Booking.class);
		return booking;
  }

}
