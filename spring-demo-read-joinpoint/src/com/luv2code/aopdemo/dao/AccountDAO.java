package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount() {
		System.out.println(getClass() + "(). Doing my work. Adding new Account!");
	}

	public String getName() {
		System.out.println(getClass() + "().in getName() method.");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "().in setName() method.");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "().in getServiceCode() method.");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "().in setServiceCode() method.");
		this.serviceCode = serviceCode;
	}

}
