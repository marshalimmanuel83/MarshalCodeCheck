package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

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
	
	public List<Account> findAllAccounts() {
		
		List<Account> listAccounts = new ArrayList<Account>();
		
		Account account1 = new Account("Marshal", "Gold");
		Account account2 = new Account("Nancy", "Silver");
		Account account3 = new Account("John", "Bronze");
		
		listAccounts.add(account1);
		listAccounts.add(account2);
		listAccounts.add(account3);
		
		return listAccounts;
	}
	
	public List<Account> getDataAndModify(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Ooops! You tripped on the wire.");
		}
		
		List<Account> listAccounts = new ArrayList<Account>();
		
		Account account1 = new Account("Marshal", "Gold");
		Account account2 = new Account("Nancy", "Silver");
		Account account3 = new Account("John", "Bronze");
		
		listAccounts.add(account1);
		listAccounts.add(account2);
		listAccounts.add(account3);
		
		return listAccounts;
	}
	
	
}
