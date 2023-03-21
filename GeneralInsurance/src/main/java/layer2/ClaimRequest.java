package layer2;

public class ClaimRequest {
	private int tokenId;
	private int policyId;
	private int fid;
	private int billId;
	private String cause;
	private String status_;
	private int customerId;
    private double amountClaimed;
    
	public ClaimRequest() {
	}

	public ClaimRequest(int tokenId, int policyId, int fid, int billId, String cause, String status_, int customerId,
			double amountClaimed) {
		super();
		this.tokenId = tokenId;
		this.policyId = policyId;
		this.fid = fid;
		this.billId = billId;
		this.cause = cause;
		this.status_ = status_;
		this.customerId = customerId;
		this.amountClaimed = amountClaimed;
	}

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getStatus_() {
		return status_;
	}

	public void setStatus_(String status_) {
		this.status_ = status_;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmountClaimed() {
		return amountClaimed;
	}

	public void setAmountClaimed(double amountClaimed) {
		this.amountClaimed = amountClaimed;
	}

	@Override
	public String toString() {
		return "ClaimRequest [tokenId=" + tokenId + ", policyId=" + policyId + ", fid=" + fid + ", billId=" + billId
				+ ", cause=" + cause + ", status_=" + status_ + ", customerId=" + customerId + ", amountClaimed="
				+ amountClaimed + "]";
	}
	

}