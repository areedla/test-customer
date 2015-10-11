package com.customer.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.customer.domain.Customer;
import com.customer.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	String helloMessage = "Hello to costumers maintenance system! We are happy to see you!";
	
	@RequestMapping({"/", "/index"})
	public ModelAndView index(@RequestParam(value = "msg", required = false) String msg) {
 
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("helloMessage", helloMessage);
		return mv;
	}
	
	
	@RequestMapping("/list")
	public ModelAndView customerList(@RequestParam(value = "msg", required = false, defaultValue = "") String msg) {
		
		List<Customer> allCustomers = customerService.getAllCustomers();
 
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("allCustomers", allCustomers);
		mv.addObject("msg", msg);
		return mv;
	}
	
	
	@RequestMapping("/addEdit")
	public @ResponseBody
	String addEdit(@RequestParam(value = "id", required = false, defaultValue = "") String id, 
							@RequestParam(value = "_", required = false, defaultValue = "") String ts) {
		
		Customer customer;
		String firstName = "";
		String lastName = "";
		String userName = "";
		String password = "";
		String dateOfBirth = "";
		
		if(!StringUtils.isEmpty(id)){
			customer = customerService.getCustomer(Long.parseLong(id));
			
			// customer must by present.. when not. then just crash
			firstName = customer.getFirstName();
			lastName = customer.getLastName();
			userName = customer.getUserName();
			password = customer.getPassword();
			dateOfBirth = customer.getDateOfBirthString();
		}
		
		// result for ajax request, TODO: render view, commandobjects, validation...
		// next version like: http://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-validator-example/ .. or somting smiler
		String result = "Add or edit customer.<div class='clear'></div>'";
		result += "";
		result += "<form  id='saveAction' action='/Customer/saveCustomer' method='POST'>";
		result += "<input type='hidden' name='id' value='" + id + "'/>";
		result += "<input type='hidden' id='csrf' name='' value=''/>";
		result += "<table>";
		result += "<tr>";
		result += "<td><form:label path='firstName'>First name:</form:label></td>";
		result += "<td><input type='text' name='firstName' value='" + firstName + "'/></td>";
		result += "</tr><tr>";
		result += "<td><form:label path='lastName'>Last name:</form:label></td>";
		result += "<td><input type='text' name='lastName' value='" + lastName + "'/></td>";
		result += "</tr><tr>";
		result += "<td><form:label path='userName'>Username:</form:label></td>";
		result += "<td><input type='text' name='userName' value='" + userName + "'/></td>";
		result += "</tr><tr>";
		result += "<td><form:label path='password'>Password:</form:label></td>";
		result += "<td><input type='text' name='password' path='password' value='" + password + "'/></td>";
		result += "</tr><tr>";
		result += "<td><form:label path='dateOfBirth'>Date of birth:</form:label></td>";
		result += "<td><input type='text' name='dateOfBirth' value='" + dateOfBirth + "'/></td>";
		result += "</tr><tr>";
		result += "";
		result += "<td><input type='submit' id='customerSaveButton' name='customerSaveButton' value='Save' style='float:right'/></td>";
		result += "</tr></table>";
		result += "</form>";
		// result + del button

		return result;
	}
	
	
	@RequestMapping("/edit")
	public ModelAndView editCustomer() {
 
		ModelAndView mv = new ModelAndView("edit");
		return mv;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "dateOfBirth", required = false) String dateOfBirth) {
		
		
		String result = "";
		
		// TODO: utils class for date manipulation
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
 
		try {
			Long customerId = null;
			Date birthDate = null;
			if(id != null && !id.equals("")) 
				customerId = Long.parseLong(id);
			if(dateOfBirth != null && !dateOfBirth.equals("")) 
				birthDate = df.parse(dateOfBirth);
			
			result = customerService.saveCustomer(customerId, firstName, lastName, 
					userName, password, birthDate);
			
		} catch (Exception e) {
			result += "Error!" + e.getMessage();
		}
		
		//TODO: useful messages to user in dialog
		
		return "redirect:/list?msg=" + result;
	}
	
	
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam(value = "id", required = false) String id) {
		
		boolean result = customerService.deleteCustomer(Long.parseLong(id));
		
		//TODO: useful messages to user
		
		String msg = "";
		if(result == false) msg = "Error on delete! Search help!";
		
		return "redirect:/list?msg=" + result;
	}
}
