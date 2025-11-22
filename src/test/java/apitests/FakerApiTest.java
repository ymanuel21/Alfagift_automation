package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class FakerApiTest {

    @Test
    public void testPersonsEndpoint() {
        String url = "https://fakerapi.it/api/v2/persons";
        
        Response response = RestAssured
                .given()
                .queryParam("_quantity", 10)
                .queryParam("_gender", "male")
                .queryParam("_birthday_start", "1990-01-01")
                .queryParam("_birthday_end", "2000-12-31")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, Object>> data = response.jsonPath().getList("data");
        Assert.assertEquals(data.size(), 10, "Total data count mismatch");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("1990-01-01", formatter);
        LocalDate endDate = LocalDate.parse("2000-12-31", formatter);

        for (Map<String, Object> person : data) {
            String gender = person.get("gender").toString();
            Assert.assertEquals(gender, "male", "Gender mismatch");

            LocalDate birthday = LocalDate.parse(person.get("birthday").toString(), formatter);
            Assert.assertTrue(!birthday.isBefore(startDate) && !birthday.isAfter(endDate),
                    "Birthday out of range: " + birthday);
        }
    }
}
