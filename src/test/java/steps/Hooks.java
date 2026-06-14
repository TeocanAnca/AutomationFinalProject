package steps;

import base.RequestSpecificationBuilder;
import config.BaseConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.BookingService;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Hooks {
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private final BookingService bookingService = new BookingService();

    public static RequestSpecification requestSpecification;

    public static String token;


    @Before
    public void setUp(Scenario scenario){
        log.info("Starting scenario");
        RestAssured.baseURI = BaseConfig.BASE_URL;
        requestSpecification = new RequestSpecificationBuilder()
                .addHeaders(BaseConfig.getDefaultHeaders())
                .setRelaxedHTTPSValidation()
                .build();

        token = generateToken();
    }

    @After
    public void tearDown(Scenario scenario){
        if (BookingSteps.lastBookingId > 0) {
            try {
                bookingService.tryDeleteBooking(BookingSteps.lastBookingId);
            } catch (Exception e) {
                log.info("Cleanup: booking {} already deleted or not found", BookingSteps.lastBookingId);
            } finally {
                BookingSteps.lastBookingId = 0;
            }
        }
        log.info("Finished scenario");
    }

    public String generateToken(){
        Map<String, String> authBody = new HashMap<>();
        authBody.put("username", "admin");
        authBody.put("password", "password123");

        return given()
                .spec(requestSpecification)
                .body(authBody)
                .log().all()
                .when()
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath().getString("token");
    }

}
