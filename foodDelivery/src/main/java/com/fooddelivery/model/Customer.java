package com.fooddelivery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO,generator="sequence")
	 * 
	 * @SequenceGenerator(name = "sequence") private Long custId;
	 */
	@Column
	@JsonProperty("custId")
	@NotBlank
	@Size(max=10,min = 1,message = "Customer id should not be greater then 10 ")
	private String custId;
@NotNull
private String firstName;
@NotNull
private String lastName;
@NotNull
@Size(min=10,max=10,message="Just Enter ten digit Mobile no ")
private String mobileNo;

@OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.ALL)
private List<Order> order;


}
