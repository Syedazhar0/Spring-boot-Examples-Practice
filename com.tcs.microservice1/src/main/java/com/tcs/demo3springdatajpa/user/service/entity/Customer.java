package com.tcs.demo3springdatajpa.user.service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customer1")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {
    
    @Id
    @Column(name = "custid")
    private String custid;
    
    private String custname;
    private String email;
    private String about;
    
    // @Transient annotation is used to avoid storing the data of the ratings in the database 
    // because we have a separate microservice for ratings and a separate database from which we will retrieve the data
    @Transient
    private List<CustomerRating> ratings = new ArrayList<>();
}
