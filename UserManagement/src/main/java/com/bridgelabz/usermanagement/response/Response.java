package com.bridgelabz.usermanagement.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
	private int statusCode;
	private String message;
	private Object data;
}
