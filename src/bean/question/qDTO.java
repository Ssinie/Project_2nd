package bean.question;

import java.util.Date;

// 설문조사에 필요한 DTO 정의.
public class qDTO {
	private String nick ;
	private int age ;
	private int weight ;
	private int height ;
	private String gender ;
	private Date date ;
	
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
	public void setDate(Date date) {
		this.date = date ;
	}
	
	public String nick() {
		return nick ;
	}
	public int age() {
		return age ;
	}
	public int weight() {
		return weight ;
	}
	public int height() {
		return height ;
	}
	public String gender() {
		return gender ;
	}
	public Date date() {
		return date ;
	}
}
