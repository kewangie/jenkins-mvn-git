package com.ke.test.lambda.supplier;

import java.util.function.Supplier;

public class SupplierDemo {
	public static String driveVehicle(Supplier<? extends Vehicle> supplier) {
		Vehicle vehicle = supplier.get();
		return vehicle.drive();
	}

}
