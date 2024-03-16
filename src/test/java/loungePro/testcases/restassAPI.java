package loungePro.testcases;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restassAPI {

	@Test
	public void testAPI() {
	Response res=RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(res.asString());
	System.out.println(res.getStatusCode());
	}

}
