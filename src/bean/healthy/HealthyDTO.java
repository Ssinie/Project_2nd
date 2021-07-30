package bean.healthy;

import java.sql.Timestamp;
/*
create table t_healthy_board (
	    num number primary key,
	    title varchar2(200),
	    content varchar2(2000),
	    writer varchar2(50),
	    regdate date default sysdate,
	    updatedate date default sysdate
	);
*/
public class HealthyDTO {
	private int num;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private Timestamp updateDate;
	private int count;
	
	
	public int getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public int getCount() {
		return count;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HealthyDTO [num=").append(num).append(", title=").append(title).append(", content=")
				.append(content).append(", writer=").append(writer).append(", regdate=").append(regdate)
				.append(", updateDate=").append(updateDate).append(", count=").append(count).append("]");
		return builder.toString();
	}
	

}
