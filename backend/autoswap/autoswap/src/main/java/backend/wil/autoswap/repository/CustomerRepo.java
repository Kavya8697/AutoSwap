package backend.wil.autoswap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import backend.wil.autoswap.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{


}
