import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_ValidatingJSONResponse {

		@Test
		void GetWeatherDetails() {
			// specify base URI
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
			// Request object 
			RequestSpecification httprequest = RestAssured.given();

			Response response = httprequest.request(Method.GET, ",/San jose");
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
			// Assert if san jose present in response body 
			
			//display all headers in the response
			Headers allHeaders = response.headers();
			
			for(Header header: allHeaders) {
				System.out.println(header.getName() + "     ------>   " + header.getValue());
			}
			
		}


}
