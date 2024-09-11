package api.endpoints;
//from the swagger we capture the urla
/*
 * swagger url:https://petstore.swagger.io/v2
 [ Base URL: petstore.swagger.io/v2 ]
create user :https://petstore.swagger.io/v2/user
get user : https://petstore.swagger.io/v2/user/{username}
update user:https://petstore.swagger.io/v2/user/{username}
delete user:https://petstore.swagger.io/v2/user/{username}
 
 * */
public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	//user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//storemodule
	//here you can create store module url's
	
		
}
