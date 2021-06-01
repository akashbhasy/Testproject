package com.ust.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ust.Model.Customer;
import com.ust.Model.UserRegistration;
import com.ust.mailservice.MailService;
import com.ust.pms.service.CustomerService;

@Controller
public class PortalController {

	@Autowired
	CustomerService customerservice;
	
	@Autowired
	MailService mailservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errormsg", "USERNAME or PASSWORD INCORRECT");

		}
		if (logout != null) {
			model.addAttribute("msg", "Sucessfully logout");

		}
		return "login";
	}

	@RequestMapping("/index")
	public ModelAndView index() {
		String username = null;

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {

			username = ((UserDetails) principal).getUsername();

		}
		ModelAndView view = new ModelAndView();
		view.addObject("username", username);
		view.setViewName("index");
		return view;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("registration", "user", new UserRegistration());

	}

	@Autowired
	JdbcUserDetailsManager jdbcuserdetailsmanager;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") UserRegistration userregisteration) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		User user = new User(userregisteration.getUsername(), userregisteration.getPassword(), authorities);
		jdbcuserdetailsmanager.createUser(user);

		Customer customer = new Customer();
		customer.setFirst_Name(userregisteration.getFirst_Name());
		customer.setLast_Name(userregisteration.getLast_Name());
		customer.setCustomer_Address(userregisteration.getCustomerAddress());
		customer.setEmail_Id(userregisteration.getEmail());
		customer.setCustomer_Status("Active");
		customerservice.saveproduct(customer);
		String email=userregisteration.getEmail();
		mailservice.sendEmail(email);
		return new ModelAndView("login", "message", "You have been sucesfully registered");

	}

}
