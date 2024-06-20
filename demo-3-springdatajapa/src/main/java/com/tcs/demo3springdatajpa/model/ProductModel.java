package com.tcs.demo3springdatajpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel {
    private String pname;
    private Integer price;
    private String pbrand;
    private String image;

}
