package com.naufalJmartFA;
import com.naufalJmartFA.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store object to store object inside an account (every account has the ability to create a store).
 * @author Muhammad Naufal Faza
 */
public class Store extends Serializable
{
    public static final String REGEX_NAME = "^[A-Z]{4,20}";
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;

    /**
     *
     * @param name The store name
     * @param address The address of the store
     * @param phoneNumber The phone number of the store
     * @param balance The balance of the store
     */
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    /**
     * Validate the store according to the regular expression
     * @return true if according to regex. Else, false.
     */
    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();
        
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(this.name);
        boolean matchFoundName = matcherName.find();
        
        return matchFoundPhone && matchFoundName;
    }
    public boolean read(String content){
        return false;
    }

    /**
     * String formatter for the store
     * @return the store formatted as string
     */
    public String toString(){
        return "name: "+name+"\naddress: "+address+"\nphoneNumber: "+phoneNumber+
                "\nbalance: "+balance ;
    }

}
