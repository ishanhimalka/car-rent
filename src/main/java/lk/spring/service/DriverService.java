package lk.spring.service;

import lk.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);

    void updateDriver(DriverDTO dto);

    DriverDTO searchDriver(String driverId);

    void deleteDriver(String driverId);

    List<DriverDTO> getAllDrivers();
}
