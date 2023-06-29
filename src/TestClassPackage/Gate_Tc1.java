package TestClassPackage;

//import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonFunctionPackage.Api_commonfunction2;
import RequestRepositoryPackage.Gate_req_repository;
//import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Gate_Tc1 {
@Test
	public static void Execute(){
 
     // Step 1 :Declare BaseURL
 String baseURI=Gate_req_repository.baseURI();
 String resource=Gate_req_repository.resource();
 
 int statusCode=Api_commonfunction2.StatusCode(baseURI,resource);
 String responseBody=Api_commonfunction2.resource(baseURI,resource);
  
      System.out.println("Response Status Code: " + statusCode);
      System.out.println("Response Body: " + responseBody);

      JsonPath jsopresponse = new JsonPath(responseBody);
      
      int dataSize = jsopresponse.getList("data").size();

        // Assert the total count of objects inside the data array
       // Assert.assertEquals(dataSize, 6);
   // Expected result 
		
   		int id [] = {7, 8, 9, 10, 11, 12};
   	    String[] email = {"michael.lawson@reqres.in", "lindsay.ferguson@reqres.in", "tobias.funke@reqres.in", "byron.fields@reqres.in", "george.edwards@reqres.in", "rachel.howell@reqres.in"};
   	    String[] first_name = {"Michael","Lindsay","Tobias","Byron","George","Rachel"};
   	    String[] last_name = {"Lawson","Ferguson","Funke","Fields","Edwards","Howell"};
   	    String[] avatar = {"https://reqres.in/img/faces/7-image.jpg","https://reqres.in/img/faces/8-image.jpg",
   	    		           "https://reqres.in/img/faces/9-image.jpg","https://reqres.in/img/faces/10-image.jpg",
   	    		           "https://reqres.in/img/faces/11-image.jpg","https://reqres.in/img/faces/12-image.jpg"};
   		
        // Validate each object in the data array
		 int count =jsopresponse.getList("data").size();
   	 for(int i=0;i<count; i++)
	 {
		 // Expected result
		 
		 int exp_id = id[i];
	     String exp_email = email[i];
	     String exp_first_name = first_name[i];
	     String exp_last_name = last_name[i];
	     String exp_avatar = avatar[i];
		 
		 int  res_id =jsopresponse.getInt("data["+i+"].id");
		 String res_email = jsopresponse.getString("data["+i+"].email");
		 String res_first_name = jsopresponse.getString("data["+i+"].first_name");
		 String res_last_name = jsopresponse.getString("data["+i+"].last_name");
		 String res_avatar = jsopresponse.getString("data["+i+"].avatar");
		 
		 // validate
		 Assert.assertEquals(res_id, exp_id,"ID at index " + i);
         Assert.assertEquals(res_email, exp_email, "Email at index " + i);
         Assert.assertEquals(res_first_name, exp_first_name, "Firstname at index " + i);
         Assert.assertEquals(res_last_name, exp_last_name, "Lastname at index " + i);
         Assert.assertEquals(res_avatar, exp_avatar, "Avatar at index " + i);
	}

	}


		
	}
