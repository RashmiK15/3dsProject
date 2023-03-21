package layer2;

import java.sql.Date;

public class Fir {
	private int firId;
	private String caseDescription;
	private Date filedDate;

	public Fir(int firId, String caseDescription, Date filedDate) {
		super();
		this.firId = firId;
		this.caseDescription = caseDescription;
		this.filedDate = filedDate;
	}

	public Fir() {
		
	}

	public int getFirId() {
		return firId;
	}

	public void setFirId(int firId) {
		this.firId = firId;
	}

	public String getCaseDescription() {
		return caseDescription;
	}

	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}

	public Date getFiledDate() {
		return filedDate;
	}

	public void setFiledDate(Date filedDate) {
		this.filedDate = filedDate;
	}

	@Override
	public String toString() {
		return "Fir [firId=" + firId + ", caseDescription=" + caseDescription + ", filedDate=" + filedDate + "]";
	}

}