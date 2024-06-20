package com.tcs.demo3springdatajpa.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRating {
    private String ratingId;
    private String custid;
    private String restauid;
    private int rating;
    private String comments;
    private Restaurant restaurant; // Updated to include Restaurant object
}


