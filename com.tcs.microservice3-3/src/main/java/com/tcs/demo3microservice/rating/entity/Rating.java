package com.tcs.demo3microservice.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ratings")
public class Rating {

	 @Id
	    private String ratingId;
	    private String restauid;
	    private String custid;
	    private int rating;
	    private String comments;
}
