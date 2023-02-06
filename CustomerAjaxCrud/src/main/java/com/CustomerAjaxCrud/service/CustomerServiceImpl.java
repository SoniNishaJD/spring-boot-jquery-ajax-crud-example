package com.CustomerAjaxCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerAjaxCrud.Repository.CustomerRepository;
import com.CustomerAjaxCrud.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repository;

	@Override
	public List<Customer> getAllCustomerList() {
		return repository.findAll();

	}

	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		 repository.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		Optional<Customer> optional=repository.findById(id);
		Customer customer = null;
		if(optional.isPresent()) {
			customer=optional.get();
		}else {
			throw new RuntimeException("Customer not Found for id:: "+id);
		}
		return customer;
	
	}
	
	@Override
	public void deleteCustomerById(Integer id) {
		repository.findById(id);
		repository.deleteById(id);
	}


}
