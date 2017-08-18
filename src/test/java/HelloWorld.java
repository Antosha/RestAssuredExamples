/**
 * Created by abondariev on 8/16/17.
 */

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import com.jayway.restassured.response.*;
import org.junit.Test;

public class HelloWorld {

    @Test
    public void makeSureGoogle() {
        //given().when().get("http://www.google.com").then().statusCode(200);

        //ValidatableResponse respons1 =
//                given().when()
//                .get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
//                .then().body("sys.country", equalTo("GB"));

//                String country = given().when()
//                        .get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
//                        .then().extract().path("country");
//                assertThat(country, equalTo("GB"));


                String country1 = get("http://api.openweathermap.org/data/2.5/weather?id=2643743&APPID=d7f520b169953aaea6fb8ef6b3377311")
                        .path("sys.country");
                System.out.println(country1);
                assertThat(country1, is("GB"));



    }
}

