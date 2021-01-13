package com.example.spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.demo.model.Customer;
import com.example.spring.demo.model.RazorPay;
import com.example.spring.demo.model.Response;
import com.example.spring.demo.service.RazorPayService;
import com.google.gson.Gson;
import com.razorpay.Order;
import com.razorpay.RazorpayException;;

/**
 * Created by Ritesh on 13/01/2021
 */

@Controller
public class RazorPayController {

	@Autowired
	private RazorPayService razorPayService;

	private static Gson gson = new Gson();

	@RequestMapping(value = "/home")
	public String getHomeInit() {
		return "home"; // Form created for initial page
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createOrder(@RequestBody Customer customer) {

		try {

			Order order = razorPayService.createRazorPayOrder(customer.getAmount()); // Creating an order in Razorpay
			RazorPay razorPay = razorPayService.getRazorPay((String) order.get("id"), customer); // Getting the order id

			Response response = new Response();
			response.setStatusCode(200);
			response.setStatus(true);
			response.setMessage("Order created successfully"); // For successful order creation returning the success message
			response.setRazorPay(razorPay);													
			return new ResponseEntity<>(gson.toJson(response), HttpStatus.OK);

		} catch (RazorpayException e) {
			e.printStackTrace();
		}
		Response response = new Response();
		response.setStatusCode(500);
		response.setStatus(false);
		response.setMessage("Order creation unsuccessfull"); // For unsuccessful order creation handling the razorpay error with error message
		return new ResponseEntity<>(gson.toJson(response), HttpStatus.EXPECTATION_FAILED);
	}

}
