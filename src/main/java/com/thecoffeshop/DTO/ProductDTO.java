package com.thecoffeshop.DTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.thecoffeshop.Models.Categoryproduct;
import com.thecoffeshop.Models.Image;
import com.thecoffeshop.Models.Product;

public class ProductDTO {
	
	private Product product;
	private List<Image> images;
	private int number;
	private int price;
	
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
