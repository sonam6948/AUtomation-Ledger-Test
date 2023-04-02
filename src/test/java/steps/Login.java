package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;

public class Login {

    private static final String BASE_URL = "https://api.realworld.io/api/users/login";

    private static String token;
    public static Response response;
    private static String jsonString;

    @Given("user has credentials")
    public void credentials(){
    }
    @When("login service is called")
    public Response login() {

        RestAssured.baseURI = BASE_URL;

        File jsonDataInFile = new File("src/test/java/resources/requests/login.json");
         response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(jsonDataInFile)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200).log().all().extract().response();
        return response;
    }
    @Then("verify user logged in successfully")
    public void userLoggedIn(){
         jsonString = response.asString();
         token = JsonPath.from(jsonString).get("token");
         System.out.println(token);
    }
}