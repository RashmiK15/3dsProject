package layer2;

public class Bill {
	private int billId;
	private double billAmount;
    
	
	public Bill() {
		
	}
	
	public Bill(int billId, double billAmount) {
		super();
		this.billId = billId;
		this.billAmount = billAmount;
	}

	

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billAmount=" + billAmount + "]";
	}
	
}