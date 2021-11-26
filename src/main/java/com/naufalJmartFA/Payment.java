package com.naufalJmartFA;

import java.util.ArrayList;
import java.util.Date;

public class Payment extends Invoice
{
    public ArrayList<Record> history = new ArrayList<Record>();
    public int productCount;
    public Shipment shipment;

    public Payment (int buyerId, int productId, int productCount,
                    Shipment shipment){
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;

    }
    public static class Record{
        public final Date date;
        public String message;
        public Status status;

        public Record (Status status, String message){
            this.date = new Date();
            this.message = message;
            this.status = status;
        }
    }

    @Override
    public double getTotalPay (Product product){
        return product.price* (1-product.discount);
    }
    
}
