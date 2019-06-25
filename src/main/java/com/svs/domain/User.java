package com.svs.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    private String firstName;
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
    @NotBlank(message = "This field is required")
    private String nameOfStock;
    @NotBlank(message = "This field is required")
    private String weight;
    @Max(40)
    @Min(1)
    private int placeOfStorage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_At;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNameOfStock() {
        return nameOfStock;
    }

    public void setNameOfStock(String nameOfStock) {
        this.nameOfStock = nameOfStock;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPlaceOfStorage() {
        return placeOfStorage;
    }

    public void setPlaceOfStorage(int placeOfStorage) {
        this.placeOfStorage = placeOfStorage;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

}

