package com.CustomerAjaxCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CustomerAjaxCrud.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
