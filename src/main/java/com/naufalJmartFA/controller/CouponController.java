package com.naufalJmartFA.controller;

import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.Coupon;
import com.naufalJmartFA.dbjson.JsonTable;

import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon> {
    @JsonAutowired(value = Coupon.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/coupon.json" )
    public static JsonTable<Coupon> couponTable;

    public JsonTable<Coupon> getJsonTable(){
        return couponTable;
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(@PathVariable int id,
                     @RequestParam double price,
                     @RequestParam double discount){
        Coupon coupon = Algorithm.<Coupon>find(getJsonTable(),pred -> pred.id == id);
        return coupon.canApply(price,discount);
    }
    @GetMapping("/getAvailable")
    List<Coupon> getAvailable(@RequestParam int page,
                              @RequestParam int pageSize){
        List<Coupon> list1 = Algorithm.<Coupon>collect(getJsonTable(), pred -> true);
        List<Coupon> list2 = new ArrayList<Coupon>();
        for (Coupon i : list1){
            if(!i.isUsed()){
                list2.add(i);
            }
        }
        return Algorithm.<Coupon>paginate(list2,page,pageSize, pred -> true);
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Coupon coupon = Algorithm.<Coupon>find(getJsonTable(),pred -> pred.id == id);
        return coupon.isUsed();
    }
}
