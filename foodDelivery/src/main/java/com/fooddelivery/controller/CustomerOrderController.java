package com.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.service.OrderService;
import com.fooddelivery.model.Customer;
import com.fooddelivery.model.Order;
import com.fooddelivery.service.CustomerService;

@RestController
@RequestMapping("/foodDelivery")
public class CustomerOrderController {
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("addCustomer")
	public Customer addCustomer(@RequestBody Customer cust) {
		 Customer addCustomer = customerservice.addCustomer(cust);
		return addCustomer;
		
		
	}
	
	@PostMapping("addCustomers")
	public ResponseEntity<Void> saveCustomers(@RequestBody List<Customer> cust) {
		 customerservice.saveCustomers(cust);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		
	}
	@GetMapping("getAllCustomers")
	private List<Customer>getAllCustomer()
	{
		List<Customer> list = customerservice.getAllCustomer();
		return list;
		
	}
	@GetMapping("getCustomerById/{id}")
	private Customer getCustomerById(@PathVariable("id") long id )
	{
		return customerservice.getCustomerById(id);
	}
	@PutMapping("updateCustomer")
	private Customer updateCustomer(@RequestBody Customer customer) {
		Customer updateCustomer = customerservice.updateCustomer(customer);
		return updateCustomer;
	}
	@DeleteMapping("deleteCustomer/{id}")
	private void deleteCustomer(@PathVariable Long id) {
		customerservice.deleteCustomer(id);
	}

	@PostMapping("addOrder")
	public Order placeOrder(@RequestBody Order order) {
		Order placeOrder = orderservice.placeOrder(order);
		return placeOrder;
	}
	@PostMapping("addOrders")
	public ResponseEntity<Void> saveOrders(@RequestBody List<Order> order) {
		 orderservice.saveOrders(order);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("getAllOrders")
	private List<Order>getAllOrder(){
		List<Order> list=orderservice.getAllOrder();
		return list;
	}
	
	@GetMapping("getOrderById/{id}")
	private Order getOrderById(@PathVariable("id") long id) {
		return orderservice.getOrderById(id);
		
	}
	@PutMapping("updateOrder")
	private Order updateOrder(@RequestBody Order order) {
		Order updateOrder = orderservice.updateOrder(order);
		return updateOrder;
		
	}
	
	@DeleteMapping("deleteOrder/{id}")
	private void deleteOrder(@PathVariable ("id") long id) {
		orderservice.deleteOrder(id);
		
	}
	
}
