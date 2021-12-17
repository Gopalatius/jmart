package com.naufalJmartFA;

/**
 * Product Rating class
 * @author Muhammad Naufal Faza
 */
public class ProductRating
{
    private long total;
    
    private long count;

    /**
     * Constructor of product rating.
     * Initialized total and count as 0.
     */
    public ProductRating(){
        total = 0;
        count = 0;
    }

    /**
     * Get the total of rating from the parameter
     * @param rating how many ratings does it want to add
     */
    public void insert(int rating){
        total += rating;
        count++;
    }

    /**
     * Get average of the total rating divided by the amount of user that rated it.
     * @return the average rating.
     */
    public double getAverage(){
        if (count == 0){
            return 0.0d;
        }
        return (double) total/count;
    }

    /**
     * A getter for the total count
     * @return the amount of count/user that has rated.
     */
    public long getCount(){
        return count;
    }

    /**
     * A getter for the total rating.
     * @return the total amount of rating that the user has rated.
     */
    public long getTotal(){
        return total;
    }
}
