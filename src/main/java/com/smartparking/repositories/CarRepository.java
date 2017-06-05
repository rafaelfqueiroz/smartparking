package com.smartparking.repositories;

import org.springframework.stereotype.Repository;

import com.smartparking.domain.Car;

@Repository
public interface CarRepository extends SmartParkingRepository<Car> {

	Car findByTagValue(String tagValue);

}
