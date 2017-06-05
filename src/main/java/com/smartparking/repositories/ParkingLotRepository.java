package com.smartparking.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smartparking.domain.ParkingLot;

@Repository
public interface ParkingLotRepository extends SmartParkingRepository<ParkingLot> {

	ParkingLot findFirstByState(Integer state);

	ParkingLot findByNumber(Integer number);

	List<ParkingLot> findAllByActiveTrueOrderByNumber();

	ParkingLot findTopByActiveTrueOrderByNumberDesc();
	
}
