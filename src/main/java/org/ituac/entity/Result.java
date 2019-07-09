package org.ituac.entity;

import lombok.Data;

@Data
public class Result {

	private int code;
	
	private boolean success;
	
	private String msg;

	public Result(int code, boolean success, String msg) {
		this.code = code;
		this.success = success;
		this.msg = msg;
	}
	
}
