package com.tcs.demo3springdatajpa.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurant {
    private String restauid;
    private String name;
    private String location;
    private String about;
}

