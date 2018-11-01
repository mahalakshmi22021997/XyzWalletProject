package com.capg.xyzwallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.bean.WalletTransaction;
import com.capg.xyzwallet.exception.ExceptionMessage;
import com.capg.xyzwallet.exception.WalletException;

public class WalletDAOImp implements IWalletDAO {
	WalletBean bean1 = new WalletBean();

	// Scanner scanner = new Scanner(System.in);
	ArrayList<WalletBean> custList = new ArrayList<WalletBean>();

	ArrayList<WalletTransaction> transList = new ArrayList<>();

	IWalletDAO dao = new WalletDAOImp();

	@Override
	public boolean deposit(double amount) {
		boolean isSuccessful = false;
		WalletTransaction transaction = new WalletTransaction();
		double balance;
		LocalDateTime date = LocalDateTime.now();
		for (WalletBean walletBean : custList) {

			transaction.setBalance(walletBean.getBalance());

			balance = walletBean.getBalance() + amount;
			if (custList.set(custList.indexOf(walletBean), walletBean) != null) {
				isSuccessful = true;
				transaction.setAmount(amount);
				transaction.settDate(date);
				transaction.settType("deposit");
				transaction.setReceipentNumber(walletBean.getPhoneNumber());
				transList.add(transaction);
			}

		}
		return isSuccessful;
	}

	@Override
	public boolean createAccount(WalletBean bean) {

		return custList.add(bean);
		// iWalletService.validations(bean);

	}

	@Override
	public double showBalance() {
		double balance = 0;

		for (WalletBean walletBean : custList) {
			balance = walletBean.getBalance();

		}
		return balance;
	}

	@Override
	public boolean withDraw(double amount) throws WalletException {
		boolean isSuccessful = false;
		WalletTransaction transaction = new WalletTransaction();
		double balance;
		for (WalletBean walletBean : custList) {
			if (walletBean.getBalance() < amount) {
				throw new WalletException(ExceptionMessage.ERRORLOWBALANCE);
			} else {
				transaction.setBalance(walletBean.getBalance());

				balance = walletBean.getBalance() - amount;
				if (custList.set(0, walletBean) != null) {
					isSuccessful = true;
				}
				LocalDateTime date = LocalDateTime.now();

				transaction.setAmount(amount);
				transaction.settDate(date);
				transaction.settType("withdraw");
				transaction.setReceipentNumber(walletBean.getPhoneNumber());
				transList.add(transaction);
			}

		}
		return isSuccessful;
	}

	@Override
	public boolean fundTransfer(BigInteger targetMobileNum, double amount)
			throws WalletException {
		boolean isSuccessful = false;
		WalletTransaction transaction = new WalletTransaction();
		double balance;
		LocalDateTime date = LocalDateTime.now();

		for (WalletBean walletBean : custList) {
			if (walletBean.getBalance() > amount) {
				balance = walletBean.getBalance() - amount;
				if (custList.set(custList.indexOf(walletBean), walletBean) != null) {
					isSuccessful = true;
					if (isSuccessful) {
						for (WalletBean walletBean2 : custList) {
							if (walletBean.getPhoneNumber() == targetMobileNum) {
								balance = walletBean2.getBalance() + amount;
								walletBean2.setBalance(balance);
								custList.set(custList.indexOf(walletBean2),
										walletBean2);
								transaction.setAmount(amount);
								transaction.settDate(date);
								transaction.settType("fundtransfer");
								transaction.setReceipentNumber(walletBean2
										.getPhoneNumber());
								transList.add(transaction);
							} else {
								isSuccessful = false;
								throw new WalletException(
										ExceptionMessage.ERRORPHONE);
								
							}
						}

					} else {
						isSuccessful = false;
					}
				}else{
					throw new WalletException(ExceptionMessage.ERRORNOTUPDATED);
				}
			} else {
				throw new WalletException(ExceptionMessage.ERRORBALANCE);
			}
		}
		return isSuccessful;

	}

	@Override
	public boolean printTransaction(LocalDateTime fDate,
			LocalDateTime tDate, String type) {
		ArrayList<WalletTransaction> result = new ArrayList<>();
		boolean isInserted = false;
		for (WalletTransaction walletTransaction : transList) {
			if (walletTransaction.gettDate().isAfter(fDate)
					&& walletTransaction.gettDate().isBefore(
							LocalDateTime.now())) {
				result.add(walletTransaction);
				isInserted = true;
			}
		}
		return isInserted;
	}
}