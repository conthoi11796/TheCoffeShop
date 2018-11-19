package com.thecoffeshop.DTO;

import com.thecoffeshop.Models.*;
public class BillDetailDTO {

	private Billdetail billdetail; 
	
	private int singlePrice;
	
	private int totalPrice;

	public Billdetail getBilldetail() {
		return billdetail;
	}

	public void setBilldetail(Billdetail billdetail) {
		this.billdetail = billdetail;
	}

	public int getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(int singlePrice) {
		this.singlePrice = singlePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	
}
