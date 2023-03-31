package com.stl.ManagerAcceptRejectLeave;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerAcceptRejectLeaveMicroserviceApplicationTests {

    @Test
    @Order(1)
    public void testupdate() {
        String jsonbody="{\"leavestatus\":\"NotApproved\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .put("http://localhost:8089/acceptreject/update/9")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
//    
//    @Test
//    @Order(2)
//    public void testLogin() {
//        String jsonbody= "{\"email\" : \"pavan@gmail.com\",\"password\" : \"pavan0209\"}";
//        String token=given()
//                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//                .body(jsonbody)
//                .when()
//                .post("http://localhost:8082/Employees/authenticate")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().asString();
//    }
//    
//    @Test
//    @Order(3)
//    public void testgetallManagers() {
//        String result=given()
//                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//                .when()
//                .get("http://localhost:8082/Employees/get")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().asString();
//    }
    
    @Test
    @Order(4)
    public void testgetManagersbyid() {
        String result=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .when()
                .get("http://localhost:8089/acceptreject/getbymanager/hema@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
//    
//    @Test
//    @Order(5)
//    public void testdeleteEmployee() {
//        String jsonbody= "{\"email\" : \"pavan@gmail.com\",\"password\" : \"pavan0209\"}";
//        String token=given()
//                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
//                .body(jsonbody)
//                .when()
//                .post("http://localhost:8082/Employees/authenticate")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().asString();
//        
//        String result=given()
//                .header("Authorization","Bearer "+token).contentType(ContentType.JSON).accept(ContentType.JSON)
//                .when()
//                .delete("http://localhost:8082/Employees/delete/pavan@gmail.com")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().asString();
//    }
}
