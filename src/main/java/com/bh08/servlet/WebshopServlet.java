package com.bh08.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bh08.model.Product;
import com.bh08.model.PromotionType;
import com.bh08.service.WebshopService;

/**
 * Servlet implementation class WebshopServlet
 */
@WebServlet(name = "WebshopServlet", urlPatterns = { "/WebshopServlet" })
public class WebshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		List<Product> products = WebshopService.getListOfProducts();
		request.setAttribute("products", products);

		RequestDispatcher dispatcher = request.getRequestDispatcher("listProducts.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> products = WebshopService.getListOfProducts();
		int[] numberOfProductsOrdered = new int[products.size()];

		for (int i = 0; i < numberOfProductsOrdered.length; i++) {
			numberOfProductsOrdered[i] = Integer.parseInt(request.getParameter("" + i));
		}

		int originalPrice = WebshopService.getOriginalPrice(products, numberOfProductsOrdered);
		int totalMegapackPromotion = WebshopService.getTotalMegapackPromotion(products, numberOfProductsOrdered);
		int totalPay2PiecesTake3PiecesPromotion = WebshopService.getTotalPay2PiecesTake3PiecesPromotion(products,
				numberOfProductsOrdered);

		int priceWithPromotions = originalPrice;
		PromotionType promotionType = PromotionType.NONE;
		
		if (totalMegapackPromotion > 0 || totalPay2PiecesTake3PiecesPromotion > 0) {
			if (totalMegapackPromotion >= totalPay2PiecesTake3PiecesPromotion) {
				priceWithPromotions = originalPrice - totalMegapackPromotion;
				promotionType = PromotionType.MEGAPACK;
				
			} else {
				priceWithPromotions = originalPrice - totalPay2PiecesTake3PiecesPromotion;
				promotionType = PromotionType.PAY_2PIECES_TAKE_3PIECES;
			}
		}
		
		String promotion = promotionType.getDescription();
		
		request.setAttribute("products", products);
		request.setAttribute("numberOfProductsOrdered", numberOfProductsOrdered);
		request.setAttribute("promotion", promotion);
		request.setAttribute("originalPrice", originalPrice);
		request.setAttribute("priceWithPromotions", priceWithPromotions);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("listOrderedProducts.jsp");
		dispatcher.forward(request, response);
	}

}
