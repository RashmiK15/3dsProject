package layer3;

import java.util.List;

import layer2.InsuranceIssued;

public interface InsuranceIssuedDAO
{
	  InsuranceIssued selectInsuranceIssued(int policyId);
		 
	  List<InsuranceIssued> selectAllInsuranceIssued();
	
	  void insertInsuranceIssued(InsuranceIssued insuranceIssued);
	  void updateInsuranceIssued(InsuranceIssued insuranceIssued);
	  void deleteInsuranceIssued(int policyId);

 
	  
}
