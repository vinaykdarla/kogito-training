package com.test.vnay;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Customer implements Serializable{

	private static final long serialVersionUID = 5226608593778160592L;
	
	private String name;
	private int age;
	private List<Account> accounts;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", accounts=" + accounts + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accounts, age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accounts, other.accounts) && age == other.age && Objects.equals(name, other.name);
	}
	
}
