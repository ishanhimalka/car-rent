package lk.spring.service;

import lk.spring.dto.CarRentalDTO;

import java.util.List;

public interface CarRentalService {
    void saveCar(CarRentalDTO dto);

    void updateCar(CarRentalDTO dto);

    CarRentalDTO searchCar(String carNumber);

    void deleteCar(String carNumber);

    List<CarRentalDTO> getAllCars();
}
