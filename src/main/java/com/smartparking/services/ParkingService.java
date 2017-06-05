package com.smartparking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartparking.domain.ParkingLot;
import com.smartparking.enums.StateTypes;
import com.smartparking.repositories.ParkingLotRepository;

@Service
public class ParkingService extends CrudService<ParkingLot>{

	@Autowired
	private ParkingLotRepository parkingLotRepository;
	
	@Override
	public List<ParkingLot> getAll() {
		return parkingLotRepository.findAllByActiveTrueOrderByNumber();
	}

	public ParkingLot createParkingLot() {
		ParkingLot lot = parkingLotRepository.findTopByActiveTrueOrderByNumberDesc();
		ParkingLot newest = new ParkingLot();
		if (lot == null) {
			newest.setNumber(1);
		} else {
			newest.setNumber(lot.getNumber() + 1);
		}
		newest.setState(StateTypes.FREE.ordinal());
		newest.setActive(true);
		parkingLotRepository.save(newest);
		return newest;
	}
}
