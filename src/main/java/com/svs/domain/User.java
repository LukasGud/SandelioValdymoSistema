package com.svs.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class User {

    public enum typeOfClient {
        REGULAR,
        LOYAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "This field is required")
    @Column(updatable = false, unique = true)
    private String fullName;
    @NotBlank(message = "This field is required")
    @Column(updatable = false, unique = true)
    private String lastName;
    @NotNull(message = "Please enter your birth year")
    @Column(updatable = false, unique = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthYear;
    @NotBlank(message = "This field is required")
    private String phoneNumber;
    private typeOfClient type;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouseId;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public typeOfClient getType() {
        return type;
    }

    public void setType(typeOfClient type) {
        this.type = type;
    }

}
