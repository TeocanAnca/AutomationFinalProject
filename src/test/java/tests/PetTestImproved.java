package tests;

import base.BaseTest;
import dto.PetDto;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestDataFactory;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Slf4j
public class PetTestImproved extends BaseTest {
    private static long createdPetId;
    @BeforeClass
    public void createPet(){
        long id = System.currentTimeMillis();
        PetDto petDto = TestDataFactory.createPet(id, "Azorel", new PetDto.CategoryDto(1, "Caine mare"), new PetDto.TagDto(1, "Cuminte"), "Available");
        Response response = given()
                .spec(requestSpecification)
                .body(petDto)
                .log().all()
                .when()
                .post("/pet")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        PetDto createdPet = response.as(PetDto.class);
        log.info("Created pet:" + createdPet);
        createdPetId = createdPet.getId();
        log.info("Created pet with ID: " + createdPetId);
    }

    @Test
    public void findPetsByStatus() {
        Response response = given()
                .spec(requestSpecification)
                .queryParam("status", "available")
                .log().all()
                .when()
                .get("/pet/findByStatus")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        PetDto[] pets = response.as(PetDto[].class);
        log.info("Found " + pets.length + " available pets.");
    }

    @Test
    public void findPetsByID() {
        Response response = given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get("/pet/" + createdPetId)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        PetDto pet = response.as(PetDto.class);
        log.info("Found pet with ID " + createdPetId + ": " + pet);
    }

    @Test
    public void updatePet() {
        PetDto updatedPet = TestDataFactory.createPet(createdPetId, "Azorel Updated", new PetDto.CategoryDto(1, "Caine mare"), new PetDto.TagDto(1, "Cuminte"), "Available");

        Response response = given()
                .spec(requestSpecification)
                .body(updatedPet)
                .log().all()
                .when()
                .put("/pet")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        PetDto petResponse = response.as(PetDto.class);
        log.info("Updated pet:" + petResponse);
    }

    @AfterClass
    public void deletePet() {
        Response response = given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .delete("/pet/" + createdPetId)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        log.info("Deleted ID: " + createdPetId);
    }
}
