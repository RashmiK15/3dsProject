package layer2;

import java.sql.Date;

public class InsuranceIssued
{
	private int policyId;
	private Date startDate;
	private Date expiryDate;
	private int insuranceTypeId;
	
	public int getPolicyId()
	{
		return policyId;
	}
	public void setPolicyId(int policyId) 
	{
		this.policyId = policyId;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	public Date getExpiryDate() 
	{
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate)
	{
		this.expiryDate = expiryDate;
	}
	public int getInsuranceTypeId() 
	{
		return insuranceTypeId;
	}
	public void setInsuranceTypeId(int insuranceTypeId) 
	{
		this.insuranceTypeId = insuranceTypeId;
	}
	
	@Override
	public String toString()
	{
		return "InsuranceIssued [policyId=" + policyId + ", startDate=" + startDate + ", expiryDate=" + expiryDate
				+ ", insuranceTypeId=" + insuranceTypeId + "]";
	}
	
	 
	
	 
	
	
}
