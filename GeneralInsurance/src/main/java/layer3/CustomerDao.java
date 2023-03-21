//POJI
package layer3;

import java.util.List;

import layer2.Customer;

public interface CustomerDao {

	void addCustomer(Customer c);
	List<Customer> getCustomer();
	Customer getCustomer(int cno);
	void updateCustomer(Customer cno);
	void deleteCustomer(int cno);

}

//package com.java.layer3;
//
//import java.util.List;
//
//import com.java.layer2.Currency;
//
//public interface CurrencyDao {
//
//		void addCurrency(Currency e);    //C-create
//		List<Currency> getCurrency();   //R-read/all
//		Currency getCurrency(int empno); //R-read/single
//		void updateCurrency(Currency e); //U-Update
//		void deleteCurrency(int empno);  //D-delete
//		
//
//}