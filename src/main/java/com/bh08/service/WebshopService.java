package com.bh08.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.bh08.model.Product;
import com.bh08.model.PromotionType;
import com.opencsv.CSVReader;

public class WebshopService {
	
	public static List<Product> getListOfProducts() throws IOException {

        List<Product> products = new ArrayList<>();

        InputStream is = WebshopService.class.getClassLoader().getResourceAsStream("Termekek.csv");

        try(CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            
            String[] nextLine;
            reader.readNext();

            while ((nextLine = reader.readNext()) != null) {

            	String name = nextLine[0];
            	int price = Integer.valueOf(nextLine[1]);
            	PromotionType promotionType;
            	
            	if (nextLine[2].equalsIgnoreCase("x")) {
            		promotionType = PromotionType.PAY_2PIECES_TAKE_3PIECES;
            	} else if (nextLine[3].equalsIgnoreCase("x")) {
            		promotionType = PromotionType.MEGAPACK;
            	} else {
            		promotionType = PromotionType.NONE;
            	}
            	
                Product newProduct = new Product(name, price, promotionType);
                products.add(newProduct);
            }
        }

        return products;
    }
	
	public static int getOriginalPrice(List<Product> products, int[] piecesOrdered) {
		
		int originalPrice = 0;
		
		for (int i = 0; i < products.size(); i++) {
			originalPrice += products.get(i).getPrice() * piecesOrdered[i];
		}
		return originalPrice;
	}
	
	public static int getTotalMegapackPromotion(List<Product> products, int[] piecesOrdered) {
		int totalPromotion = 0;
		
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPromotionType().equals(PromotionType.MEGAPACK)) {
				totalPromotion += piecesOrdered[i] / 12 * 6000; 
			}
		}
		return totalPromotion;
	}
	
	public static int getTotalPay2PiecesTake3PiecesPromotion(List<Product> products, int[] piecesOrdered) {
		int totalPromotion = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getPromotionType().equals(PromotionType.PAY_2PIECES_TAKE_3PIECES)) {
				totalPromotion += piecesOrdered[i] / 3 * products.get(i).getPrice(); 
			}
		}
		return totalPromotion;
	}
}
