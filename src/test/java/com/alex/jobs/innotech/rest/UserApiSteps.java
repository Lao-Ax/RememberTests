package com.alex.jobs.innotech.rest;

import com.alex.jobs.innotech.rest.dto.User;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserApiSteps {

    public UserApiSteps createUser(User user) {
        given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("/");
        return this;

    }

    public UserApiSteps login(User user) {
        given()
                .header("Content-Type", "application/json")
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .get("/login");
        return this;
    }

    public User getUser(String username) {
        return given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .get("/{username}")
                .as(User.class);
    }

    public UserApiSteps updateUser(User user) {
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body(user).post("/");
        return this;
    }

    public UserApiSteps deleteUser(String username) {
        given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .delete("/{username}")
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(404)));
        return this;
    }
}
