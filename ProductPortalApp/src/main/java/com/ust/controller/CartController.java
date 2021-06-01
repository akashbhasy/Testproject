package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.Model.Cart;
import com.ust.Model.Product;
import com.ust.pms.service.CartService;
import com.ust.pms.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartservice;
	@Autowired
	ProductService productservice;

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();

		view.setViewName("redirect:/index");
		return view;
	}

	@RequestMapping(value = "/updateCart")
	public ModelAndView updateCart(@ModelAttribute("Carts") Cart carts) {

		cartservice.saveCart(carts);

		List<Cart> cart = cartservice.getCarts();
		return new ModelAndView("mycart", "Carts", cart);
	}

	@RequestMapping(value = "/saveCart", method = RequestMethod.POST)
	public ModelAndView saveProduct(@ModelAttribute("Products") Product product) {
		int size = cartservice.sizeOfCart();
		ModelAndView modelview = new ModelAndView();
		if (size >= 10) {
			List<Product> products = productservice.getproducts();
			modelview.addObject("Products", products);
			modelview.setViewName("redirect:/viewAllProducts");
			modelview.addObject("msg", "Your Cart Size Full");
			return modelview;
		}
		int price = 0;
		int quantityToReduse = 0;
		Cart cart = new Cart();
		cart.setItem_Name(product.getProductName());
		cart.setItem_Quantity(product.getQuantityOnHand());
		price = product.getQuantityOnHand() * product.getPrice();
		cart.setItem_Price(price);
		cart.setItem_Total_price(price);

		cartservice.saveCart(cart);
		Product searchproduct = productservice.getproduct(product.getProductId());

		quantityToReduse = searchproduct.getQuantityOnHand() - product.getQuantityOnHand();
		searchproduct.setQuantityOnHand(quantityToReduse);
		productservice.saveproduct(searchproduct);

		List<Product> products = productservice.getproducts();

		return new ModelAndView("redirect:/viewAllProducts", "Products", products);

	}

	@RequestMapping("/searchcartById")
	public ModelAndView searchProductbyId() {
		return new ModelAndView("searchcartById", "command", new Product());
	}

	@RequestMapping("/searchbyId")
	public ModelAndView searchbyId(Cart cart) {

		int pid = cart.getCart_ID();

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("searchProductById");

		if (cartservice.isCartExist(pid)) {
			Cart cartdetails = cartservice.getCart(pid);
			modelview.addObject("command", cartdetails);
		} else {
			modelview.addObject("command", new Cart());
			modelview.addObject("msg", "product with this productid:" + pid + " not available");
		}
		return modelview;
	}

	@RequestMapping("/deleteCart")
	public ModelAndView deleteByID(Cart carts) {

		int pid = carts.getCart_ID();
		cartservice.deleteCart(pid);

		List<Cart> cart = cartservice.getCarts();
		return new ModelAndView("mycart", "Carts", cart);

	}

	@RequestMapping("/mycart")
	public ModelAndView myCart() {

		List<Cart> cart = cartservice.getCarts();
		return new ModelAndView("mycart", "Carts", cart);
	}
}
