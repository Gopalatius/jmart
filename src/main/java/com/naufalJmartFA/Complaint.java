package com.naufalJmartFA;

import com.naufalJmartFA.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * An object to store the complaints.
 * @author Muhammad Naufal Faza
 */
public class Complaint extends Serializable
{
    public final Date date;
    public String desc;

    /**
     * The constructor for complaint has one parameter.
     * It will save the complaint description and also the date
     * of which the complaint is created.
     * @param desc The description of the complaint.
     */
    public Complaint (String desc){
        this.desc = desc;
        this.date = new Date();
    }

    /**
     * I guess this is a function to read Complaint.
     * The author is not really sure.
     * @param content A string.
     * @return always false.
     */
    public boolean read(String content){
        return false;
    }

    /**
     * A string formatter to format the complaint object.
     * @return the formatted string of the complaint object.
     */
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDesc = formatter.format(this.date);
        
        return "Complaint{date="+strDesc+", desc='"+this.desc+"'}";
    }
}
