package bean.question;

import java.util.Date;

public class qcDTO {
	private String title ;
	private String contents ;
	private Date dates ;
	private int ref ;
	
	public void setTitle(String title) {
		this.title = title ;
	}
	public void setContents(String contents) {
		this.contents = contents ;
	}
	public void setDates(Date dates) {
		this.dates = dates ;
	}
	public void setRef(int ref) {
		this.ref =ref ;
	}
	public String getTitle() {
		return title ;
	}
	public String getContents() {
		return contents ;
	}
	public Date dates() {
		return dates ;
	}
	public int ref() {
		return ref ;
	}
}
