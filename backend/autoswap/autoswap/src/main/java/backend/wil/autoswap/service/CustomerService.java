package backend.wil.autoswap.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.wil.autoswap.entity.Customer;
import backend.wil.autoswap.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer getPersonById(Long id) {
		Optional<Customer> customer = Optional.ofNullable(customerRepo.findByCustomerId(id));
		
		if(customer.isPresent()) {
			return customer.get();
		}else {
			return null;
		}
	}
}
