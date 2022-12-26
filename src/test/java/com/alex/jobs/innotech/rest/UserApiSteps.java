package com.alex.jobs.innotech.rest;

import com.alex.jobs.innotech.rest.dto.User;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserApiSteps {

    @Step("Create user")
    public UserApiSteps createUser(User user) {
        given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("/");
        return this;

    }

    @Step("Login")
    public UserApiSteps login(User user) {
        given()
                .header("Content-Type", "application/json")
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .get("/login");
        return this;
    }

    @Step("Get user data")
    public User getUser(String username) {
        return given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .get("/{username}")
                .as(User.class);
    }

    @Step("Update user data")
    public UserApiSteps updateUser(User user) {
        given()
                .header("Content-Type", "application/json")
                .pathParam("username", user.getUsername())
                .body(user)
                .put("/{username}");
        return this;
    }

    @Step("Delete user")
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
