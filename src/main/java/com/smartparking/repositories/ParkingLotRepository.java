package com.smartparking.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.ParkingLot;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {

	ParkingLot findFirstByState(Integer state);

	ParkingLot findByNumber(Integer number);
	
}
