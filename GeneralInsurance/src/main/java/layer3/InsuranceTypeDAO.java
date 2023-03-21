package layer3;

import java.util.List;

import layer2.InsuranceType;

public interface InsuranceTypeDAO
{
	  InsuranceType selectInsuranceType(int insuranceTypeId);
		 
	  List<InsuranceType> selectAllInsuranceType();
	
	 void insertInsuranceType(InsuranceType insurancetype);
	 void updateInsuranceType(InsuranceType insurancetype);
	 void deleteInsuranceType(int insuranceTypeId);

 
	  
}
