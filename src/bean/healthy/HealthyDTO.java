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

	@Override
	public String toString() {
		return "healthyTipDTO [num=" + num + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", regdate=" + regdate + ", updateDate=" + updateDate + "]";
	}
	

}
