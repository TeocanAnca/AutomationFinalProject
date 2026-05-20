package tests;

import base.BaseTest;
import dto.StoreOrderDto;
import io.restassured.response.Response;
import org.testng.annotations.*;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;

public class PetOrderSession12Test extends BaseTest {
    long createdOrderId;

    //POST new order
    //GET / store/order/{orderId}
    //DELETE order

    @BeforeMethod
    public void createPetOrder(){
        long id = System.currentTimeMillis();
        long petId = System.currentTimeMillis();
        String shipDate = LocalDateTime.now().toString();
        StoreOrderDto storeOrderDtoBuilder = StoreOrderDto.builder()
                .id(id)
                .petId(petId)
                .quantity(2)
                .shipDate(shipDate)
                .status("delivered")
                .complete(true)
                .build();

        log.info("Placing store order with id {} for pet {}", id, petId);

        StoreOrderDto createdPetOrder = (StoreOrderDto) given()
                .spec(requestSpecification)
                .body(storeOrderDtoBuilder)
                .log().all()
                .when()
                .post("/store/order")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response()
                .as(StoreOrderDto.class);

         createdOrderId = createdPetOrder.getId();
    }


    @Test
    public void getPetOrderTest(){

        StoreOrderDto fetchedPetOrder = given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get("store/order/{orderId}", createdOrderId)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response()
                .as(StoreOrderDto.class);

        log.info("Fetched store order: {}", fetchedPetOrder);

    }

    @AfterMethod
    public void petOrderCleanup()
    {
        given()
                .spec(requestSpecification)
                .when()
                .delete("/store/order/{id}", createdOrderId)
                .then()
                .statusCode(200);

        log.info("Deleted store order {} in @AfterMethod", createdOrderId);


        given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get("store/order/{orderId}", createdOrderId)
                .then()
                .log().all()
                .statusCode(404);
    }
}
