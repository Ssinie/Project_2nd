package bean.question;

import java.util.Date;

public class q2DTO {
	private String intr ;
	private Date dates ;
	private int ref ;
	
	public void setIntr(String intr) {
		this.intr = intr ;
	}
	public void setDates(Date dates) {
		this.dates = dates ;
	}
	public void setRef(int ref) {
		this.ref = ref ;
	}
	
	public String getIntr() {
		return intr ;
	}
	public Date getDates() {
		return dates ;
	}
	public int getRef() {
		return ref ;
	}
}
