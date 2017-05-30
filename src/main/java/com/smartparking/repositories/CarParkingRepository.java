package com.smartparking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.CarParking;

@Repository
public interface CarParkingRepository extends CrudRepository<CarParking, Integer> {

	CarParking findByTagValue(String tagValue);

}
