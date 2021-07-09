package bean.question;

import java.util.Date;

// 설문조사에 필요한 DTO 정의.
public class qDTO {
	private String nick ;
	private int age ;
	private int weight ;
	private int height ;
	private String gender ;
	private Date dates ;
	private int qcount ;
	private int ref ;
	
	public void setNick(String nick) {
		this.nick = nick ;
	}
	public void setAge(int age) {
		this.age = age ;
	}
	public void setWeight(int weight) {
		this.weight = weight ;
	}
	public void setHeight(int height) {
		this.height = height ;
	}
	public void setGender(String gender) {
		this.gender = gender ;
	}
	public void setDates(Date dates) {
		this.dates = dates ;
	}
	public void setQcount(int qcount ) {
		this.qcount = qcount ;
	}
	public void setRef(int ref) {
		this.ref = ref ;
	}
	
	public String getNick() {
		return nick ;
	}
	public int getAge() {
		return age ;
	}
	public int getWeight() {
		return weight ;
	}
	public int getHeight() {
		return height ;
	}
	public String getGender() {
		return gender ;
	}
	public Date getDates() {
		return dates ;
	}
	public int getQcount() {
		return qcount ;
	}
	public int getRef() {
		return ref ;
	}
}