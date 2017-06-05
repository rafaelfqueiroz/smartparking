package com.smartparking.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartparking.domain.Car;
import com.smartparking.notifiers.Notifier;
import com.smartparking.vo.CarVO;
import com.smartparking.vo.ParkingLotVO;

/**
 * @author Rafael Queiroz
 */
@RestController
@RequestMapping(value="/entrance")
public class EntranceRestController {
	
	private List<String> log = new ArrayList<String>();
	
	@Autowired
	private Notifier notifier;
	
	/**
	 * Notify a car has came to the parking. Returns the parking lot chosen and notify 
	 * any component of the IoT system about the parking lot.
	 * @param car
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/car")
	public ResponseEntity<ParkingLotVO> entrance(@RequestBody CarVO car) {
		//notifies when a cars comes
		try {
			notifier.notify(new Car(car.getTagValue()));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/logs")
	public ResponseEntity<List<String>> getLogs() {
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
}
