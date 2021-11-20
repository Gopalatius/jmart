package com.naufalJmartFA.controller;

import com.naufalJmartFA.*;
import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public JsonTable getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/{id}/accept")
    boolean accept (int id){
        return false;
    }
    boolean cancel (int id){
        return false;
    }
    Payment create (int buyerId, int productId, int productCount, String shipmentAddress,
                    byte shipmentPlan){
        return null;
    }
    boolean submit(int id, String receipt){
        return false;
    }
    private static boolean timeKeeper (Payment payment){
        return false;
    }
}
