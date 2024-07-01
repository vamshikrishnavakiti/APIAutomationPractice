package CRUD;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.testingacademy.endpoints.APIContstants;
import com.testingacademy.pojos.BookingResponse;

import Base.baseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testCreateBookingPost extends baseTest {
	
	@Test
	@Owner("Vamshi")
	@Severity(SeverityLevel.NORMAL)
	@Description("TC-1 Verify that Booking can be created")
	
	public void testCreateBooking() {
		requestSpecification.basePath(APIContstants.CREATE_UPDATE_BOOKING_URL);
		response=RestAssured
				.given(requestSpecification)
				.when().body(payloadsManager.createPayloadBookingAsString()).post();
	
		// Validatable Assertion
		validatableResponse.statusCode(200);
		
		// Deserialization - Response
		
		BookingResponse bookingResponse = payloadsManager.bookingResponseJava(response.asString());
		
		//AssertJ
		
		assertThat(bookingResponse.getBookingid()).isNull();
		assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
		assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Vamshi");
		
		//TestNG Assertions
		
		
		
	}

}
