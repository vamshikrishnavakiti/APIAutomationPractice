package Integration;

import Base.baseTest;
import com.testingacademy.endpoints.APIContstants;
import com.testingacademy.pojos.Booking;
import com.testingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TCIntegration extends baseTest {

    @Test(groups = "integration", priority = 1)
    @Owner("Vamshi")
    @Description("TC 1 for Verifying that Booking can be created")

    public void testCreateBooking(ITestContext iTestContext) {

        requestSpecification.basePath(APIContstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadsManager.createPayloadBookingAsString()).post();

        // Validate Assertion
        validatableResponse.statusCode(200);

        // Deserialization - Response

        BookingResponse bookingResponse = payloadsManager.bookingResponseJava(response.asString());

        //AssertJ

        assertThat(bookingResponse.getBookingid()).isNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Vamshi");
// set the booking ID
        iTestContext.setAttribute("bookingid", bookingResponse.getBooking());
    }

    @Test(groups = "integration", priority = 2)
    @Owner("Vamshi")
    @Description("TC 2 for Verifying that Booking can be verified by ID")

    public void testVerifyBooking(ITestContext iTestContext) {
        Integer bookinId = (Integer) iTestContext.getAttribute("bookingid");
        String basePathGET = APIContstants.CREATE_UPDATE_BOOKING_URL + "/" + bookinId;
        System.out.println(basePathGET);
        //Get Booking by ID
        requestSpecification.basePath(APIContstants.CREATE_UPDATE_BOOKING_URL).put();
        requestSpecification.basePath(basePathGET);
        response = RestAssured
                .given(requestSpecification)
                .when().get();
        requestSpecification.basePath(APIContstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadsManager.createPayloadBookingAsString()).post();

        // Validatable Assertion
        validatableResponse.statusCode(200);

        // Deserialization - Response

        BookingResponse bookingResponse = payloadsManager.bookingResponseJava(response.asString());


        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadsManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotNull();
        assertThat(booking.getFirstname()).isNotNull().isEqualTo("Vamshi");


        @Test(groups = "integration", priority = 3)
        @Owner("Vamshi")
        @Description("TC 3 for Verifying that Booking can be updated")

        public void testUpdateBooking (ITestContext iTestContext){
            System.out.println("Token - " + iTestContext.getAttribute("token"));
            String token = (String) iTestContext.getAttribute("token");
            // PUT / PATCH
            Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
            String basePathPUTPATCH = APIContstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
            System.out.println(basePathPUTPATCH);


            requestSpecification.basePath(basePathPUTPATCH);
            response = RestAssured
                    .given(requestSpecification).cookie("token", token)
                    .when().body(payloadsManager.createPayloadBookingAsString()).put();
            validatableResponse = response.then().log().all();
            // Validate Assertion
            validatableResponse.statusCode(200);


            @Test(groups = "integration", priority = 4)
            @Owner("Vamshi")
            @Description("TC 4 for Verifying that Booking can be deleted")

            public void testDeleteBooking (ITestContext iTestContext){
                String token1 = (String) iTestContext.getAttribute("token");
                Assert.assertTrue(true);

                Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
                String basePathDELETE = APIContstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
                System.out.println(basePathDELETE);

                requestSpecification.basePath(basePathDELETE).cookie("token", token);
                validatableResponse = RestAssured.given().spec(requestSpecification)
                        .when().delete().then().log().all();
                validatableResponse.statusCode(201);


            }
        }
    }
}
