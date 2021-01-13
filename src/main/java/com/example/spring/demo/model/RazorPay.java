package com.example.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Ritesh on 13/01/2021
 */
@Getter // @Data can also be used
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_razor_order")
public class RazorPay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RAZORPAY_ID")
	private Integer razorpayId;

	@Column(name = "APPLICATIONFEES")
	private String applicationFee;

	@Column(name = "RAZORPAYORDER_ID")
	private String razorpayOrderId;

	@Column(name = "SECRET_KEY")
	private String secretKey;

	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "NOTES")
	private String notes;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@Column(name = "THEME")
	private String theme;

	@Column(name = "MERCHANT_NAME")
	private String merchantName;

	@Column(name = "PURCHASE_DESCRIPTION")
	private String purchaseDescription;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "CUSTOMER_EMAIL")
	private String customerEmail;

	@Column(name = "CUSTOMER_CONTACT")
	private String customerContact;

}
