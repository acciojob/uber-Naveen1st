

package com.driver.services.impl;

import com.driver.model.Cab;
import com.driver.repository.CabRepository;
import com.driver.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Driver;
import com.driver.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository3;

	@Autowired
	CabRepository cabRepository3;

	@Override
	public void register(String mobile, String password){
		//Save a driver in the database having given details and a cab with ratePerKm as 10 and availability as True by default.
		Driver  d= new Driver(mobile,password);
		Cab c=new Cab(10);
		c.setDriver(d);
		driverRepository3.save(d);

	}

	@Override
	public void removeDriver(int driverId){
		// Delete driver without using deleteById function
		Driver d= driverRepository3.findById(driverId).get();
		driverRepository3.delete(d);
	}

	@Override
	public void updateStatus(int driverId){
		//Set the status of respective car to unavailable
		Driver d= driverRepository3.findById(driverId).get();
		Cab c= d.getCab();
		c.setAvailable(false);
	}
}