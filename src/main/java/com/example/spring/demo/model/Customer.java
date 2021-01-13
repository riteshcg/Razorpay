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
@Table(name = "tb_razor_customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "AMOUNT")
	private String amount;

}
