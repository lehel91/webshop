package com.bh08.model;

public class Product {
	
	private String name;
	private int price;
	private PromotionType promotionType;
	
	public Product() {
	}

	public Product(String name, int price, PromotionType promotionType) {
		this.name = name;
		this.price = price;
		this.promotionType = promotionType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public PromotionType getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(PromotionType promotionType) {
		this.promotionType = promotionType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		result = prime * result + ((promotionType == null) ? 0 : promotionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		if (promotionType != other.promotionType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", promotionType=" + promotionType + "]";
	}
	
	
	
}
