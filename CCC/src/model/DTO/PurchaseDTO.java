package model.DTO;

import java.sql.Timestamp;

public class PurchaseDTO {
	private String purchaseNum;
	private String classesNum;
	private String userEmail;
	private	Timestamp purchaseDate;
	private	Timestamp expireDate;
	private Long purchasePrice;
	private String classesSubject;
	private Long classesPrice;
	private String refund;
	private String refundOk;
	
	
	
	
	
	
	public String getRefundOk() {
		return refundOk;
	}
	public void setRefundOk(String refundOk) {
		this.refundOk = refundOk;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public Long getClassesPrice() {
		return classesPrice;
	}
	public void setClassesPrice(Long classesPrice) {
		this.classesPrice = classesPrice;
	}
	public String getClassesSubject() {
		return classesSubject;
	}
	public void setClassesSubject(String classesSubject) {
		this.classesSubject = classesSubject;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getClassesNum() {
		return classesNum;
	}
	public void setClassesNum(String classesNum) {
		this.classesNum = classesNum;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Timestamp getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Timestamp expireDate) {
		this.expireDate = expireDate;
	}
	public Long getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	
	
}
