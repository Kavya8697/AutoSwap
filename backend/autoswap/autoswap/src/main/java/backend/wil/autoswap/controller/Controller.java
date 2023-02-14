package backend.wil.autoswap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.wil.autoswap.entity.Car;
import backend.wil.autoswap.entity.Customer;
import backend.wil.autoswap.entity.Media;
import backend.wil.autoswap.repository.CarRepo;
import backend.wil.autoswap.repository.CustomerRepo;
import backend.wil.autoswap.repository.MediaRepo;
import backend.wil.autoswap.response.ErrorResponse;
import backend.wil.autoswap.response.UpdatePassword;
import backend.wil.autoswap.service.CustomerService;

@RestController
@RequestMapping("/customerapi")
public class Controller {
	
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;
    
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private MediaRepo mediaRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getcustomers")
	public List<Customer> getCustomers() {
		
		return customerRepo.findAll();
		
	}
	
	@GetMapping("/getmedias")
	public List<Media> getMedias() {
		
		return mediaRepo.findAll();
		
	}
	
	
	@GetMapping("/getcars")
	public List<Car> getCars() {
		
		return carRepo.findAll();
		
	}
	
	@PostMapping("/createcustomer")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		
		Customer customerCreated = customerService.createCustomer(customer);
		
		if(customerCreated==null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorMessage("Bad Request");
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(customerCreated, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity getCustomerId(@PathVariable Long id) {
		Customer customer = customerService.getPersonById(id);
		
		if(customer==null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorMessage("Customer not found");
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}

		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PutMapping("/updatePassword/{id}")
	public ResponseEntity updatePassword(@PathVariable long id,@RequestBody UpdatePassword updatePassword) {
		Customer customer = customerService.getPersonById(id);
		
		
		if(customer==null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorMessage("Bad");
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		
		int updateInt = customerService.updatePassword(customer, updatePassword);
		
		if(updateInt==-1) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorMessage("Old password doesn't match");
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		customer = customerService.getPersonById(id);
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
