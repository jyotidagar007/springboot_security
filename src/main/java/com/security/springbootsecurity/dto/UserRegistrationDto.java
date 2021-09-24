package com.security.springbootsecurity.dto;

public class UserRegistrationDto {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
   // private String role = "ROLE_ADMIN";

    public UserRegistrationDto(){

    }

    public UserRegistrationDto(String firstName, String lastName, String username, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
      //  this.role = role;
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

   // public String getRole() {
     //   return role;
   // }

   // public void setRole(String role) {
    //    this.role = role;
  //  }
}
