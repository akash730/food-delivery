package com.fooddelivery.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fooddelivery.model.Customer;
import com.fooddelivery.repository.CustomerRepository;
import com.fooddelivery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository custrepo;
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer save = custrepo.save(customer);
	return save;
	}

	@Override
	public Customer getCustomerById(Long Id) {
		
		
		return custrepo.findById(Id).get();
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> cust=new ArrayList<Customer>();
		custrepo.findAll().forEach(Customer ->cust.add(Customer));
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer save = custrepo.save(customer);
		return save;
	}

	@Override
	public void deleteCustomer(Long Id) {
		custrepo.deleteById(Id);
		
	}
@Transactional
@Override
	public void saveCustomers(List<Customer> cust) {
		int size= cust.size();
		//int count=0;
		List<Customer> list=new ArrayList<>();
		for(Customer cus : cust) {
			list.add(cus);
			
		}
		custrepo.saveAll(list);
		//count++;
		
	}




}
