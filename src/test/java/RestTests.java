/**
 * Created by abondariev on 8/17/17.
 */

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RestTests {

    // API key that is given after creating new account on OpenWeatherMap
    private static final String APPID = "d7f520b169953aaea6fb8ef6b3377311";

    //ID for Great Britain
    private static final String GB_ID = "2643743";

    private static final String LONDON = "London";

    @Test
    public void checkThatCountryisReturnedUsingCountryID() {
//        String country1 = get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
//                .path("sys.country");

//        given().when()
//                .get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
//                .then().body("sys.country", equalTo("GB"));

//        String country = given().when()
//                .get("http://api.openweathermap.org/data/2.5/weather?id="+ GB_ID + "&" + "APPID="+APPID)
//                .path("sys.country");
//
//
        String country = given().when()
                .get(String.format("http://api.openweathermap.org/data/2.5/weather?id=%s&APPID=%s", GB_ID, APPID))
                .path("sys.country");

        assertThat(country, is("GB"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityName() {

        String city = given().when()
                .get(String.format("http://api.openweathermap.org/data/2.5/weather?id=%s&APPID=%s", GB_ID, APPID))
                .path("name");


        assertThat(city, is("London"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityID() {

        expect().body("sys.country", equalTo("GB")).when()
                .get("http://api.openweathermap.org/data/2.5/weather?q="+ LONDON + "&" + "APPID="+APPID);

    }



}
