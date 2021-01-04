package lk.spring.repo;

import lk.spring.entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentalRepo extends JpaRepository<CarRental,String> {
}
