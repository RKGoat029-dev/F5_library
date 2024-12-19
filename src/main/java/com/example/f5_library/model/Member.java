
package com.example.f5_library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "members" )
@NoArgsConstructor @Getter @Setter
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

}