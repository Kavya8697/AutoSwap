package backend.wil.autoswap.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.wil.autoswap.entity.Customer;
import backend.wil.autoswap.repository.CustomerRepo;
import backend.wil.autoswap.response.UpdatePassword;
import org.springframework.transaction.annotation.Transactional;

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
	
	public Customer createCustomer(Customer customer){
		return customerRepo.save(customer);
	}
	
//	public Integer updatePassword(Customer customer, UpdatePassword updatePassword) {
//		MessageDigest md5 = MessageDigest.getInstance("MD5");
//		md5.update(StandardCharsets.UTF_8.encode(updatePassword.getOldPassWord()));
//		String oldPasswd =  String.format("%032x", new BigInteger(1, md5.digest()));
//		if(oldPasswd.equals(customer.getPasswordVal())) {
//			return customerRepo.updatePasswd(customer.getCustomerId(), updatePassword.getNewPassWord());
//		}else {
//			return -1;
//		}
//	}
	
	
	@Transactional(rollbackFor = { SQLException.class })
	public Integer updatePassword(Customer customer, UpdatePassword updatePassword) {
		
		if(updatePassword.getOldPassWord().equals(customer.getPasswordVal())) {
			return customerRepo.updatePasswd(customer.getCustomerId(), updatePassword.getNewPassWord());
		}else {
			return -1;
		}
	}
}
