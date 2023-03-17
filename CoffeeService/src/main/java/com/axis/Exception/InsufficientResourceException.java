package com.axis.Exception;

public class InsufficientResourceException extends RuntimeException {
	 
	 private String msg;
	 
	 public InsufficientResourceException(String msg) {
		 this.msg=msg;
	 }
	 public String getMsg() {
		 return msg;
	 }

}
