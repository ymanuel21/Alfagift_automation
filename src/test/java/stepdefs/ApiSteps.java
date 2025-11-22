package stepdefs;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ApiSteps {

    private Response response;
    private List<Map<String, Object>> data;

    @When("I call {string} endpoint")
    public void callPersonsApi(String endpoint) {
        System.out.println("Endpoint called: " + endpoint);
    }

    @When("^I call \"([^\"]*)\" endpoint with _quantity=(\\d+), _gender=([^\"]*), _birthday_start=([^\"]*), _birthday_end=([^\"]*)$")
    public void callPersonsApi(String endpoint, int quantity, String gender, String birthdayStart, String birthdayEnd) {
        String url = "https://fakerapi.it/api/v2/" + endpoint;

        response = RestAssured
                .given()
                .queryParam("_quantity", quantity)
                .queryParam("_gender", gender)
                .queryParam("_birthday_start", birthdayStart)
                .queryParam("_birthday_end", birthdayEnd)
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response();

        data = response.jsonPath().getList("data");

        // Optional: print response to console
        System.out.println(response.asPrettyString());
    }

    @Then("I should get {int} persons")
    public void verifyTotalPersons(int expectedCount) {
        Assert.assertEquals(data.size(), expectedCount, "Total data count mismatch");
    }

    @And("each person should be {string}")
    public void verifyEachGender(String expectedGender) {
        for (Map<String, Object> person : data) {
            String gender = person.get("gender").toString();
            Assert.assertEquals(gender, expectedGender, "Gender mismatch");
        }
    }

    @And("each person's birthday should be between {string} and {string}")
    public void verifyBirthdayRange(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        for (Map<String, Object> person : data) {
            LocalDate birthday = LocalDate.parse(person.get("birthday").toString());

            Assert.assertTrue(
                    !birthday.isBefore(start) && !birthday.isAfter(end),
                    "Birthday out of range: " + birthday
            );
        }
    }
}
