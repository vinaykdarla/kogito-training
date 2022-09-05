package com.test.vnay.cucumber;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.test.vnay.Account;
import com.test.vnay.Customer;
import com.test.vnay.Response;

import io.quarkus.arc.Unremovable;
import io.restassured.http.ContentType;

@ApplicationScoped
@Unremovable
public class KogitoUtil {
	
	protected Map<String,Object> objects = null;
	protected Map<String,Object> reqIn = null;
	protected Map<String,Object> resOut = null;
	protected static Customer customer = null;
	protected static Account account = null;
	protected static Response response = null;
	protected static String processName= null;
	protected static String CONFIG_PATH="src/test/resources/config.properties";
	
	public KogitoUtil() {
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> executeKogitoRules(){
		Map<String,Object> resMap = new HashMap<String, Object>();
		Gson gson = new Gson();
		io.restassured.response.Response res = given().contentType(ContentType.JSON).body(reqIn).when().post("/process_1").then().extract().response();
		resMap = res.as(Map.class);
		Object resp = resMap.get("response");
		JsonElement jsonElement = gson.toJsonTree(resp);
		Response response = gson.fromJson(jsonElement, Response.class);
		resOut.put("resOut", response);
		return resOut;
	}
	
	public static String retrieveServiceUrl() {
		return null;
	}

}
