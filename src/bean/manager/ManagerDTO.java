package bean.manager;

import java.sql.Timestamp;

/*
create table t_manager_board(
  id varchar2(50) not null primary KEY,
  password varchar2(50) not null,
  name varchar2(50),
  department varchar2(50),
  gender varchar2(10),
  mail varchar2(100),
  phone varchar2(50),
  address varchar2(200),
  regdate date default sysdate,
  updatedate date default sysdate
  verify number default 0,
  status number default 0
);
 */
public class ManagerDTO {
	private String id;
	private String password;
	private String name;
	private String department;
	private String gender;
	private String mail;
	private String phone;
	private String address;
	private Timestamp regdate;
	private Timestamp updateDate;
	private int verify;
	private int status;
	
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public String getGender() {
		return gender;
	}
	public String getMail() {
		return mail;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public int getVerify() {
		return verify;
	}
	public int getStatus() {
		return status;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ManagerDTO [id=" + id + ", password=" + password + ", name=" + name + ", department=" + department
				+ ", gender=" + gender + ", mail=" + mail + ", phone=" + phone + ", address=" + address + ", regdate="
				+ regdate + ", updateDate=" + updateDate + ", verify=" + verify + ", status=" + status + "]";
	}	
	
}
