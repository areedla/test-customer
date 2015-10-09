package com.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	String helloMessage = "Hello costumer! We are happy to see you!";
	
	@RequestMapping("/index")
	public ModelAndView index() {
 
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("helloMessage", helloMessage);
		return mv;
	}
	
	
	@RequestMapping("/list")
	public ModelAndView customerList() {
		
		List<Customer> allCustomers = null;
 
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("allCustomers", allCustomers);
		return mv;
	}
	
	@RequestMapping("/create")
	public ModelAndView addCustomer() {
 
		ModelAndView mv = new ModelAndView("create");
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomer() {
 
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer() {
 
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer() {
 
		return "redirect:/list";
	}
}
