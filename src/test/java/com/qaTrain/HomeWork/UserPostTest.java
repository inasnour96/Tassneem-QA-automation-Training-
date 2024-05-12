package com.qaTrain.HomeWork;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserPostTest {

    @Test
    public void testUsersApiMethod () {

       Response res = given().baseUri("https://jsonplaceholder.typicode.com")
                .when().get("/users")
                .then()
//                .log().all()
                .assertThat().statusCode(200)
                .extract().response();   //extract response then take it as string

        //define users array to store in it all ids by split the string response based on "id :" subString.
        //and "name:" subString.
        String[] ids = res.asString().split("\"id\":");
        String[] names = res.asString().split("\"name\":");
        System.out.println("Number of IDs: " + (ids.length - 1));

        for (int i = 1; i < ids.length ; i++) {    // i try to start from index=0, but its an empty index
            String id = ids[i].split(",")[0];
            String name = names[i].split(",")[0];
            System.out.println("ID: " + id + ", Name: " + name);
        }

           }


    @Test
    public void testPostsApiMethodSolutionOne () {
    given().baseUri("https://jsonplaceholder.typicode.com")
                .when().get("/posts")
                .then()
//                .log().all()
                .assertThat().statusCode(200)
            .assertThat().body("[16].id", equalTo(17))
            .assertThat().body("[16].title", equalTo("fugit voluptas sed molestias voluptatem provident"))
            .body("userId", everyItem(not(empty())))
            .body("id", everyItem(not(empty())))
            .body("title", everyItem(not(empty())))
            .body("body", everyItem(not(empty())));


    }


    @Test   //Solution 2
    public void testPostsApiMethodSolutionTwo () {
        given().baseUri("https://jsonplaceholder.typicode.com")
                .when().get("/posts/17")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("title", equalTo("fugit voluptas sed molestias voluptatem provident"))
               ;
   }

   @Test
    public void testPostsApiMethodSolutionTwoCont () {

       given().baseUri("https://jsonplaceholder.typicode.com")
               .when().get("/posts")
               .then()
               .assertThat().statusCode(200)
         .body("userId", everyItem(not(empty())))
               .body("id", everyItem(not(empty())))
               .body("title", everyItem(not(empty())))
               .body("body", everyItem(not(empty())));
   }
}

