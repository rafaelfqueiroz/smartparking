package com.smartparking.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartparking.domain.ParkingLot;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> {

	List<ParkingLot> findByState(Boolean state);

	ParkingLot findByNumber(Integer number);
	
	

}
