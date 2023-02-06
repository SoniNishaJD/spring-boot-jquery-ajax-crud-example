package com.CustomerAjaxCrud.service;

import java.util.List;

import com.CustomerAjaxCrud.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomerList();

	void saveOrUpdateCustomer(Customer customer);

	Customer getCustomerById(Integer id);

	void deleteCustomerById(Integer id);

}
