package com.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fooddelivery.model.Customer;
import com.fooddelivery.model.Order;

@Service
public interface OrderService{
	
	public Order placeOrder(Order order);
	
	public Order getOrderById(Long Id);
	public List<Order> getAllOrder();
	public Order updateOrder(Order order);
	public void deleteOrder(Long Id);

	public void saveOrders(List<Order> order);

}