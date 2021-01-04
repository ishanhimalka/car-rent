package lk.spring.service;

import lk.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);

    void updateCar(CarDTO dto);

    CarDTO searchCar(String carNumber);

    void deleteCar(String carNumber);

    List<CarDTO> getAllCars();
}
