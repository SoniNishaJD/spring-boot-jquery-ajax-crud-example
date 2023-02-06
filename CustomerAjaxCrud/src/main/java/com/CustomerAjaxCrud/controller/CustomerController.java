package com.CustomerAjaxCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerAjaxCrud.model.Customer;
import com.CustomerAjaxCrud.service.CustomerService;


@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	
	@GetMapping("/customerList")
	public ResponseEntity<List<Customer>>getAllCustomer() {
		return new ResponseEntity<List<Customer>>(service.getAllCustomerList(),HttpStatus.OK);
	}
	
	@PostMapping("/customer/save")
	public ResponseEntity<Void> saveOrUpdateCustomer(@RequestBody Customer customer) {
		service.saveOrUpdateCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer Id) {
		return new ResponseEntity<Customer>(service.getCustomerById(Id), HttpStatus.OK);
	}

	@DeleteMapping("/customer/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id) {
		service.deleteCustomerById(id);
		return new ResponseEntity<String>("Customer deleted successfully", HttpStatus.OK);
	}


}
