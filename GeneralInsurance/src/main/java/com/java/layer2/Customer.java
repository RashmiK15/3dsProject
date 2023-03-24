package com.java.layer2;

import java.sql.Date;

public class Customer {

	private int customerId;
	private String customerName;
	private Date date;
	private String address;
	private String rcNumber;
	private int policyId; //foreign ref to policyissued
	private int drivingLicence;
	
	public Customer() {

		System.out.println("Customer ctr()..");
	}


	public Customer(int customerId, String customerName, Date date, String address, String rcNumber, int policyId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.date = date;
		this.address = address;
		this.rcNumber = rcNumber;
		this.policyId = policyId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRcNumber() {
		return rcNumber;
	}


	public void setRcNumber(String rcNumber) {
		this.rcNumber = rcNumber;
		//vehicle.setRcNumber(rcNumber);
	}


	public int getPolicyId() {
		return policyId;
	}


	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}


	public int getDrivingLicence() {
		return drivingLicence;
	}


	public void setDrivingLicence(int drivingLicence) {
		this.drivingLicence = drivingLicence;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", date=" + date + ", address="
				+ address + ", rcNumber=" + rcNumber + ", policyId=" + policyId + ", drivingLicence=" + drivingLicence
				+ "]";
	}
	
	
}

//customerId int not null auto_increment,
//customerName varchar(100),
//dob date,
//address varchar(100),
//rcNumber varchar(10),
//policyId int,
//primary key( customerId),
//FOREIGN KEY (rcNumber) REFERENCES Vehicle(rcNumber),
//foreign key(policyId) references InsuranceIssued(policyId)