package api.test;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userpayload;
	public Logger logger;
	@BeforeClass  // this method will be executed before starting of all test methods
	public void setup()
	{
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());// here hashcode is used to generate random
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
		logger=LogManager.getLogger(this.getClass());
	}	
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("************ Creating user ******************************");
		Response response=UserEndpoints.createUser(userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************ user created ******************************");
		
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("************ Reading user info ******************************");
		Response response =UserEndpoints.readUser(this.userpayload.getUsername());
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 logger.info("************ User info displayed ******************************");
	}
	
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("************ updating user ******************************");
		// update data using payload
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndpoints.updateUser(userpayload,this.userpayload.getUsername());
		response.then().log().body();
		response.then().log().body().statusCode(200);
		// here the two statements are same both are checking status code is 200 or not
		//Assert.assertEquals(response.getStatusCode(), 200);
		// checking  data after update
		
		Response responseAfterUpdate=UserEndpoints.createUser(userpayload);
		
		responseAfterUpdate.then().log().all();
		System.out.println("updated");
		
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		logger.info("************  user is updated ******************************");
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		logger.info("************ deleting user ******************************");
		Response response=UserEndpoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************  user is deleted ******************************");
	}
}
