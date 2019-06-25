package com.svs.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "This field is required")
    private String nameOfStock;
    @NotBlank(message = "This field is required")
    private int weight;
    @NotBlank(message = "This field is required")
    @Max(40)
    @Min(1)
    private int placeOfStorage;
    @NotBlank(message = "This field is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_At;
    @OneToMany(mappedBy = "warehouseId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> collectionOfWarehouse;

    public Warehouse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfStock() {
        return nameOfStock;
    }

    public void setNameOfStock(String nameOfStock) {
        this.nameOfStock = nameOfStock;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
