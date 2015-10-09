package com.customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	String helloMessage = "Hello to costumers maintenance system! We are happy to see you!";
	
	@RequestMapping({"/", "/index"})
	public ModelAndView index() {
 
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("helloMessage", helloMessage);
		return mv;
	}
	
	
	@RequestMapping("/list")
	public ModelAndView customerList() {
		
		List<Customer> allCustomers = customerService.getAllCustomers();
 
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("allCustomers", allCustomers);
		return mv;
	}
	
	
	@RequestMapping("/addEdit")
	public String addCustomer(@RequestParam(value = "id", required = false) String id) {
		
		Customer customer;
		if(!StringUtils.isEmpty(id)){
			customer = customerService.getCustomer(Long.parseLong(id));
		}
		
		// for ajax request
		String result = "";
		

		return result;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView editCustomer() {
 
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "dateOfBirth", required = false) String dateOfBirth) {
		
		// TODO: utils class for date
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
 
		try {
			boolean result = customerService.saveCustomer(Long.parseLong(id), firstName, lastName, 
					userName, password, df.parse(dateOfBirth));
			
		} catch (NumberFormatException e) {
			// TODO 
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO 
			e.printStackTrace();
		}
		
		return "redirect:/list";
	}
	
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam(value = "id", required = false) String id) {
		
		boolean result = customerService.deleteCustomer(Long.parseLong(id));
		
		return "redirect:/list";
	}
}
