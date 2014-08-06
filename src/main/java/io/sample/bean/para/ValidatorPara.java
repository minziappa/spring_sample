package io.sample.bean.para;

import java.util.Date;

import io.sample.annotation.Phone;
import io.sample.bean.para.embed.AaName;
import io.sample.bean.para.embed.BbName;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class ValidatorPara {

	@NotNull
	@Size(min = 1, max = 10 ,message = "userName must not exceed {max} characters")
	private String userName;

//    @NotNull(message = "userData")
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date userData;

    @NotNull(message = "aaName must be datas.")
    @Phone(message = "the phone number is wrong.")
    private String phoneNumber;

    @Valid
    private AaName aaName;

    @Valid
    private BbName bbName;

//	public Date getUserData() {
//		return userData;
//	}
//
//	public void setUserData(Date userData) {
//		this.userData = userData;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AaName getAaName() {
		return aaName;
	}

	public void setAaName(AaName aaName) {
		this.aaName = aaName;
	}

	public BbName getBbName() {
		return bbName;
	}

	public void setBbName(BbName bbName) {
		this.bbName = bbName;
	}

}