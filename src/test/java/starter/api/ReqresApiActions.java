package starter.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractions;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.is;


public class ReqresApiActions extends UIInteractions {
    public Response response;

    @When("I ask for a page using page number: {pageNumber}")
    public void whenGetUsersPage(int pageNumber) {
        when()
                .get("https://reqres.in/api/users?page=" + pageNumber);
    }

    @Then("I get a result")
    public void thenIGetAResult() {
        then().body("page", is(2));
    }

    @When("I create a user with name {name} and job {job}")
    public Response whenCreateUser(UsersModel user, String name, String job) {
       response = given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(user)
                .when()
                .post("https://reqres.in/api/users");
        return response;
    }

    @Then("A user is created with name {name} and job {job}")
    public void userIsCreated(String name, String job) {
        response
                .then()
                .statusCode(201)
                .body("name", is(name))
                .body("job", is(job));
    }
}
