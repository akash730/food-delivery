package com.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.model.Customer;

@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer getCustomerById(Long Id);
	public List<Customer> getAllCustomer();
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(Long Id);
	public void saveCustomers(List<Customer> cust);
	

}
