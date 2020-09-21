package com.spring.biz.vo;

public class MemberVO extends BaseVO{
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberGender;
	private String tel1;
	private String tel2;
	private String email;
	private String smsYn;
	private String emailYn;
	private String birthdayYear;
	private String birthdayMonth;
	private String birthdayDay;
	private String memberAddr;
	private String joinDate;
	private String delYn;
	private int memberType;
	
	public int getMemberType() {
		return memberType;
	}
	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSmsYn() {
		return smsYn;
	}
	public void setSmsYn(String smsYn) {
		this.smsYn = smsYn;
	}
	public String getEmailYn() {
		return emailYn;
	}
	public void setEmailYn(String emailYn) {
		this.emailYn = emailYn;
	}
	public String getBirthdayYear() {
		return birthdayYear;
	}
	public void setBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
	}
	public String getBirthdayMonth() {
		return birthdayMonth;
	}
	public void setBirthdayMonth(String birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}
	public String getBirthdayDay() {
		return birthdayDay;
	}
	public void setBirthdayDay(String birthdayDay) {
		this.birthdayDay = birthdayDay;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPassword=" + memberPassword + ", memberName=" + memberName
				+ ", memberGender=" + memberGender + ", tel1=" + tel1 + ", tel2=" + tel2 + ", email=" + email
				+ ", smsYn=" + smsYn + ", emailYn=" + emailYn + ", birthdayYear=" + birthdayYear + ", birthdayMonth="
				+ birthdayMonth + ", birthdayDay=" + birthdayDay + ", memberAddr=" + memberAddr + ", joinDate="
				+ joinDate + ", delYn=" + delYn + ", memberType=" + memberType + "]";
	}
	
	
}










