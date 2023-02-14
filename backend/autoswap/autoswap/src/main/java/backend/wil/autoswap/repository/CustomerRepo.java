package backend.wil.autoswap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.wil.autoswap.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

	Customer findByCustomerId(Long id);
	
	
    @Modifying
    @Query("UPDATE Customer c SET c.passwordVal = :passwordVal WHERE c.id = :customerId")
    int updatePasswd(@Param("customerId") Long customerId, @Param("passwordVal") String passwordVal);
    
    @Modifying
    @Query("UPDATE Customer c SET c.userName = :userName WHERE c.id = :customerId")
    int updateUserName(@Param("customerId") Long customerId, @Param("userName") String userName);

    
    

}
