package com.moneytolia.data;

public class ProductData {

	private String productName;

	private double productPrice;

	private int productQuantity;

	private double productTotalPrice;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
		this.productTotalPrice = productPrice * productQuantity;

	}

	public double getProductTotalPrice() {
		return productTotalPrice;
	}

}
