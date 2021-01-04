package lk.spring.service.impl;

import lk.spring.dto.CarRentalDTO;
import lk.spring.entity.CarRental;
import lk.spring.repo.CarRentalRepo;
import lk.spring.repo.CarRepo;
import lk.spring.service.CarRentalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarRentalServiceimpl implements CarRentalService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CarRentalRepo carRentalRepo;

    @Autowired
    CarRepo carRepo;

    @Override
    public void saveCar(CarRentalDTO dto) {
        if (!carRentalRepo.existsById(dto.getCarNumber())) {
            carRentalRepo.save(modelMapper.map(dto, CarRental.class));
        } else {
            throw new RuntimeException("This Car  is already Exist!");
        }
    }

    @Override
    public void updateCar(CarRentalDTO dto) {
        if (carRentalRepo.existsById(dto.getCarNumber())) {
            carRentalRepo.save(modelMapper.map(dto, CarRental.class));
        } else {
            throw new RuntimeException("Car Not Found!");
        }
    }

    @Override
    public CarRentalDTO searchCar(String carNumber) {
        Optional<CarRental> carrental = carRentalRepo.findById(carNumber);
        if (carrental.isPresent()) {
            return modelMapper.map(carrental.get(), CarRentalDTO.class);
        } else {
            throw new RuntimeException("Car does not exist!");
        }
    }

    @Override
    public void deleteCar(String carNumber) {
        if (carRentalRepo.existsById(carNumber)) {
            carRentalRepo.deleteById(carNumber);
        } else {
            throw new RuntimeException("Couldn't to Delete Car!");
        }
    }

    @Override
    public List<CarRentalDTO> getAllCars() {
        return modelMapper.map(carRentalRepo.findAll(), new TypeToken<List<CarRentalDTO>>() {
        }.getType());
    }
}
