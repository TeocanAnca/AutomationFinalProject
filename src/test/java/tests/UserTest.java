package tests;

import base.BaseTest;
import config.BaseConfig;
import dto.UserDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.TestDataFactory;

import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserTest extends BaseTest {

    private UserDto createDefaultUser(){
        long id = System.currentTimeMillis();
        return TestDataFactory.createUser(id, "ancateocan", "Anca", "Teocan", "anca@gmail.com", "test1234", "0723529877", 1);
    }

    String createdUsername;
    @Test
    public void createUser(){
        UserDto newUser = createDefaultUser();

        Response response = given()
                .spec(requestSpecification)
                .body(newUser)
                .log().all()
                .when()
                .post("/user")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto newCreatedUser = response.as(UserDto.class);
        log.info("The new created user:" + newUser.getId());
        createdUsername = newUser.getUsername();
        log.info("Username: " + createdUsername);
    }

    @Test // Create user with LIST
    public void createUserWithList(){
        UserDto createUserList = createDefaultUser();
        List<UserDto> users = List.of(createUserList);

        Response response = given()
                .spec(requestSpecification)
                .body(users)
                .log().all()
                .when()
                .post("/user/createWithList")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto newcreatedUserWithList = response.as(UserDto.class);
        log.info("Users as list:" + createUserList.getId());
    }

    @Test // Create user with Array
    public void createUserWithArray()
    {
        UserDto createUserArray = createDefaultUser();
        UserDto[] users = {createUserArray};

        Response response = given()
                .spec(requestSpecification)
                .body(users)
                .log().all()
                .when()
                .post("/user/createWithArray")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto newCreatedUserWithArray = response.as(UserDto.class);
        log.info("User array:" + createUserArray.getId());
    }

    //Get username
    @Test
    public void getUsername(){
        Response response = given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get("/user/"+createdUsername)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto getUserUsername = response.as(UserDto.class);
        log.info("The user with the username " + getUserUsername + " exists");
    }

    //Update User
    @Test
    public void updateUser(){
        UserDto updatedUser = TestDataFactory.createUser(createDefaultUser().getId(), "ancateocan", "Laura", "Maria", "laura@gmail.con", "test1234", "0723529877", 1);
        Response response = given()
                .spec(requestSpecification)
                .body(updatedUser)
                .log().all()
                .when()
                .put("/user/"+createdUsername)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto userUpdated = response.as(UserDto.class);
        log.info("The user is successfully updated");
    }


    //Login
    @Test
    public void login(){
        Response response = given()
                .spec(requestSpecification)
                .log().all()
                .param("password", "test1234")
                .param("username", "ancateocan")
                .when()
                .get("/user/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto loginWithCredential = response.as(UserDto.class);
        log.info("The user is successfully logged in");
    }

    @Test
    public void logOut()
    {
        Response response = given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get("/user/logout")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto logout = response.as(UserDto.class);
        log.info("The user is successfully logged out");
    }

    @Test
    public void deteleUsername(){
        Response response = given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .delete("/user/"+createdUsername)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();

        UserDto usernameDeleted = response.as(UserDto.class);
        log.info("The username was deleted");

    }
}
