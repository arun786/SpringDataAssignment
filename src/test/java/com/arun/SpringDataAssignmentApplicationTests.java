package com.arun;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.arun.model.CustomerData;
import com.arun.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataAssignmentApplicationTests {
	@Autowired
	private CustomerRepository customerRepository;

	CustomerData customerData;

	@Before
	public void setUp() {
		customerData = new CustomerData("Alex", "alex@gmail.com");
	}

	@Test
	public void testCreateCustomer() {
		customerRepository.save(customerData);
	}

	@Test
	public void testFindACustomer() {
		Optional<CustomerData> response = customerRepository.findById(1l);
		assertEquals(response.get().getName(), customerData.getName());
	}

	@Test
	public void testUpdateACustomer() {
		Optional<CustomerData> response = customerRepository.findById(1l);
		response.get().setEmail("alex1@gmail.com");
		customerRepository.save(response.get());
		Optional<CustomerData> newResponse = customerRepository.findById(1l);
		assertEquals(newResponse.get().getEmail(), "alex1@gmail.com");
	}
	
	@Test
	public void testDeleteACustomer(){
		customerRepository.deleteById(1l);
		Optional<CustomerData> response = customerRepository.findById(1l);
		assertTrue(!response.isPresent());
	}

}
