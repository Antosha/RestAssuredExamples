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
    public static final String APPID = "d7f520b169953aaea6fb8ef6b3377311";

    //ID for Great Britain
    public static final String GB_ID = "2643743";

    public static final String London = "London";

    @Test
    public void checkWeatherMap() {
//        String country1 = get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
//                .path("sys.country");

//        given().when()
//                .get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
//                .then().body("sys.country", equalTo("GB"));

        String country = given().when()
                .get("http://api.openweathermap.org/data/2.5/weather?id="+ GB_ID + "&" + "APPID="+APPID)
                .path("sys.country");

        assertThat(country, is("GB"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityName() {

        String city = given().when()
                .get("http://api.openweathermap.org/data/2.5/weather?q="+ London + "&" + "APPID="+APPID)
                .path("name");

        System.out.println(city);

        assertThat(city, is("London"));

    }

    @Test
    public void checkThatCityisReturnedUsingCityID() {



    }



}
