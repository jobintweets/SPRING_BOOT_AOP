package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
  private JavaMailSender jms;

	@RequestMapping(value = "/add/employee", method = RequestMethod.GET)
	public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return employeeService.createEmployee(name, empId);

	}

	@RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
	public String removeEmployee( @RequestParam("empId") String empId) {

		employeeService.deleteEmployee(empId);

		return "Employee removed";
	}



@RequestMapping(value="/test",method  =RequestMethod.GET)
public String Test(@RequestParam("abc") String test) {
	 return employeeService.test(test);
	}

	@GetMapping("/email")
  public String email_Service() {
    SimpleMailMessage sms=new SimpleMailMessage();
    sms.setTo("varun@specbee.com");
    sms.setSubject("Email Sent using Spring boot");
    sms.setText("What kind of music is a balloon scared of?\n" +
      "Pop music.");
    jms.send(sms);
	  return "Email sent";
  }
}