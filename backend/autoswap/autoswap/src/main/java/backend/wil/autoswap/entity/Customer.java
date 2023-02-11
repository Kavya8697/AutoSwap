package backend.wil.autoswap.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	private String firstName;
	
	private String lastName;
	
	private String userName;
	
	private Boolean isBuyer;
	
	private String passwordVal;
	
	private String profileLink;
	
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customer")
    private Set<Car> carList = new HashSet<Car>();

	

	public Customer(String firstName, String lastName, String userName, Boolean isBuyer, String passwordVal,
			String profileLink) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.isBuyer = isBuyer;
		this.passwordVal = passwordVal;
		this.profileLink = profileLink;
	}




	public Long getCustomerId() {
		return customerId;
	}




	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public Boolean getIsBuyer() {
		return isBuyer;
	}




	public void setIsBuyer(Boolean isBuyer) {
		this.isBuyer = isBuyer;
	}




	public String getPasswordVal() {
		return passwordVal;
	}




	public void setPasswordVal(String passwordVal) {
		this.passwordVal = passwordVal;
	}




	public String getProfileLink() {
		return profileLink;
	}




	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}




	public Set<Car> getCarList() {
		return carList;
	}




	public void setCarList(Set<Car> carList) {
		this.carList = carList;
	}




	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", isBuyer=" + isBuyer + ", passwordVal=" + passwordVal + ", profileLink="
				+ profileLink + ", carList=" + carList + "]";
	}

	
	
	
}
