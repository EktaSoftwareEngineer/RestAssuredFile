import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {

	@Test
	void getwaetherDetails() {
		// specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		// response object need to be created
		Response response = httprequest.request(Method.GET, "/Hyderabad");
		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" + responseBody);
		// how to capture the status code?
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		// status line
		String statusline = response.getStatusLine();
		System.out.println(statusline);
		// Assert
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	}

}
