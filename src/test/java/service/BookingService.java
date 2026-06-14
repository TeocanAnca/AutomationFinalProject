package service;

import dto.BookingDto;
import dto.ResponseBookingDto;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.Hooks;

import static io.restassured.RestAssured.given;

public class BookingService {

    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    public ResponseBookingDto createBooking(BookingDto bookingBody){
        log.info("Creating new booking for {} {}", bookingBody.getFirstName(), bookingBody.getLastName());
        ResponseBookingDto response = given()
                .spec(Hooks.requestSpecification)
                //.header("Cookie", "token=" + Hooks.token)
                .body(bookingBody)
                .log().all()
                .when()
                .post("/booking")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response().as(ResponseBookingDto.class);
        log.info("Booking created with id {}", response.getBookingId());
        return response;
    }


    public BookingDto getBooking(int bookingId, int statusCode){
        log.info("Getting booking with id {}", bookingId);
        Response response = given()
                .spec(Hooks.requestSpecification)
                .log().all()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(statusCode)
                .extract()
                .response();

        if (statusCode == 200) {
            return response.as(BookingDto.class);
        }
        return null;
    }


    public Response deleteBooking(int bookingId){
        log.info("Deleting booking with id {}", bookingId);
        return given()
                .spec(Hooks.requestSpecification)
                .header("Cookie", "token=" + Hooks.token)
                .log().all()
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(201)
                .extract().response();
    }

    public void tryDeleteBooking(int bookingId){
        log.info("Cleanup: attempting to delete booking {}", bookingId);
        given()
                .spec(Hooks.requestSpecification)
                .header("Cookie", "token=" + Hooks.token)
                .when()
                .delete("/booking/" + bookingId);
    }


    public BookingDto updateBooking(int bookingId, BookingDto updatedBody){
        log.info("Updating booking {} with PUT", bookingId);
        return given()
                .spec(Hooks.requestSpecification)
                .header("Cookie", "token=" + Hooks.token)
                .body(updatedBody)
                .log().all()
                .when()
                .put("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(BookingDto.class);

    }

    public BookingDto updateBookingPatch(int bookingId, BookingDto updatedBody){
        log.info("Updating booking {} with PATCH", bookingId);
        return given()
                .spec(Hooks.requestSpecification)
                .header("Cookie", "token=" + Hooks.token)
                .body(updatedBody)
                .log().all()
                .when()
                .patch("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response()
                .as(BookingDto.class);
    }
}
