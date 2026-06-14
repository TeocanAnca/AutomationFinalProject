package steps;

import dto.BookingDto;
import dto.ResponseBookingDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import service.BookingService;
import utils.TestDataFactory;

public class BookingSteps {

    private static final Logger log = LoggerFactory.getLogger(BookingSteps.class);

    private final BookingService bookingService = new BookingService();
    private BookingDto bookingBodyDto;
    private BookingDto fetchedBookingDto;
    public static int lastBookingId;
    private int getBookingId;


    @Given("I create the booking")
    public void iCreateTheBooking() {
        bookingBodyDto = TestDataFactory.createNewBooking();

        ResponseBookingDto responseBookingDto = bookingService.createBooking(bookingBodyDto);
         getBookingId = responseBookingDto.getBookingId();
         lastBookingId = getBookingId;
        log.info("Booking created and stored with id {}", getBookingId);
    }

    @When("I retrieve the booking details")
    public void iRetrieveTheBookingDetails() {
        log.info("Retrieving booking details for id {}", getBookingId);
        fetchedBookingDto = bookingService.getBooking(getBookingId, 200);
    }

    @Then("the booking details are correct")
    public void theBookingDetailsAreCorrect() {
        log.info("Validating booking details match expected data");
        Assert.assertEquals(fetchedBookingDto.getFirstName(), bookingBodyDto.getFirstName(), "The first name does not match");
        Assert.assertEquals(fetchedBookingDto.getLastName(), bookingBodyDto.getLastName(), "The last name does not match");
    }

    @When("I delete the booking")
    public void iDeleteTheBooking() {
        log.info("Deleting booking with id {}", getBookingId);
        bookingService.deleteBooking(getBookingId);
    }

    @Then("the booking is successfully deleted")
    public void theBookingIsSuccessfullyDeleted() {
        log.info("Verifying booking {} was deleted (expecting 404)", getBookingId);
        BookingDto deletedBooking = bookingService.getBooking(getBookingId, 404);
        Assert.assertNull(deletedBooking, "The booking should be deleted");
    }


    //Scenario2 - PUT
    @When("I updated the booking")
    public void iUpdatedTheBooking() {
        log.info("Updating booking {} with PUT", getBookingId);
        BookingDto updatedBooking = BookingDto.builder()
                .firstName("Ana")
                .lastName("Teo")
                .totalPrice(200)
                .depositPaid(false)
                .bookingDates(
                        BookingDto.DatesDto.builder()
                                .checkIn("2030-06-06")
                                .checkOut("2030-06-08")
                                .build()
                )
                .additionalNeeds("Flowers")
                .build();

    fetchedBookingDto = bookingService.updateBooking(getBookingId, updatedBooking);
    }

    @Then("the data is updated")
    public void theDataIsUpdated() {
        log.info("Validating PUT update results");
        Assert.assertEquals(fetchedBookingDto.getFirstName(), "Ana", "The first name does not match");
        Assert.assertEquals(fetchedBookingDto.getLastName(), "Teo", "The last name does not match");
        Assert.assertEquals(fetchedBookingDto.getTotalPrice(), Integer.valueOf(200), "The total price does not match");
        Assert.assertFalse(fetchedBookingDto.getDepositPaid(), "The deposit paid value does not match");
        Assert.assertEquals(fetchedBookingDto.getAdditionalNeeds(), "Flowers", "The additional needs do not match");
    }

    //Scenario3 - PATCH
    @When("I updated only the first name and total price")
    public void iUpdatedOnlyTheFirstNameAndTotalPrice() {
        log.info("Patching booking {} - updating firstName and totalPrice only", getBookingId);
        BookingDto updatedBookingPatch = BookingDto.builder()
                .firstName("Ema")
                .totalPrice(344)
                .build();

        fetchedBookingDto = bookingService.updateBookingPatch(getBookingId, updatedBookingPatch);
    }

    @Then("the first name and total price are updated")
    public void theFirstNameAndTotalPriceAreUpdated() {
        log.info("Validating PATCH update results");
        Assert.assertEquals(fetchedBookingDto.getFirstName(), "Ema", "The first name is incorrect after patch");
        Assert.assertEquals(fetchedBookingDto.getTotalPrice(), Integer.valueOf(344), "The total price is incorrect after patch");
    }
}
