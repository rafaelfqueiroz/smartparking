package com.smartparking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.CarParking;

@Repository
public interface CarParkingReposiiitory extends CrudRepository<CarParking, Integer> {

}