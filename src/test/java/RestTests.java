/**
 * Created by abondariev on 8/17/17.
 */

import io.restassured.*;
import org.junit.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static java.lang.String.format;

public class RestTests {

    // API key that is given after creating new account on OpenWeatherMap
    private static final String APPID = "d7f520b169953aaea6fb8ef6b3377311";

    private static final String WEATHER_URI = "http://api.openweathermap.org/data/2.5";
    private static final String WEATHER_PATH = "/weather";

    //ID for Great Britain
    private static final String GB_ID = "2643743";

    private static final String LONDON = "London";


    @Before
    public void setUp() {
        RestAssured.baseURI = WEATHER_URI;
        RestAssured.basePath = WEATHER_PATH;
    }

    @Test
    public void checkThatCountryisReturnedUsingCountryID() {
        // Do not forget to add query parameters and rewrite assert to be more concise

                given()
                .queryParam("id", GB_ID)
                .queryParam("APPID", APPID)
                .when()
                .get()
                        .then().body("sys.country", equalTo("GB"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityName() {

//        String city = given().when()
//                .get(format("http://api.openweathermap.org/data/2.5/weather?id=%s&APPID=%s", GB_ID, APPID))
//                .path("name");

                given()
                        .queryParam("id", GB_ID)
                        .queryParam("APPID", APPID)
                        .when()
                        .get()
                        .then().body("name", equalTo("London"));

    }

}
