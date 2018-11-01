package com.capg.xyzwallet.bean;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class WalletTransaction {

	public WalletTransaction() {
		super();
	}

	public WalletTransaction(LocalDateTime tDate, String tType,
			BigInteger receipentNumber, double amount, double balance) {
		super();
		this.tDate = tDate;
		this.tType = tType;
		this.receipentNumber = receipentNumber;
		this.amount = amount;
		this.balance = balance;
	}

	private LocalDateTime tDate;
	private String tType;
	private BigInteger receipentNumber;
	private double amount;
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime gettDate() {
		return tDate;
	}

	public void settDate(LocalDateTime date) {
		this.tDate = date;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public BigInteger getReceipentNumber() {
		return receipentNumber;
	}

	public void setReceipentNumber(BigInteger bigInteger) {
		this.receipentNumber = bigInteger;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
