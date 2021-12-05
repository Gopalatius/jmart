package com.naufalJmartFA;
import com.naufalJmartFA.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Store extends Serializable
{
    public static final String REGEX_NAME = "^[A-Z]{4,20}";
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;

    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

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
    public String toString(){
        return "name: "+name+"\naddress: "+address+"\nphoneNumber: "+phoneNumber+
                "\nbalance: "+balance ;
    }

}
