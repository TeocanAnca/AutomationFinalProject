package tests;

import base.BaseTest;
import dto.StoreOrderDto;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestDataFactory;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

@Slf4j
public class PetOrderChallengeTest extends BaseTest {
    private static long createdOrderId;
    @Test
    public void createPetOrder() {
        long id = System.currentTimeMillis();
        long petId = System.currentTimeMillis();
        String shipDate = LocalDateTime.now().toString();
        StoreOrderDto storeOrderDto = TestDataFactory.createdStoreOrder(id, petId, 2, shipDate, "delivered", true);
        Response response = given()
                .spec(requestSpecification)
                .body(storeOrderDto)
                .log().all()
                .when()
                .post("/store/order")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        StoreOrderDto createPetOrder  = response.as(StoreOrderDto.class);
        log.info("Stored pet " + petId);
        createdOrderId = createPetOrder.getId();
        log.info("Created order:" + createdOrderId);

        long returnedPetId = createPetOrder.getPetId();
        Assert.assertEquals(returnedPetId, petId, "PetId is not correct");

        //int returnedQuantity = createPetOrder.getQuantity();
        Assert.assertEquals(createPetOrder.getQuantity(), 2, "Incorrect quantity ordered");

        //String returnedStatus = createPetOrder.getStatus();
        Assert.assertEquals(createPetOrder.getStatus(), "delivered");
    }

    @Test
    public void getStoreOrderId(){
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("/store/order/" +createdOrderId)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        StoreOrderDto getStoreOrderId = response.as(StoreOrderDto.class);
        log.info("Found order ID" + createdOrderId);
    }

    @AfterTest
    public void deleteStoreOrderId(){
        Response response = given()
                .spec(requestSpecification)
                .when()
                .log().all()
                .delete("/store/order/" +createdOrderId)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        StoreOrderDto deleteStoreOrderId = response.as(StoreOrderDto.class);
        log.info("Deleted the orderId " + createdOrderId);
    }

    @Test
    public void getStoreInventory(){
        Response response = given()
                .spec(requestSpecification)
                .when()
                .log().all()
                .get("store/inventory")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        StoreOrderDto getStoreInventory = response.as(StoreOrderDto.class);
        //log.info("Stored inventory:" + getStoreInventory);
    }
}
