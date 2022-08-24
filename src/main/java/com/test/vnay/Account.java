package com.test.vnay;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable{

	private static final long serialVersionUID = 682911627708932038L;
	
	private String accountNumber;
	private String accountType;
	private String branchPostalCode;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getBranchPostalCode() {
		return branchPostalCode;
	}
	public void setBranchPostalCode(String branchPostalCode) {
		this.branchPostalCode = branchPostalCode;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", branchPostalCode="
				+ branchPostalCode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType, branchPostalCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(branchPostalCode, other.branchPostalCode);
	}
	
	

}
