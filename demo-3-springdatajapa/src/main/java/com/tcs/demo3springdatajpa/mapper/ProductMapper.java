package com.tcs.demo3springdatajpa.mapper;

import com.tcs.demo3springdatajpa.entity.Product3;
import com.tcs.demo3springdatajpa.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product3 toEntity(ProductModel model) {
        if (model == null) {
            return null;
        }
        Product3 product = new Product3();
        product.setPname(model.getPname());
        product.setPrice(model.getPrice());
        product.setPbrand(model.getPbrand());
        product.setImage(model.getImage());
        return product;
    }

    public static List<Product3> toEntityList(List<ProductModel> models) {
        if (models == null) {
            return null;
        }
        List<Product3> products = new ArrayList<>();
        for (ProductModel model : models) {
            Product3 product = new Product3();
            product.setPname(model.getPname());
            product.setPrice(model.getPrice());
            product.setPbrand(model.getPbrand());
            product.setImage(model.getImage());
            products.add(product);
        }
        return products;
    }
}
