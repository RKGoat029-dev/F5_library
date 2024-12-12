
package com.example.f5_library.model;

import jakarta.persistence.*;

@Entity
@Table( name = "users" )
public class User {

    // ID - Auto Incremental
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    // DNI
    private String dni;

    // USER TAG
    private String userTag;

    // FIRST NAME
    private String firstName;

    // LAST NAME
    private String lastName;

    // USER EMAIL
    private String userEmail;

    // USER PHONE NUMBER
    private String userPhone;

    /* CONSTRUCTORS */

    public User(String dni, String userTag, String firstName, String lastName, String userEmail, String userPhone) {
        this.dni = dni;
        this.userTag = userTag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

    public User() {}

    /* GETTERS & SETTERS */

    // ID - Auto Incremental
    public long getId() { return id; }
    public void setId(int id) { this.id = id; }

    // DNI
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    // USERTAG
    public String getUserTag() { return userTag; }
    public void setUserTag(String userTag) { this.userTag = userTag; }

    // FIRST NAME
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    // LAST NAME
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    // EMAIL
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    // PHONE NUMBER
    public String getUserPhone() { return userPhone; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }
}