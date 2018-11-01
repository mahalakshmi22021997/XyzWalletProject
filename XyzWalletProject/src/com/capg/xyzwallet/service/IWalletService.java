package com.capg.xyzwallet.service;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.exception.WalletException;

public interface IWalletService {
	public boolean createAccount(WalletBean w) throws WalletException;
	public double showBalance();
	public boolean withDraw(double amount) throws WalletException;
	public boolean deposit(double amount) throws WalletException;
	public boolean printTransaction(LocalDateTime fDate,LocalDateTime tDate,String type);
	public boolean validations(WalletBean w) throws WalletException;
	boolean fundTransfer(BigInteger targetMobileNum, double amount)
			throws WalletException;
	public boolean validPhoneNumber(BigInteger targetMobileNum);
	boolean validAmount(double amount) throws WalletException;
}