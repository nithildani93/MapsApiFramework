package stepDef;

import org.constants.ResourceName;
import org.dataBind.AddPlacePayload;
import org.dataBind.DeletePlacePayload;
import org.junit.Assert;
import org.utilities.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

import java.io.IOException;
public class AddPlaceStepdef extends Utils {
	
	RequestSpecification request;
	Response response;
	
	static String placeId;

	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		AddPlacePayload addplace = new AddPlacePayload();
		
		request = given().spec(requestSpec())
				.body(addplace.Addplacedata(name, language, address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiCall, String method) {
		
		
			ResourceName rn = ResourceName.valueOf(apiCall);
			if(method.equalsIgnoreCase("GET")) {
				response = request.when().get(rn.getResource());
			}
			if(method.equalsIgnoreCase("POST")) {
				response = request.when().post(rn.getResource());
			}
		
		
		
		
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		Assert.assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedvalue) {
		String actualvalue = Utils.getJsonPath(response, key);
		Assert.assertEquals(actualvalue, expectedvalue);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String apiCall) {
		placeId = getJsonPath(response, "place_id");
		System.out.println("Place Id: "+ placeId);
		
		request = given().spec(reqSpec).queryParam("place_id", placeId);
		user_calls_with_http_request(apiCall, "GET");
		String actualname = getJsonPath(response, "name");
		System.out.println(actualname);
		Assert.assertEquals(expectedName, actualname);
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		DeletePlacePayload delete = new DeletePlacePayload();
		request = given().spec(requestSpec()).body(delete.DeletePlacedata(placeId));
		
	}



}
