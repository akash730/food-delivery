package com.fooddelivery.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.model.Order;
import com.fooddelivery.repository.OrderRepository;
import com.fooddelivery.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderrepo;

	@Override
	public Order placeOrder(Order order) {
		Order save = orderrepo.save(order);
		return save;
	}

	@Override
	public Order getOrderById(Long Id) {
		
		return orderrepo.findById(Id).get();
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> list = new ArrayList<Order> ();
		orderrepo.findAll().forEach(Order -> list.add(Order));
		return list;
	}
	@Override
	public Order updateOrder(Order order) {
		Order save = orderrepo.save(order);
		return save;
	}

	@Override
	public void deleteOrder(Long id) {
		orderrepo.deleteById(id);
		
	}

	@Override
	public void saveOrders(List<Order> order) {
		List<Order> list= new ArrayList<Order>();
		for(Order ord: order) {
			list.add(ord);
		}
		orderrepo.saveAll(list);
		
	}

}
