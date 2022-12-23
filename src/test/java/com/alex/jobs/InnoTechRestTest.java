package com.alex.jobs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class InnoTechRestTest {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/user";
    private User user;

    @BeforeTest
    public void before() {
        user = new User();
        user.setUsername("User_ap_1");
        user.setEmail("email_ap_1@mail.com");
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setPassword("pass");
        user.setPhone("12345");
        RestAssured.baseURI = BASE_URI;
        createUser(user);
        login(user);
    }

    private void createUser(User user) {
        given()
                .header("Content-Type", "application/json")
                .body(user)
                .post("/");
    }

    private void login(User user) {
        given()
                .header("Content-Type", "application/json")
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .get("/login");
    }

    private User getUser(String username) {
        return given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .get("/{username}")
                .as(User.class);
    }

    private void updateUser(User user) {
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        Response response = request.body(user).post("/");
    }

    private void deleteUser(String username) {
        given()
                .header("Content-Type", "application/json")
                .pathParam("username", username)
                .delete("/{username}").then().statusCode(200);
    }

    @Test
    public void testName() {
        String currentUsername = this.user.getUsername();
        User user = getUser(currentUsername);
        assertEquals(this.user, user, "User from server differs from created one.");

        user.setEmail("newEmail@wiley.com");
        user.setPhone("+1(123)964234");
        user.setPassword("newPass");
        updateUser(user);
        User updatedUser = getUser(user.getUsername());
        assertEquals(updatedUser, user);
    }

    @AfterTest
    private void afterTest() {
        deleteUser(this.user.getUsername());
    }

}

// It could be created by Builder pattern, but... in future.
class User {
    private long id = 0;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus = 0;


    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserStatus() {
        return userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userStatus == user.userStatus && username.equals(user.username) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && email.equals(user.email) && password.equals(user.password) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, lastName, email, password, phone, userStatus);
    }
}
