package bean.question;

import java.sql.Timestamp;

public class qDTO {
	private int num ;
	private String title ;
	private String contents01 ;
	private String contents02 ;
	private String contents03 ;
	private String contents04 ;
	private String contents05 ;
	private String contents06 ;
	private String contents07 ;
	private String contents08 ;
	private String contents09 ;
	private String contents10 ;
	private Timestamp dates;
	
	
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getContents01() {
		return contents01;
	}
	public String getContents02() {
		return contents02;
	}
	public String getContents03() {
		return contents03;
	}
	public String getContents04() {
		return contents04;
	}
	public String getContents05() {
		return contents05;
	}
	public String getContents06() {
		return contents06;
	}
	public String getContents07() {
		return contents07;
	}
	public String getContents08() {
		return contents08;
	}
	public String getContents09() {
		return contents09;
	}
	public String getContents10() {
		return contents10;
	}
	public Timestamp getDates() {
		return dates;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents01(String contents01) {
		this.contents01 = contents01;
	}
	public void setContents02(String contents02) {
		this.contents02 = contents02;
	}
	public void setContents03(String contents03) {
		this.contents03 = contents03;
	}
	public void setContents04(String contents04) {
		this.contents04 = contents04;
	}
	public void setContents05(String contents05) {
		this.contents05 = contents05;
	}
	public void setContents06(String contents06) {
		this.contents06 = contents06;
	}
	public void setContents07(String contents07) {
		this.contents07 = contents07;
	}
	public void setContents08(String contents08) {
		this.contents08 = contents08;
	}
	public void setContents09(String contents09) {
		this.contents09 = contents09;
	}
	public void setContents10(String contents10) {
		this.contents10 = contents10;
	}
	public void setDates(Timestamp dates) {
		this.dates = dates;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("qDTO [num=").append(num).append(", title=").append(title).append(", contents01=")
				.append(contents01).append(", contents02=").append(contents02).append(", contents03=")
				.append(contents03).append(", contents04=").append(contents04).append(", contents05=")
				.append(contents05).append(", contents06=").append(contents06).append(", contents07=")
				.append(contents07).append(", contents08=").append(contents08).append(", contents09=")
				.append(contents09).append(", contents10=").append(contents10).append(", dates=").append(dates)
				.append("]");
		return builder.toString();
	}
	

}
