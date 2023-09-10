package net.fuzui.StudentInfo.pojo;
/**
 * 成绩实体类
 * @author wangze
 *
 */
public class Grade {
	private String cid;
	private String cname;
	private String sid;
	private Integer grade;
	private Integer credits;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Grade [cid=" + cid + ", sid=" + sid + ", grade=" + grade + ", credits=" + credits + "]";
	}
	
	
	

}
