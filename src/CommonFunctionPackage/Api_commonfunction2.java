package CommonFunctionPackage;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Api_commonfunction2 {
	
public static int StatusCode(String baseURI,String resource) {
	RestAssured.baseURI=baseURI;
int statusCode = given().header("Content-Type","application/json").log().all().when().get("/api/users?page=2").then().log().all().extract().statusCode();
 return statusCode;
}
public static String resource(String baseURI,String resource) {
	 String responseBody = given().header("Content-Type","application/json").log().all().when().get("/api/users?page=2").then().log().all().extract().response().asString();
	 return responseBody;
}
}
