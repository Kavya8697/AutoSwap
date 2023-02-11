package backend.wil.autoswap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.wil.autoswap.entity.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

}
