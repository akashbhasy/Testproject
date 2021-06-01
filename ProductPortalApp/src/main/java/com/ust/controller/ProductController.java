package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ust.Model.Product;
import com.ust.pms.service.CustomerService;
import com.ust.pms.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	ProductService productservice;


	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {

		return new ModelAndView("addproduct", "command", new Product());
	}

	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(Product product) {
		productservice.saveproduct(product);
		return new ModelAndView("addproduct", "command", new Product());
	}

	@RequestMapping("/searchProductById")
	public ModelAndView searchProductbyId() {
		return new ModelAndView("searchProductById", "command", new Product());
	}

	@RequestMapping("/searchbyId")
	public ModelAndView searchbyId(Product product) {

		int pid = product.getProductId();

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("searchProductById");

		if (productservice.isproductExist(pid)) {
			Product productDetails = productservice.getproduct(pid);
			modelview.addObject("command", productDetails);
		} else {
			modelview.addObject("command", new Product());
			modelview.addObject("msg", "product with this productid:" + pid + " not available");
		}
		return modelview;
	}

	@RequestMapping("/deleteByID")
	public ModelAndView deleteByID(Product product) {

		int pid = product.getProductId();

		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("searchProductById");
		modelview.addObject("command", new Product());
		if (productservice.isproductExist(pid)) {
			productservice.deleteProduct(pid);
			modelview.addObject("msg", "product with this productid:" + pid + " deleted Sucessfully");
		} else {

			modelview.addObject("msg", "product with this productid:" + pid + " not available");
		}
		return modelview;
	}

	@RequestMapping("/viewAllProducts")
	public ModelAndView viewAllProducts() {
		
		List<Product> products=productservice.getproducts();

		return new ModelAndView("viewAllProducts","Products",products);
	}
}
