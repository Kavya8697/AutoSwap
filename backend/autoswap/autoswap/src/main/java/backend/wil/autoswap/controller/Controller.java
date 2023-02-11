package backend.wil.autoswap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.wil.autoswap.entity.Car;
import backend.wil.autoswap.entity.Customer;
import backend.wil.autoswap.entity.Media;
import backend.wil.autoswap.repository.CarRepo;
import backend.wil.autoswap.repository.CustomerRepo;
import backend.wil.autoswap.repository.MediaRepo;

@RestController
@RequestMapping("/customerapi")
public class Controller {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private MediaRepo mediaRepo;
	
	@GetMapping("/getcustomer")
	public List<Customer> getCustomers() {
		
		return customerRepo.findAll();
		
	}
	
	@GetMapping("/getmedia")
	public List<Media> getMedias() {
		
		return mediaRepo.findAll();
		
	}
	
	
	@GetMapping("/getcars")
	public List<Car> getCars() {
		
		return carRepo.findAll();
		
	}

}
