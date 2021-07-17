package model;

import java.sql.Date;

public class OrderListDTO {

	String prodNum;
	String prodSupplier;
	String prodName;
	String prodImage;
	Date purchaseDate;
	String purchaseNum;
	String purchaseTotPrice;
	String reviewContent;
	String paymentApprNum;
	
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdSupplier() {
		return prodSupplier;
	}
	public void setProdSupplier(String prodSupplier) {
		this.prodSupplier = prodSupplier;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdImage() {
		return prodImage;
	}
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getPurchaseTotPrice() {
		return purchaseTotPrice;
	}
	public void setPurchaseTotPrice(String purchaseTotPrice) {
		this.purchaseTotPrice = purchaseTotPrice;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getPaymentApprNum() {
		return paymentApprNum;
	}
	public void setPaymentApprNum(String paymentApprNum) {
		this.paymentApprNum = paymentApprNum;
	}
	
	
}
