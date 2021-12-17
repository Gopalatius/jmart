package com.naufalJmartFA.controller;


import com.naufalJmartFA.Account;
import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.dbjson.JsonTable;
import com.naufalJmartFA.Store;
import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller for Account
 * @author Muhammad Naufal Faza
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	public static final String REGEX_EMAIL =
			"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String REGEX_PASSWORD =
			"(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)((?!\\s).)*[a-zA-Z\\d]{8,}$";
	public static final String REGEX_PATTERN_EMAIL = null;
	public static final String REGEX_PATTERN_PASSWORD = null;

//	@JsonAutowired(filepath ="G:/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/a/b/AccountBaru.json", value = Account.class)
//	public static JsonTable<Account> accountTable;
//
	@JsonAutowired(filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/account.json", value = Account.class)
	public static JsonTable<Account> accountTable;

	/**
	 * getter for accountTable
	 * @return accountTable
	 */
	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}

	/**
	 * Post method for login
	 * @param email the email of the account user
	 * @param password the password of the account user
	 * @return account with matching email and password
	 */
	@PostMapping("/login")
	Account login(@RequestParam String email, @RequestParam String password){

		Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

		final String generatedPassword = hashPassword(password);

		if (findAccount != null && generatedPassword.equals(findAccount.password)){
			return findAccount;
		}else{
			return null;
		}
	}


//	@GetMapping
//	String index() { return "account page"; }

	/**
	 * Post method for registration
	 * @param name name of the account user
	 * @param email email of the account user
	 * @param password password of the account user
	 * @return Account of newly created account
	 */
	@PostMapping("/register")
	Account register
	(
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String password
	)
	{
		Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
		Matcher matcherEmail = patternEmail.matcher(email);
		boolean matchEmail = matcherEmail.find();

		Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
		Matcher matcherPassword = patternPassword.matcher(password);
		boolean matchFoundPassword = matcherPassword.find();
		Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));

		final String generatedPassword;
		if ( matchEmail && matchFoundPassword && !name.isBlank() && findAccount == null){
			generatedPassword = hashPassword(password);
			Account newAccount = new Account(name, email, generatedPassword, 0);

			accountTable.add(newAccount);
			return newAccount;
		}
		return null;
	}

	/**
	 * Post Method to register the store
	 * @param id ID of the account user
	 * @param name name of the store
	 * @param address address of the store
	 * @param phoneNumber phone number of the store
	 * @return the store
	 */
	@PostMapping("/{id}/registerStore")
	Store registerStore (@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber){
		Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
		if (account.store == null){
			account.store = new Store(name, address, phoneNumber, 0);
			return account.store;
		}
		return null;
	}

	/**
	 * Post Method to topUp the balance of the account
	 * @param id the ID of the account
	 * @param balance the balance that wants to be topped up
	 * @return true if topup success. Else, false.
	 */
	@PostMapping("/{id}/topUp")
	boolean topUp (@PathVariable int id, @RequestParam double balance){
		Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
		if (account != null && balance > 0){
			account.balance += balance;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Password hash method to hash password in register and login.
	 * @param password the password of the user account.
	 * @return hashed password
	 */
	String hashPassword(String password){
		String generatedPassword = null;
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte aByte : bytes) {
				sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return generatedPassword;
	}
//	@GetMapping("/{id}")
//	String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}