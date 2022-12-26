package com.alex.jobs.innotech.rest;

import com.alex.jobs.innotech.rest.dto.User;
//import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserApiSteps {

    public UserApiSteps createUser(User user) {
        given()
//                .filters(new AllureRestAssured()).log().all()
                .header("Content-Type", "application/json")
                .body(user)
                .post("/");
        return this;

    }

    public UserApiSteps login(User user) {
        given()
//                .filters(new AllureRestAssured()).log().all()
                .header("Content-Type", "application/json")
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .get("/login");
        return this;
    }

    public User getUser(String username) {
        return given()
//                .filters(new AllureRestAssured()).log().all()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .get("/{username}")
                .as(User.class);
    }

    public UserApiSteps updateUser(User user) {
        given()
//                .filters(new AllureRestAssured()).log().all()
                .header("Content-Type", "application/json")
                .body(user)
                .post("/");
        return this;
    }

    public UserApiSteps deleteUser(String username) {
        given()
//                .filters(new AllureRestAssured()).log().all()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .delete("/{username}")
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(404)));
        return this;
    }
}
