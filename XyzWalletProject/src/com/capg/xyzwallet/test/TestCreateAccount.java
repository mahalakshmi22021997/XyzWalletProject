package com.capg.xyzwallet.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.exception.WalletException;
import com.capg.xyzwallet.service.IWalletService;
import com.capg.xyzwallet.service.WalletServiceImp;

public class TestCreateAccount {

	private static  IWalletService service=null;
	 @BeforeClass
	public static void createInstance(){
		service=new WalletServiceImp();
	}
	 @Test(expected=WalletException.class)
	 public void testFnameForLength() throws WalletException{
	 	WalletBean walletBean=new WalletBean();
	 	walletBean.setfName("ma");
	 	walletBean.setlName("pasumarthi");
	 	walletBean.setEmail("maha@gmail.com");
	 	walletBean.setAddress("chennai");
	 	walletBean.setPhoneNumber(new BigInteger ("9876543210"));
	 	boolean result=service.createAccount(walletBean);
	 	assertFalse(result);
	 }


}
