package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    /*
    send a request to this website:
    "https://restful-booker.herokuapp.com/booking/3"
    and test the response have this three things:
    1- HTTP status code equals 200,
    2- Content Type is Json,
    3- Status Line is HTTP/1.1 200

    this stages will help you to resolve problem
            1- first, determine the endpoint.
            2- create an expected result(we do not need to create expected result because the question has not verify test body part)
            3- send a request
            4- create an actual result
            5- verify that actual result equals expected result or not.
         */

    @Test
    public void test(){
        String url ="https://restful-booker.herokuapp.com/booking/3";


    Response response = given().
            accept("application/json").
            when().
            get(url);

    response.prettyPrint();
        System.out.println("status code: " + response.getStatusCode());
        System.out.println("content type: " + response.getContentType());
        System.out.println("status line: " + response.getStatusLine());


        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        //I took pass results from all tests.
        //we have a different way to get solution.
        //take one of them in the comment line while run the test.
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

    }
}









