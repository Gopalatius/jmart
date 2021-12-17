package com.naufalJmartFA.controller;

import com.naufalJmartFA.*;
import com.naufalJmartFA.dbjson.JsonAutowired;
import com.naufalJmartFA.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Controller for payment
 * @author Muhammad Naufal Faza
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 2;
    public static final long ON_PROGRESS_LIMIT_MS = 3;
    public static final long WAITING_CONF_LIMIT_MS = 4;

    @JsonAutowired(value = Account.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/payment.json" )
    public static JsonTable<Payment> paymentTable;

    public static ObjectPoolThread<Payment> poolThread;

    /**
     * Getter for payment table
     * @return paymentTable
     */
    @GetMapping
    public JsonTable getJsonTable(){
        return paymentTable;
    }

    /**
     * Whether the payment is accepted or not
     * @param id The payment ID
     * @return true if accepted. Else, false
     */
    @PostMapping("/{id}/accept")
    boolean accept (@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if (payment != null){
            if (payment.history.get(payment.history.size()-1).status ==
            Invoice.Status.WAITING_CONFIRMATION){
                payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS,""));
                return true;
            }
        }
        return false;
    }

    /**
     * Whether the payment can be cancelled
     * @param id ID of the payment
     * @return true if cancelled. Else, false.
     */
    @PostMapping("/{id}/cancel")
    boolean cancel (@PathVariable int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if (payment != null){
            if (payment.history.get(payment.history.size()-1).status ==
                    Invoice.Status.WAITING_CONFIRMATION){
                payment.history.add(new Payment.Record(Invoice.Status.CANCELLED,""));
                return true;
            }
        }
        return false;
    }

    /**
     * Create payment
     * @param buyerId ID of the account
     * @param productId ID of the product
     * @param productCount How many products are there
     * @param shipmentAddress Shipment address of the payment
     * @param shipmentPlan What shipment plan to used
     * @return Payment
     */
    @PostMapping("/create")
    Payment create (@RequestParam int buyerId,
                    @RequestParam int productId,
                    @RequestParam int productCount,
                    @RequestParam String shipmentAddress,
                    @RequestParam byte shipmentPlan){

        Account account = Algorithm.<Account>find(new AccountController().getJsonTable(),pred -> pred.id == buyerId);
        Product product = Algorithm.<Product>find(new ProductController().getJsonTable(), pred -> pred.id == productId);
        Shipment shipment = new Shipment(shipmentAddress,0,shipmentPlan,null);
        Payment payment = new Payment(buyerId,productId,productCount,shipment);
        double price = payment.getTotalPay(product);
        boolean lebihBesar = account.balance >= price;


        if (account != null && product != null  &&
        lebihBesar){
            account.balance -= price;
            payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION,"waiting"));
            paymentTable.add(payment);
            poolThread.add(payment);
            return payment;
        }
        return null;
    }

    /**
     * Submit payment
     * @param id ID of the payment
     * @param receipt Receipt of the payment
     * @return true if submitted. Else, false
     */
    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, @RequestParam String receipt){
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if (payment != null){
            if (payment.history.get(payment.history.size()-1).status ==
                    Invoice.Status.ON_PROGRESS && !receipt.isBlank()){
                payment.shipment.receipt = receipt;
                payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY,""));
                return true;
            }
        }
        return false;
    }

    /**
     * Time keeper for the payment
     * @param payment the payment that wanted to be watch for the time
     * @return true if timeKepeer succeded. Else, false
     */
    @PostMapping("/timeKeeper")
    private static boolean timeKeeper ( @RequestParam Payment payment){
        Date now = new Date();
        int indexOfLastRecord = payment.history.size()-1;
        Payment.Record temp = payment.history.get(indexOfLastRecord);
        Payment.Record temp2 = new Payment.Record(null,null);


        if (((temp.status == Invoice.Status.WAITING_CONFIRMATION) &&
                (now.getTime() - temp.date.getTime() > WAITING_CONF_LIMIT_MS)) ||
                ((temp.status == Invoice.Status.ON_PROGRESS) &&
                        (now.getTime() - temp.date.getTime() > ON_PROGRESS_LIMIT_MS)))
        {
            temp2.status = Invoice.Status.FAILED;
            temp2.message = "Waduh gagal!";
        }else if((temp.status == Invoice.Status.ON_DELIVERY) && (now.getTime() -
                temp.date.getTime() > ON_DELIVERY_LIMIT_MS)){
            temp2.status = Invoice.Status.DELIVERED;
            temp2.message = "Berhasil dikirim!";
        } else if ((temp.status == Invoice.Status.DELIVERED) && (now.getTime() -
                temp.date.getTime() > DELIVERED_LIMIT_MS)){
            temp2.status = Invoice.Status.FINISHED;
            temp2.message = "Selesai!";
        } else {
            return false;
        }
        payment.history.add(temp2);
        return true;
    }
}
