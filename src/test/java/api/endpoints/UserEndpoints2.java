
package api.endpoints;
// userendpoints.java 
//created to perform crud operations to the user model 
import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class UserEndpoints2 {
	
	//method created for loading property file 
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");// here routes get bundle that is property file 
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		
		return response;
	}
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
			.pathParam("username", userName)
			
		.when()
			.get(get_url);
		
		return response;
	}
	public static Response updateUser(User payload, String userName)
	{
		
		String update_url=getURL().getString("update_url");
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.pathParam("username", userName)
		.when()
			.put(Routes.update_url);
		
		return response;
	}
	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
			.pathParam("username", userName)
			
		.when()
			.delete(delete_url);
		
		return response;
	}
}
