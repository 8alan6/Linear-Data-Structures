package monetary;

import java.util.ArrayList;
import java.util.Date;

import maintenence.Procedure;
import maintenence.ProcedureList;

public class Invoice {
	int invNo;
	static int Invoice = 100000;
	double invoiceAmt;
	Date invoiceDate;
	boolean isPaid;
	ArrayList<Procedure> proList;
	ArrayList<Payment> payList;
	
	public Invoice(Date d) {
		invNo = Invoice;
		Invoice++;
		this.invoiceDate = d;
		proList = new ArrayList<Procedure>();
		payList = new ArrayList<Payment>();
	}

	public int getInvNo() {
		return invNo;
	}

	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	public double getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(double invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public ArrayList<Procedure> getProList() {
		return proList;
	}

	public void setProList(ArrayList<Procedure> proList) {
		this.proList = proList;
	}

	public ArrayList<Payment> getPayList() {
		return payList;
	}

	public void setPayList(ArrayList<Payment> payList) {
		this.payList = payList;
	}

	@Override
	public String toString() {
		return "Invoice [invNo=" + invNo + ", invoiceAmt=" + invoiceAmt + ", invoiceDate=" + invoiceDate + ", isPaid="
				+ isPaid + ", proList=" + proList + ", payList=" + payList + "]";
	}
	
	
	public void addProceduretToInvoice(Procedure pro) {
		this.proList.add(pro);
	}
	
	public void addPaymentToInvoice(Payment pay) {
		this.payList.add(pay);
	}
}
