package layer2;

import java.sql.Date;

public class Vehicle { //layer 2 POJO
	
	private String rcNumber;
	private int chasisNumber;
	private Date dateOfPurchase;
	private String manufacturer;
	private String engineNumber;
	private String vehicleModel;
	private float cost;
	
	public Vehicle() {
		System.out.println("Vehicle ctor()...");
	}

	public String getRcNumber() {
		return rcNumber;
	}

	public void setRcNumber(String rcNumber) {
		this.rcNumber = rcNumber;
	}

	public int getChasisNumber() {
		return chasisNumber;
	}

	public void setChasisNumber(int chasisNumber) {
		this.chasisNumber = chasisNumber;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date date) {
		this.dateOfPurchase = date;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Vehicle [rcNumber=" + rcNumber + ", chasisNumber=" + chasisNumber + ", dateOfPurchase=" + dateOfPurchase
				+ ", manufacturer=" + manufacturer + ", engineNumber=" + engineNumber + ", vehicleModel=" + vehicleModel
				+ ", cost=" + cost + "]";
	}
	
	

}
