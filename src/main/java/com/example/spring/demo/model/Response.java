package com.example.spring.demo.model;

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
public class Response {

	private int statusCode;
	private RazorPay razorPay;
	private String message;
	private boolean status;
	private Object data;

}
