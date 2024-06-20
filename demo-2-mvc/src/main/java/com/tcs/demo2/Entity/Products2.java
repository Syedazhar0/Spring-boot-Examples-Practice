package com.tcs.demo2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product2")
public class Products2 {

    @Id
    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String pname;

    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "Price must be a positive or zero value")
    private Integer price; 

    @NotBlank(message = "Product brand cannot be blank")
    @Size(min = 2, max = 50, message = "Product brand must be between 2 and 50 characters")
    private String pbrand;
}
