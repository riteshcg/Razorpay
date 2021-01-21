package com.example.spring.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.demo.model.Customer;
import com.example.spring.demo.model.RazorPay;
import com.example.spring.demo.respository.CustomerRepository;
import com.example.spring.demo.respository.OrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Created by Ritesh on 13/01/2021
 */

@Service
public class RazorPayService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	private RazorpayClient client;

	private String Secret_Id = "rzp_test_xA76uScXOavh14"; // Secret_Id from razorpay sandbox account
	private String Secret_key = "1uVy3YSaC20QogGnwGZbIC4l"; // Secret_Key from razorpay sandbox account

	public RazorPayService(String Secret_Id, String Secret_key) { // Parametrized constructor used to initialize secret key and secret id
																
		this.Secret_Id = Secret_Id;
		this.Secret_key = Secret_key;
	}

	public RazorPayService() throws RazorpayException { // NoArgument constructor to initialize the razorpay client
		this.client = new RazorpayClient(Secret_Id, Secret_key);
	}

	public RazorPay getRazorPay(String orderId, Customer customer) {
		RazorPay razorPay = new RazorPay();
		razorPay.setApplicationFee(convertRupeeToPaise(customer.getAmount()));
		razorPay.setCustomerName(customer.getCustomerName());
		razorPay.setCustomerEmail(customer.getEmail());
		razorPay.setMerchantName("RiteshTestPay");
		razorPay.setPurchaseDescription("RiteshPurchases");
		razorPay.setRazorpayOrderId(orderId);
		razorPay.setSecretKey(Secret_Id);
		razorPay.setTheme("#F37987");
		razorPay.setNotes("notes" + orderId);
		customerRepository.save(customer);
		orderRepository.save(razorPay);
		return razorPay;
	}

	public Order createRazorPayOrder(String amount) throws RazorpayException {

		JSONObject options = new JSONObject();
		options.put("amount", convertRupeeToPaise(amount));
		options.put("currency", "INR");
		options.put("receipt", "txn_123456");
		options.put("payment_capture", 1);
		return client.Orders.create(options);
	}

	private String convertRupeeToPaise(String paise) {
		BigDecimal b = new BigDecimal(paise);
		BigDecimal value = b.multiply(new BigDecimal("100"));
		return value.setScale(0, RoundingMode.UP).toString();

	}

}
