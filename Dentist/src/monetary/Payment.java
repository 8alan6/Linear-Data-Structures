package monetary;

import java.util.Date;

public class Payment {
	int payment;
	static int PaymentNumber = 0;
	double paymentAmt;
	Date paymentDate;
	
	public Payment(){
		payment = PaymentNumber;
		PaymentNumber++;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public double getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [payment=" + payment + ", paymentAmt=" + paymentAmt + ", paymentDate=" + paymentDate + "]";
	}
	public void print() {
		System.out.println(toString());
	}
}
