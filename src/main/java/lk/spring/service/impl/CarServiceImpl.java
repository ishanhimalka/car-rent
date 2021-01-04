package lk.spring.service.impl;
import lk.spring.dto.CarDTO;
import lk.spring.entity.Car;
import lk.spring.repo.CarRepo;
import lk.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CarRepo repo;

    @Override
    public void saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getCarNumber())) {
            repo.save(modelMapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("This Car is already Exist!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (repo.existsById(dto.getCarNumber())) {
            repo.save(modelMapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("Car Not Found!");
        }
    }

    @Override
    public CarDTO searchCar(String carNumber) {
        Optional<Car> car = repo.findById(carNumber);
        if (car.isPresent()) {
            return modelMapper.map(car.get(), CarDTO.class);
        } else {
            throw new RuntimeException("Car does not exist!");
        }
    }

    @Override
    public void deleteCar(String carNumber) {
        if (repo.existsById(carNumber)) {
            repo.deleteById(carNumber);
        } else {
            throw new RuntimeException("Couldn't to delete Car!");
        }
        System.out.println(carNumber);
    }

    @Override
    public List<CarDTO> getAllCars() {
        return modelMapper.map(repo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }
}
