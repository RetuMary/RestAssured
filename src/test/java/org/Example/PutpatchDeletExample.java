package org.Example;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PutpatchDeletExample {

	@Test
	public void testPut() {

		JSONObject request = new JSONObject();

		request.put("name", "Raya");
		request.put("job", "Teacher");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";

		given().
		
		header("Content-Type","application/Json").
		body(request.toJSONString()).
		when().
		put("users/2").

				then().
				statusCode(200).
				log().all();
	}

	@Test
	public void testPatch() {

		JSONObject request = new JSONObject();

		request.put("name", "Raya");
		request.put("job", "Teacher");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/";

		given().
		
		header("Content-Type","application/Json").
		body(request.toJSONString()).
		when().
	patch("/api/users/2").

				then().
				statusCode(200).
				log().all();
	}

	@Test
	public void testDelete() {

		
		baseURI = "https://reqres.in/";

		given().
		
		when().
	delete("/api/users/2").
				then().
				statusCode(204).
				log().all();
	}

				








}
