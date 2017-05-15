package com.smartparking.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.smartparking.domain.ParkingLot;
import com.smartparking.enums.StateTypes;

@Service
public class ParkingService {

	private List<ParkingLot> vacancies;

	public ParkingService() {
		this.vacancies = Arrays.asList(
				new ParkingLot[]{
					new ParkingLot(1, StateTypes.FREE.ordinal()),
					new ParkingLot(2, StateTypes.FREE.ordinal()),
					new ParkingLot(3, StateTypes.FREE.ordinal()),
					new ParkingLot(4, StateTypes.FREE.ordinal()),
					new ParkingLot(5, StateTypes.FREE.ordinal())
				});
	}

	public ParkingLot occupyParkingLot(ParkingLot parkingLot) {
		ParkingLot newState = vacancies.stream().filter(v -> v.equals(parkingLot))
						  			.map(v -> {
						  				v.setState(parkingLot.getState());
						  				return v;
						  			}).findFirst().get();
		return newState;
	}
	
	public ParkingLot getFreeParkingLot() throws Exception {
		Optional<ParkingLot> opt = vacancies.stream()
											.filter(v -> v.getState().equals(Boolean.FALSE))
											.findAny();
		if (!opt.isPresent()) {
			throw new Exception("Não há vagas disponíveis");
		}
		return opt.get();
	}

	public List<ParkingLot> getParkingLots() {
		return this.vacancies;
	}
	
}
