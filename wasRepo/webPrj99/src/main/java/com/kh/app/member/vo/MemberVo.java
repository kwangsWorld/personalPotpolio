package com.kh.app.member.vo;

import java.util.Arrays;

public class MemberVo {

	private String no;
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberNick;
	private String phone;
	private String email;
	private String addr;
	private String[] hobbys;
	private String hobbyStr;
	private String enrollDate;
	private String modifyDate;
	private String status;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String no, String memberId, String memberPwd, String memberPwd2, String memberNick, String phone,
			String email, String addr, String[] hobbys, String hobbyStr, String enrollDate, String modifyDate,
			String status) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberPwd2 = memberPwd2;
		this.memberNick = memberNick;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.hobbys = hobbys;
		this.hobbyStr = hobbyStr;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberPwd2="
				+ memberPwd2 + ", memberNick=" + memberNick + ", phone=" + phone + ", email=" + email + ", addr=" + addr
				+ ", hobbys=" + Arrays.toString(hobbys) + ", hobbyStr=" + hobbyStr + ", enrollDate=" + enrollDate
				+ ", modifyDate=" + modifyDate + ", status=" + status + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberPwd2() {
		return memberPwd2;
	}
	public void setMemberPwd2(String memberPwd2) {
		this.memberPwd2 = memberPwd2;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String[] getHobbys() {
		return hobbys;
	}
	public void setHobbys(String[] hobbys) {
		if(hobbys == null) {
			this.hobbyStr="";
			return;
		}
		this.hobbys = hobbys;
		this.hobbyStr = String.join(",", hobbys);
	}
	public String getHobbyStr() {
		return hobbyStr;
	}
	public void setHobbyStr(String hobbyStr) {
		this.hobbyStr = hobbyStr;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
