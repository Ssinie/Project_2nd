package bean.question;

import java.util.Date;

public class q2DTO {
	private String intr ;
	private Date dates ;
	private int ref ;
	private String bld ;
	
	public void setIntr(String intr) {
		this.intr = intr ;
	}
	public void setDates(Date dates) {
		this.dates = dates ;
	}
	public void setRef(int ref) {
		this.ref = ref ;
	}
	public void setbld(String bld) {
		this.bld = bld ;
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
	public String getbld() {
		return bld ;
	}
}
