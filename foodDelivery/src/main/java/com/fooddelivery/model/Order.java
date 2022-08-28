package com.fooddelivery.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Value;
@Data
@Entity
@Table(name="OrderData")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@NotEmpty
	@NotNull
	private String itemName;
	@NotNull
	@Min(value=1, message = "need At least One quantity")
	private Integer quantity;
	@NotNull
	@Min(value=50, message = "ordercan be greater than Fifty rupays")
	private double price;
	@AssertTrue
	@Column(columnDefinition="BOOLEAN DEFAULT false")
	private boolean deliveryStatus=true;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer customer;
}
