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

    //ID for Great Britain
    private static final String GB_ID = "2643743";

    private static final String LONDON = "London";


    @Before
    public void setUp() {
        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
    }

    @Test
    public void checkThatCountryisReturnedUsingCountryID() {
        // Do not forget to add query parameters and rewrite assert to be more concise

                given()
                .queryParam("id", GB_ID)
                .queryParam("APPID", APPID)
                .when()
                .get("/weather")
                        .then().body("sys.country", equalTo("GB"));

//        assertThat(country, is("GB"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityName() {

        String city = given().when()
                .get(format("http://api.openweathermap.org/data/2.5/weather?id=%s&APPID=%s", GB_ID, APPID))
                .path("name");


        assertThat(city, is("London"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityID() {

        expect().body("sys.country", equalTo("GB")).when()
                .get("http://api.openweathermap.org/data/2.5/weather?q="+ LONDON + "&" + "APPID="+APPID);

    }



}
