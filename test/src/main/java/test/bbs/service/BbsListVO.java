package test.bbs.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;


@SuppressWarnings("serial")
public class BbsListVO implements Serializable {
	

	private String id;
	private String pw;
	private String zipcode;
	private String regdate;


	//getter, setter
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  ToStringBuilder.reflectionToString(this);
	}
	
	
}

