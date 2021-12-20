package models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Users {

    private Integer usersId;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String userRole;

    public Users() {
    }

    public Users(Integer usersId, String userRole) {
        this.usersId = usersId;
        this.userRole =userRole;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users(Integer usersId, String username, String password) {
        this.usersId = usersId;
        this.username = username;
        this.password = password;
    }

    public Users(Integer usersId, String username, String password, String firstName,
                 String lastName, String email, String userRole) {
        this.usersId = usersId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(usersId, users.usersId) && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(userRole, users.userRole);
    }

    @Override
    public String toString() {
        return "Users{" +
                "usersId=" + usersId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
