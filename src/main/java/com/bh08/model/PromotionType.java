package com.bh08.model;

public enum PromotionType {
	PAY_2PIECES_TAKE_3PIECES("Kettőt fizet, hármat vihet!!!"),
	MEGAPACK("Megapack"),
	NONE("nincs");
	
	private String description; 
	
	private PromotionType(String description) {
		this.description = description; 
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
