package com.naufalJmartFA.controller;


import com.naufalJmartFA.Account;
import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.JsonTable;
import com.naufalJmartFA.Store;
import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController 
{
	public static final String REGEX_EMAIL =
			"^[^\\.]*((?!\\.{2,}).)[A-Za-z0-9&~_*]+(?:\\.[A-Za-z0-9&~_*]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?[a-zA-Z]";
	public static final String REGEX_PASSWORD =
			"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)((?!\\s).)*[a-zA-Z\\d]{8,}$";
	public static final String REGEX_PATTERN_EMAIL = null;
	public static final String REGEX_PATTERN_PASSWORD = null;

	@JsonAutowired(value = Account.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/randomProductList.json" )
	public static JsonTable<Account> accountTable;

	public JsonTable<Account> getJsonTable(){
		return accountTable;
	}

	@GetMapping("/account/login")
	Account login(@RequestParam String email, @RequestParam String password){
		String generatedPassword = null;

		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++){
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
			}
			generatedPassword = sb.toString();
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		final String lambdaGeneratedPassword = generatedPassword;

		Account account = Algorithm.<Account>find(accountTable,var-> var.email==email &&
				var.password == lambdaGeneratedPassword);

		if (account != null){
			return account;
		}else{
			return null;
		}
	}


//	@GetMapping
//	String index() { return "account page"; }
	
	@PostMapping("/account/register")
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

		String generatedPassword = null;
		if (matchEmail && matchFoundPassword && !name.isBlank()){
			try{
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());
				byte[] bytes = md.digest();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < bytes.length; i++){
					sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
				}
				generatedPassword = sb.toString();
			}catch(NoSuchAlgorithmException e){
				e.printStackTrace();
			}
			return new Account(name, email, generatedPassword, 0);
		}else{
			return null;
		}

	}
	@PostMapping("/account/{id}/registerStore")
	Store registerStore (@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber){
		Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
		if (account.store == null){
			account.store = new Store(name, address, phoneNumber, 0);
			return account.store;
		}

		return null;
	}

	@PostMapping("/account/{id}/topUp")
	boolean topUp (@PathVariable int id, @RequestParam double balance){
		Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
		if (account != null){
			account.balance += balance;
			return true;
		}else{
			return false;
		}
	}
//	@GetMapping("/{id}")
//	String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}