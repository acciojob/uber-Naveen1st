package com.driver.controllers;

import com.driver.model.Customer;
import com.driver.model.TripBooking;
import com.driver.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/driver")
public class DriverController {

	private DriverController customerService;

	@PostMapping(value = "/register")
	public ResponseEntity<Void> registerDriver(@RequestParam String mobile, @RequestParam String password){
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public void deleteCustomer(@RequestParam Integer customerId){
		customerService.deleteCustomer(customerId);
	}

	@PostMapping("/bookTrip")
	public ResponseEntity<Integer> bookTrip(@RequestParam Integer customerId, @RequestParam String fromLocation, @RequestParam String toLocation, @RequestParam Integer distanceInKm) throws Exception {
		ResponseEntity<Integer> bookedTrip=customerService.bookTrip(customerId,fromLocation,toLocation,distanceInKm);

		return new ResponseEntity<>(bookedTrip.getBody(), HttpStatus.CREATED);
	}

	@DeleteMapping("/complete")
	public void completeTrip(@RequestParam Integer tripId){
		DriverController customerService = null;
		customerService.deleteCustomer(tripId);
	}

	@DeleteMapping("/cancelTrip")
	public void cancelTrip(@RequestParam Integer tripId){

		DriverController customerService = new DriverController();
		customerService.cancelTrip(tripId);
	}
}