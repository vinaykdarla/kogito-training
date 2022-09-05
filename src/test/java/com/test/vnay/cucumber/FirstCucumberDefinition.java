package com.test.vnay.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.collections4.map.HashedMap;

import com.test.vnay.Account;
import com.test.vnay.Customer;
import com.test.vnay.Response;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.quarkus.arc.Unremovable;
import io.restassured.RestAssured;

@ApplicationScoped
public class FirstCucumberDefinition extends KogitoUtil{
	public FirstCucumberDefinition() {
		RestAssured.port = 8081;
	}
	
	@Given("^kogito-training rules are initialized$")
	public void init_rules() {
		objects = new HashedMap<String, Object>();
		reqIn = new HashedMap<String, Object>();
		resOut = new HashedMap<String, Object>();
		customer = new Customer();
		account = new Account();
		response = new Response();
	}
	
	@When("^we run all the rules from process$")
	public void when_we_run_all_rules() {
		executeKogitoRules();
	}
	@And("set {word} of type {word} with values")
	public void setValuesToObject(String var,String className,DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		setObjectValues(className, list);
		
	}

	@Then("{word} must {word} one object {word} {word} named as {word} with values")
	public void checkObjectContent(String  src, String type, String inOrAt,String target, String var, DataTable dataTable) {
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		if(src.equalsIgnoreCase("resOut")) {
			Response serviceResp = (Response) resOut.get("resOut");
			setObjectValues("response", list);
			if(!serviceResp.equals(response)) {
				assertEquals(serviceResp,response);
			}
		}
		
	}
	
	private void setObjectValues(String className, List<Map<String, String>> list) {
		for(int i=0;i<list.size();i++) {
			String name = list.get(i).get("Name");
			String value = list.get(i).get("Value");
			if(className.equalsIgnoreCase(Customer.class.getSimpleName())) {
				if(ObjectUtil.callGetterType(customer, name).toString().equalsIgnoreCase("int") ){
					ObjectUtil.callSetter(customer, name,Integer.valueOf(value));
				}else {
				ObjectUtil.callSetter(customer, name, value);
				}
				reqIn.put("customer", customer);
				
			}else if (className.equalsIgnoreCase(Account.class.getSimpleName())) {
				ObjectUtil.callSetter(account, name, value);
				reqIn.put("account", account);
			}else if (className.equalsIgnoreCase(Response.class.getSimpleName())) {
				if(ObjectUtil.callGetterType(response, name).toString().equalsIgnoreCase("boolean") ){
					ObjectUtil.callSetter(response, name,Boolean.valueOf(value));
				}else {
				ObjectUtil.callSetter(response, name, value);
				}
			}
			
		}
	}
	

}
