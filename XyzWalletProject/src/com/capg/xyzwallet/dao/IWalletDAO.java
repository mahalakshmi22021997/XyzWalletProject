package com.capg.xyzwallet.dao;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.bean.WalletTransaction;
import com.capg.xyzwallet.exception.WalletException;

public interface IWalletDAO {
	public boolean createAccount(WalletBean w);

	public double showBalance();

	public boolean withDraw(double amount) throws WalletException;

	public boolean deposit(double amount);

	public boolean printTransaction(LocalDateTime fDate,
			LocalDateTime tDate,String type);

	boolean fundTransfer(BigInteger targetMobileNum, double amount)
			throws WalletException;
}