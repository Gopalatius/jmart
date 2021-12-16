package com.naufalJmartFA;

import com.naufalJmartFA.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account object is an object to store the account
 * of jmart users.
 */
public class Account extends Serializable
{
    public static final String REGEX_EMAIL = 
    "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String REGEX_PASSWORD =
    "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)((?!\\s).)*[a-zA-Z\\d]{8,}$";
    public String name;
    public String email;
    public String password;
    public Store store;
    public double balance;

    /**
     * Constructor to initialitize the instance variables.
     * @param name is the name for the account owner
     * @param email is the email for the account owner (credentials for login).
     * @param password is the password of the account (credentials for login).
     * @param balance is the amount of money the account has (to buy products).
     */
    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.store = null;
    }

    /**
     * A function to validate whether the email and the password is according to
     * the regular expression.
     * @return true if according to regular expression. Else, false.
     */
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(this.REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);
        boolean matchFoundEmail = matcherEmail.find();
        
        Pattern patternPassword = Pattern.compile(this.REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.name);
        boolean matchFoundPassword = matcherPassword.find();
        
        return matchFoundEmail && matchFoundPassword;
        
    }

    /**
     * Convert the account to string.
     * @return the formatted account that turned into String.
     */
    public String toString(){
        return "name: "+name+"\nemail: "+email+"\npassword: "+password;
    }
}
