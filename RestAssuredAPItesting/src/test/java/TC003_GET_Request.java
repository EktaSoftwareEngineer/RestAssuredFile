import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	@Test
	void googleMapTest() {
		// specify base URI
		RestAssured.baseURI = "http://maps.googleapis.com";
		// Request object 
		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.request(Method.POST, ",//maps//api//place//nearbysearch//xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s\\");
		///maps/search/Restaurants/@37.2886499,-121.8742445,14z/data=!3m1!4b1
	// print response in console window
		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is :" + responseBody);
		
		//print response body
		System.out.println(responseBody);
		// Capture details of header from response
		String contentType = response.header("Content-Type");// capture content type from headers
		System.out.println("Content Type is :" + contentType);
		// Assert 
		
		// content encoding 
		String contentEncoding = response.header("Content-Encoding");// capture content type from headers
		System.out.println("Content encoding Type is :" + contentEncoding);
		// Assert
		
		//display all headers in the response
		Headers allHeaders = response.headers();
		
		for(Header header: allHeaders) {
			System.out.println(header.getName() + "     ------>   " + header.getValue());
		}
		
	}



}
