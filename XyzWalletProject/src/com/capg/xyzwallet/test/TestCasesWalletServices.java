package com.capg.xyzwallet.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.xyzwallet.bean.WalletBean;
import com.capg.xyzwallet.bean.WalletTransaction;
import com.capg.xyzwallet.exception.WalletException;
import com.capg.xyzwallet.service.IWalletService;
import com.capg.xyzwallet.service.WalletServiceImp;

public class TestCasesWalletServices {
	private static IWalletService service = null;
	static ArrayList<WalletTransaction> list = null;

	@BeforeClass
	public static void test() {
		list = new ArrayList<>();
		service = new WalletServiceImp();
		list.add(new WalletTransaction(LocalDateTime.now(), "12",
				new BigInteger("7416381223"), 10, 20));
		list.add(new WalletTransaction(LocalDateTime.of(2019, 06, 25, 10, 20),
				"Deposit", new BigInteger("7416381223"), 10, 20));
		list.add(new WalletTransaction(LocalDateTime.of(2014, 06, 25, 10, 20),
				"Withdraw", new BigInteger("7416381223"), 10, 50));
		list.add(new WalletTransaction(LocalDateTime.of(1997, 06, 25, 10, 20),
				"Deposit", new BigInteger("7416381223"), 10, 20));
	}

	@Test
	public void TestprintTransaction() {

		Assert.assertFalse(service.printTransaction(
				LocalDateTime.of(2018, 06, 23, 11, 232), LocalDateTime.now(),
				"Deposit"));
	}

	@Test(expected = WalletException.class)
	public void testFnameForLength() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("ma");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test(expected = WalletException.class)
	public void testEmailNull() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(" ");
		walletBean.setAddress("chennai");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testEmailInvalid() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testpanvalid() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan("CWT2QQ2680");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertTrue(result);

	}

	@Test(expected = WalletException.class)
	public void testpanvalid1() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan("CWT2QQ2680");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertTrue(result);

	}

	@Test(expected = WalletException.class)
	public void testpanvalid2() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan("CWT2PP260"); // invalid lenght
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testpanvalid3() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan(" ");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testpanvalid4() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan("$WT2QQ2680 ");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testFnameForAlphabet() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("123maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertTrue(result);

	}

	@Test(expected = NullPointerException.class)
	public void testFnameForNotNull() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName(null);
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test
	public void testFnameForPositive() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");

		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.createAccount(walletBean);
		assertTrue(result);
	}

	@Test(expected = WalletException.class)
	public void testLnameForLength() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("abcd");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");

		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test(expected = WalletException.class)
	public void testLnameForAlphabet() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("87638276e87");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");

		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test(expected = NullPointerException.class)
	public void testLnameForNotNull() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName(null);
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");

		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test
	public void testLnameForPositive() throws Exception {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha434@gmail.com");
		walletBean.setAddress("chennai");
		;
		walletBean.setPhoneNumber(new BigInteger("7416368112"));
		boolean result = service.createAccount(walletBean);
		assertTrue(result);
	}

	@Test(expected = WalletException.class)
	public void testPhoneNumberForNumber() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("mahalakshmi");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha87898@gmail.com");
		walletBean.setAddress("chennai");

		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test(expected = WalletException.class)
	public void testPhoneNumberForLength() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		boolean result = service.createAccount(walletBean);
		assertFalse(result);
	}

	@Test
	public void testcheckBalancevalid() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setBalance(2000);

		boolean result = service.createAccount(walletBean);
		assertTrue(result);
	}

	@Test(expected = WalletException.class)
	public void testcheckBalanceForNegative() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setBalance(-2000);

		boolean result = service.createAccount(walletBean);
		assertTrue(result);
	}

	@Test(expected = WalletException.class)
	public void testAmountForPositiveValue() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setAmount(-45646);
		double amount = 600;
		walletBean.setBalance(-90000.00);
		boolean result = service.deposit(amount);
		assertFalse(result);
	}

	@Test
	public void testAmountForPositiveCase() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setBalance(77979.98);
		walletBean.setAmount(45646);
		boolean result = service.deposit(walletBean.getAmount());
		assertTrue(result);
	}

	@Test(expected = WalletException.class)
	public void testAddressNotNull() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setBalance(77979.98);
		walletBean.setAmount(45646);
		walletBean.setAddress(" ");
		boolean result = service.deposit(walletBean.getAmount());
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testAddressPositive() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("maha");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail("maha@gmail.com");
		walletBean.setAddress("chennai");
		walletBean.setBalance(77979.98);
		walletBean.setAmount(45646);
		walletBean.setAddress("chennai");
		boolean result = service.deposit(walletBean.getAmount());
		assertFalse(result);

	}

	@Test(expected = WalletException.class)
	public void testFundTransfer1() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan(" ");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.validations(walletBean);
		assertTrue(result);

	}

	@Test(expected = WalletException.class)
	public void testFundTransfer2() throws WalletException {
		WalletBean walletBean = new WalletBean();
		walletBean.setfName("8741");
		walletBean.setlName("pasumarthi");
		walletBean.setEmail(".com@acf");
		walletBean.setAddress("chennai");
		walletBean.setPan(" ");
		walletBean.setPhoneNumber(new BigInteger("9876543210"));
		boolean result = service.validations(walletBean);
		assertFalse(result);

	}

}
