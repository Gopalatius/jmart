package com.naufalJmartFA.controller;

import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.Coupon;
import com.naufalJmartFA.dbjson.JsonTable;

import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Coupon controller to control coupon from front end to backend.
 * May not needed because of deadline.
 */
@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/coupon.json" )
    public static JsonTable<Coupon> couponTable;

    /**
     * getter for couponTable
     * @return couponTable
     */
    public JsonTable<Coupon> getJsonTable(){
        return couponTable;
    }

    /**
     * Whether the Coupon can be applied
     * @param id ID of the coupon
     * @param price price of the product
     * @param discount discount of the produc t
     * @return true if the coupon can be applied. Else, false.
     */
    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id,
                     @RequestParam double price,
                     @RequestParam double discount){
        Coupon coupon = Algorithm.<Coupon>find(getJsonTable(),pred -> pred.id == id);
        return coupon.canApply(price,discount);
    }

    /**
     * Get available coupon list that hasn't been used.
     * @param page the page
     * @param pageSize the page size
     * @return list of available coupon
     */
    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(@RequestParam int page,
                              @RequestParam int pageSize){

        List<Coupon> list1 = new ArrayList<Coupon>();
        for (Coupon i : getJsonTable()){
            if(!i.isUsed()){
                list1.add(i);
            }
        }
        return Algorithm.<Coupon>paginate(list1,page,pageSize, pred -> true);
    }

    /**
     * Get to know if the coupon is used or not
     * @param id ID of the coupon
     * @return true if the coupon is used. Else, false.
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Coupon coupon = Algorithm.<Coupon>find(getJsonTable(),pred -> pred.id == id);
        return coupon.isUsed();
    }
}
