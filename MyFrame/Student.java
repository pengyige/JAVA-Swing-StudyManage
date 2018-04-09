package MyFrame;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Student {
	private String Stu_no;
	private String Stu_name;
	private String Stu_sex;
	private Date Stu_birthday;
	private String Stu_pnumber;
	private String Stu_class;
	private String password;
	public String getStu_no() {
		return Stu_no;
	}
	public void setStu_no(String stu_n0) {
		Stu_no = stu_n0;
	}
	public String getStu_name() {
		return Stu_name;
	}
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
	public String getStu_sex() {
		return Stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		Stu_sex = stu_sex;
	}
	public Date getStu_birthday() {
		return Stu_birthday;
	}
	public void setStu_birthday(Date stu_birthday) {
		Stu_birthday = stu_birthday;
	}
	public String getStu_class() {
		return Stu_class;
	}
	public void setStu_class(String stu_class) {
		Stu_class = stu_class;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStu_pnumber() {
		return Stu_pnumber;
	}
	public void setStu_pnumber(String stu_pnumber) {
		Stu_pnumber = stu_pnumber;
	}
	
}
