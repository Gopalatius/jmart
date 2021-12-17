package com.naufalJmartFA;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Shipment object for shipment
 * @author Muhammad Naufal Faza
 */
public class Shipment
{
    /**
     * Object for the shipment plan
     */
    public static class Plan{
        public final byte bit;

        /**
         * Specify the plan
         * @param bit accept whether the bit is 1, 2, 4 8, or 16
         */
        private Plan(byte bit){
            this.bit = bit;
        }
    }

    /**
     * The Instant plan is bit 1
     */
    public final static Plan INSTANT = new Plan((byte)(1 << 0));
    /**
     * The Same Day plan is bit 2
     */
    public final static Plan SAME_DAY = new Plan((byte)(1 << 1));
    /**
     * The next day plan is bit 4
     */
    public final static Plan NEXT_DAY = new Plan((byte)(1 << 2));
    /**
     * The reguler plan is byte 8
     */
    public final static Plan REGULER = new Plan((byte)(1 << 3));
    /**
     * The Kargo plan is byte 16
     */
    public final static Plan KARGO = new Plan((byte)(1 << 4));
    /**
     * This is a variable to format the date.
     */
    public final static SimpleDateFormat ESTIMATION_FORMAT = new
            SimpleDateFormat("E MMMM dd yyyy");
    public String address;
    public int cost;
    public byte plan;
    public String receipt;

    /**
     * The constructor that returns the param to the instance variables.
     * @param address The the address of the receiver.
     * @param cost The cost of the shipment.
     * @param plan The shipment plan.
     * @param receipt The receipt of the shipment.
     */
    public Shipment(String address, int cost, byte plan,
    String receipt){
        this.address = address;
        this.cost = cost;
        this.receipt = receipt;
        this.plan = plan;

    }

    /**
     * The estimated arrival of the shipment plan
     * @param reference the date reference
     * @return the date reference + how many days should it be received according to the shipment plan.
     */
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

    /**
     * Check the duration
     * @param reference the plan that wants to be referenced
     * @return whether the reference matches the plan
     */
    public boolean isDuration(Plan reference){
        return ((this.plan & reference.bit) != 0);
    }

    /**
     * Check the duration by comparing the bit
     * @param object the bit that wants to be compared
     * @param reference the reference bit that wants to be compared
     * @return whether the duration matches
     */
    public static boolean isDUration(byte object, Plan reference ) { return ((object & reference.bit) != 0);}
}
