package com.ke.test.lambda.supllier;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.ke.test.lambda.supplier.Car;
import com.ke.test.lambda.supplier.SupplierDemo;
import com.ke.test.lambda.supplier.Vehicle;

public class VechicleTest {

	@Test
	public void vehicleTest() {
		// Using Lambda expression
		assertThat(SupplierDemo.driveVehicle(() -> new Vehicle()), is("Driving vehicle ..."));
		assertThat(SupplierDemo.driveVehicle(() -> new Car()), is("Driving car..."));

		// Using method expression
		assertThat(SupplierDemo.driveVehicle(Vehicle::new), is("Driving vehicle ..."));
		assertThat(SupplierDemo.driveVehicle(Car::new), is("Driving car..."));
	}
}
