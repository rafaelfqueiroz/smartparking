package com.smartparking;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smartparking.domain.ParkingLot;

@Service
public class ParkingService {

	private List<ParkingLot> vacancies;

	public ParkingService() {
		this.vacancies = Arrays.asList(
				new ParkingLot[]{
					new ParkingLot(1, false),
					new ParkingLot(2, false),
					new ParkingLot(3, false),
					new ParkingLot(4, false),
					new ParkingLot(5, false)
				});
	}

	public boolean occupyParkingLot(ParkingLot parkingLot) {
		Boolean newState = vacancies.stream().filter(v -> v.equals(parkingLot))
						  			.map(v -> {
						  				v.setState(parkingLot.getState());
						  				return v.getState();
						  			}).findFirst().get();
		return newState;
	}
	
	public ParkingLot getFreeParkingLot() {
		return vacancies.stream()
				.filter(v -> v.getState().equals(Boolean.TRUE))
				.findFirst().get();
	}
	
}
