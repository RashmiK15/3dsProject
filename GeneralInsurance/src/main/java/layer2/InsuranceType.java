package layer2;

public class InsuranceType 
{
    private int insuranceTypeId;
    private String insuranceName;
    private String insuranceDescription;
    private double insuranceCost;
      
	public int getInsuranceTypeId() 
	{
		return insuranceTypeId;
	}
	public void setInsuranceTypeId(int insuranceTypeId)
    {
		this.insuranceTypeId = insuranceTypeId;
	}
	public String getInsuranceName()
	{
		return insuranceName;
	}
	public void setInsuranceName(String insuranceName)
	{
		this.insuranceName = insuranceName;
	}
	public String getInsuranceDescription() 
	{
		return insuranceDescription;
	}
	public void setInsuranceDescription(String insuranceDescription) 
	{
		this.insuranceDescription = insuranceDescription;
	}
	public double getInsuranceCost()
	{
		return insuranceCost;
	}
	public void setInsuranceCost(double insuranceCost)
	{
		this.insuranceCost = insuranceCost;
	}
	
	@Override
	public String toString() 
	{
		return "InsuranceType [insuranceTypeId=" + insuranceTypeId + ", insuranceName=" + insuranceName
				+ ", insuranceDescription=" + insuranceDescription + ", insuranceCost=" + insuranceCost + "]";
	}
      
	
      
}
