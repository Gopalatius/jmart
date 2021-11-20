package com.naufalJmartFA.controller;

import com.naufalJmartFA.*;
import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 2;
    public static final long ON_PROGRESS_LIMIT_MS = 3;
    public static final long WAITING_CONF_LIMIT_MS = 4;

    @JsonAutowired(value = Account.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/randomProductList.json" )
    public static JsonTable<Payment> paymentTable;

    public static ObjectPoolThread<Payment> poolThread;

    @GetMapping
    public JsonTable getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/payment/{id}/accept")
    boolean accept (@PathVariable int id){
        return false;
    }
    @PostMapping("/payment/{id}/cancel")
    boolean cancel (@PathVariable int id){
        return false;
    }
    @PostMapping("/payment/create")
    Payment create (@RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan){
        return null;
    }
    @PostMapping("/payment/{id}/submit")
    boolean submit(@PathVariable int id, @RequestParam String receipt){
        return false;
    }
    @PostMapping("/payment/timeKeeper")
    private static boolean timeKeeper ( @RequestParam Payment payment){
        return false;
    }
}
