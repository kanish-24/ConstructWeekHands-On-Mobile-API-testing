package api_testing;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SwaggerPetstoreApi {

	@Test(priority = 1)
	public void createlistofUsers() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		// JSON body for the POST request
		String jsonBody = "[\n" + "  {\n" + "    \"id\": 56,\n" + "    \"username\": \"kanishk\",\n"
				+ "    \"firstName\": \"kanishhhk\",\n" + "    \"lastName\": \"chaddha\",\n"
				+ "    \"email\": \"kanish@gmail.com\",\n" + "    \"password\": \"69786wghsfwvg\",\n"
				+ "    \"phone\": \"9886655677\",\n" + "    \"userStatus\": 65765\n" + "  }\n" + "]";

		Response response = RestAssured.given().header("accept", "application/json")
				.header("Content-Type", "application/json").body(jsonBody).post("/user/createWithList");

		System.out.println("Response Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());
	}

	@Test(priority = 2)
	public void getuserbyUserName() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		given().contentType(ContentType.JSON).get("/user/kanishk").then().statusCode(200).log().all();
	}

	@Test(priority = 3)
	public void updatedUser() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		JSONObject js = new JSONObject();

		js.put("id", 101);
		js.put("username", "user2");
		js.put("firstName", "Kanish");
		js.put("lastName", "Chaddha");
		js.put("email", "Kanisch34@gmai.com");
		js.put("password", "kals#34");
		js.put("phone", "8890098989");
		js.put("userStatus", 200);

		given().contentType(ContentType.JSON).body(js.toJSONString()).put("/user/user1").then().statusCode(200).log()
				.all();

	}

	@Test(priority = 4)
	public void deleteUser() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		given().contentType(ContentType.JSON).delete("/user/user2").then().log().all();
	}

	@Test(priority = 5)
	public void logsuserIntoTheSystem() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		given().contentType(ContentType.JSON).queryParam("username", "user2").queryParam("password", "kals#34")
				.get("/user/login").then().statusCode(200).log().all();

	}

	@Test(priority = 6)
	public void logsoutCurrentLoggedInUserSession() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		given().contentType(ContentType.JSON).get("/user/logout").then().statusCode(200).log().all();
	}

	@Test(priority = 7)
	public void createsListOfUsersWithgivenInputArray() {

		// JSON body for the POST request
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		String jsonBody = "[\n" + "  {\n" + "    \"id\": 102,\n" + "    \"username\": \"user3\",\n"
				+ "    \"firstName\": \"Kanishk\",\n" + "    \"lastName\": \"Singh\",\n"
				+ "    \"email\": \"Kanisch34@gmai.com\",\n" + "    \"password\": \"kals#34\",\n"
				+ "    \"phone\": \"8890098989\",\n" + "    \"userStatus\": 201\n" + "  }\n" + "]";

		Response response = RestAssured.given().header("accept", "application/json")
				.header("Content-Type", "application/json").body(jsonBody).post("/user/createWithArray");

		System.out.println("Response Status Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asString());

	}

	@Test(priority = 8)
	public void createUser() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		JSONObject js = new JSONObject();

		js.put("id", 102);
		js.put("username", "user5");
		js.put("firstName", "Kanishk");
		js.put("lastName", "Singh");
		js.put("email", "Kanisch34@gmai.com");
		js.put("password", "kals#34");
		js.put("phone", "8890090009");
		js.put("userStatus", 201);

		given().contentType(ContentType.JSON).body(js.toJSONString()).when().post("/user").then().statusCode(200).log()
				.all();

	}
}
