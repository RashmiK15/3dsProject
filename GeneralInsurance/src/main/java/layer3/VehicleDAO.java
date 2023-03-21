package layer3;

import layer2.Vehicle;

import java.util.List;

import layer2.Vehicle;

public interface VehicleDAO { //Vehicle Repository

	Vehicle selectVehicle(String rcNumber);
	List<Vehicle> selectAllVehicles();
	
	void insertVehicle(Vehicle vehicle);
	void updateVehicle(Vehicle vehicle);
	void deleteVehicle(String rcNumber);
	
}