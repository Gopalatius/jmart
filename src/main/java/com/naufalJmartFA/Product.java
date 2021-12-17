package com.naufalJmartFA;


import com.naufalJmartFA.dbjson.Serializable;

/**
 * Product class for the product object.
 * Extends serializable because every product has an id.
 * @author Muhammad Naufal Faza
 */
public class Product extends Serializable
{

    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

    /**
     * Constructor to assign the parameter to the instance variables.
     * @param accountId The account id (should've been the product id)
     * @param name The name of the product
     * @param weight The weight of the product
     * @param conditionUsed Whether the product is already used
     * @param price Price of the product
     * @param discount The discount of the product
     * @param category Category of the product
     * @param shipmentPlans Shipment plans for the product
     */
    public Product(int accountId, String name, int weight, boolean conditionUsed,
    double price, double discount, ProductCategory category, byte shipmentPlans ){
         this.accountId = accountId;
         this.name = name;
         this.weight = weight;
         this.conditionUsed = conditionUsed;
         this.price = price;
         this.discount = discount;
         this.category = category;
         this.shipmentPlans = shipmentPlans;
     }

    /**
     * Method to format the product to string
     * @return the formatted product to string
     */
     @Override
    public String toString(){
        return "Name: "+name+"\nWeight: "+weight+"\nconditionUsed: "+conditionUsed+
        "\nprice: "+price+"\ndiscount: "+discount+"\nCategory: "+category+
        "\naccountId: "+accountId;
    }
    
}
