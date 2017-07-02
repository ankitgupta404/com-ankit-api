package com.ankit.api.model;

import java.util.List;

public class AjaxResponseBody {

	String msg;
	List<News> result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<News> getResult() {
		return result;
	}

	public void setResult(List<News> result) {
		this.result = result;
	}

}