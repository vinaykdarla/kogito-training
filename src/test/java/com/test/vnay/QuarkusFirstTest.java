package com.test.vnay;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class QuarkusFirstTest {
	@SuppressWarnings("unchecked")
	@Test
    public void testProcessEndpoint() {
		Map<String,Object> reqMap = new HashMap<String, Object>();
		Map<String,Object> resMap = new HashMap<String, Object>();
		reqMap.put("customer", new Customer());
		io.restassured.response.Response res = given().contentType(ContentType.JSON).body(reqMap).post("/process_1")
          .then().extract().response();
		resMap = res.as(Map.class);
		Object resp = resMap.get("response");
		
		System.out.println("res --> "+resp);
    }

}
