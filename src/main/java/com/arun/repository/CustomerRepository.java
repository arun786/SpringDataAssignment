package com.arun.repository;

import org.springframework.data.repository.CrudRepository;

import com.arun.model.CustomerData;

public interface CustomerRepository extends CrudRepository<CustomerData, Long> {
}
