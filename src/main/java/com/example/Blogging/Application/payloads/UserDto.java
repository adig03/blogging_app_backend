package com.example.Blogging.Application.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

    private int id;

    @NotNull
    @Size(min = 4, message = "Username must be a minimum of 4 characters !!")
    private String name;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 15, message = "Password must be in the range of 6 to 15 characters")
    private String password;

    @NotNull(message = "About cannot be null")
    @Size(min = 20, max = 160, message = "160 words is the limit")
    private String about;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
