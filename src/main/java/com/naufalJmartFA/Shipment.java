package com.naufalJmartFA;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Shipment
{
    public static class Plan{
        public final byte bit;
        private Plan(byte bit){
            this.bit = bit;
        }
    }
    public final static Plan INSTANT = new Plan((byte)(1 << 0));
    public final static Plan SAME_DAY = new Plan((byte)(1 << 1));
    public final static Plan NEXT_DAY = new Plan((byte)(1 << 2));
    public final static Plan REGULER = new Plan((byte)(1 << 3));
    public final static Plan KARGO = new Plan((byte)(1 << 4));
    public final static SimpleDateFormat ESTIMATION_FORMAT = new
            SimpleDateFormat("E MMMM dd yyyy");
    public String address;
    public int cost;
    public byte plan;
    public String receipt;


    public Shipment(String address, int cost, byte plan,
    String receipt){
        this.address = address;
        this.cost = cost;
        this.receipt = receipt;
        this.plan = plan;

    }
    public String getEstimatedArrival (Date reference){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reference);
        if (this.plan == (byte)(1 << 4)){
            calendar.add(Calendar.DATE,5);
        }else if (this.plan == (byte)(1 << 3)){
            calendar.add(Calendar.DATE,2);
        }else if (this.plan == (byte)(1 << 2)){
            calendar.add(Calendar.DATE, 1);
        }
        return ESTIMATION_FORMAT.format(calendar);
    }
    public boolean isDuration(Plan reference){
        return ((this.plan & reference.bit) != 0);
    }
    public boolean isDUration(byte object, Plan reference ) { return ((object & reference.bit) != 0);}
}
