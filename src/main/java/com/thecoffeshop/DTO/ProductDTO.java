package com.thecoffeshop.DTO;

import java.util.List;

import com.thecoffeshop.Models.Image;
import com.thecoffeshop.Models.Price;
import com.thecoffeshop.Models.Product;

public class ProductDTO {
	
	private Product product;
	private List<Image> images;
	private int number;
	private int price;
	private Price newPrice;
	private int rateOldAndNewPrice;
	private boolean checkIsNew;
	
	public boolean getCheckIsNew() {
		return checkIsNew;
	}
	public void setCheckIsNew(boolean checkIsNew) {
		this.checkIsNew = checkIsNew;
	}
	public Price getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(Price newPrice) {
		this.newPrice = newPrice;
	}
	public int getRateOldAndNewPrice() {
		return rateOldAndNewPrice;
	}
	public void setRateOldAndNewPrice(int rateOldAndNewPrice) {
		this.rateOldAndNewPrice = rateOldAndNewPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
