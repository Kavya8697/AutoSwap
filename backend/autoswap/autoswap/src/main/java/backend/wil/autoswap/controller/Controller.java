package backend.wil.autoswap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.wil.autoswap.entity.Car;
import backend.wil.autoswap.entity.Customer;
import backend.wil.autoswap.entity.Media;
import backend.wil.autoswap.error.ErrorResponse;
import backend.wil.autoswap.repository.CarRepo;
import backend.wil.autoswap.repository.CustomerRepo;
import backend.wil.autoswap.repository.MediaRepo;
import backend.wil.autoswap.service.CustomerService;

@RestController
@RequestMapping("/customerapi")
public class Controller {
	
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
	
	
	@GetMapping("/getcustomer/{id}")
	public ResponseEntity getCustomerId(@PathVariable Long id) {
		Customer customer = customerService.getPersonById(id);
		
		if(customer==null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorMessage("Bad");
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		}
		System.out.println(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
