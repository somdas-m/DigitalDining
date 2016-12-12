package com.digital.pojo;

public class Item {
	private String itemNumber;
	private String itemName;
	private float itemPrice;
	private String itemCategory;
	
	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getCategory() {
		return itemCategory;
	}

	public void setCategory(String category) {
		itemCategory = category;
	}
}
