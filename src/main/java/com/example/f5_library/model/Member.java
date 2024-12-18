
package com.example.f5_library.model;

import jakarta.persistence.*;

@Entity
@Table( name = "members" )
public class Member {

    // ID - Auto Incremental
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    // DNI
    private String dni;

    // USER TAG
    private String memberTag;

    // FIRST NAME
    private String firstName;

    // LAST NAME
    private String lastName;

    // USER EMAIL
    private String memberEmail;

    // USER PHONE NUMBER
    private String memberPhone;

    /* CONSTRUCTORS */

    public Member(
            String dni,
            String memberTag,
            String firstName,
            String lastName,
            String memberEmail,
            String memberPhone
    ) {
        this.dni = dni;
        this.memberTag = memberTag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
    }

    public Member() {}

    /* GETTERS & SETTERS */

    // ID - Auto Incremental
    public long getId() { return id; }
    public void setId(int id) { this.id = id; }

    // DNI
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    // TAG
    public String getMemberTag() { return memberTag; }
    public void setMemberTag(String memberTag) { this.memberTag = memberTag; }

    // FIRST NAME
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    // LAST NAME
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    // EMAIL
    public String getMemberEmail() { return memberEmail; }
    public void setMemberEmail(String memberEmail) { this.memberEmail = memberEmail; }

    // PHONE NUMBER
    public String getMemberPhone() { return memberPhone; }
    public void setMemberPhone(String memberPhone) { this.memberPhone = memberPhone; }
}