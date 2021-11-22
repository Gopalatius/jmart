package com.naufalJmartFA.controller;



import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.JsonTable;
import com.naufalJmartFA.Product;

import com.naufalJmartFA.ProductCategory;
import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{

    @JsonAutowired(value = Product.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/randomProductList.json" )
    public static JsonTable<Product> productTable;

    public JsonTable<Product> getJsonTable(){
        return productTable;
    }

    @PostMapping("/create")
    Product create (@RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans){
        //belum selesai
        return new Product(accountId,name,weight,conditionUsed,price,discount,category,shipmentPlans);
    }

    @GetMapping("/{id}/store")
    List<Product> getProductByStore (@PathVariable int id,
                                     @RequestParam int page,
                                     @RequestParam int pageSize){
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize,pred -> pred.id ==
                id);
    }
    @GetMapping("/getProductFiltered")
    List<Product> getProductFiltered (@RequestParam int page,
                                     @RequestParam int pageSize,
                                      @RequestParam int accountId,
                                      @RequestParam String search,
                                      @RequestParam int minPrice,
                                      @RequestParam int maxPrice,
                                      @RequestParam ProductCategory category){
        ArrayList<Product> list1 = (ArrayList<Product>) Algorithm.<Product>collect(getJsonTable(), pred -> pred.accountId == accountId &&
                pred.category == category);
        if (search == null){
            return null;
        }
        search = search.toLowerCase();
        ArrayList<Product> list2 = new ArrayList<Product>();
        for (Product i : list1){
            if (i.name.toLowerCase().contains(search)){
                list2.add(i);
            }
        }
        if (minPrice == 0 && maxPrice == 0){
            list2 = null;
        }else if (maxPrice == 0){
            list2 = (ArrayList<Product>) Algorithm.<Product>collect(list2, pred -> pred.price >= minPrice);
        }else if (minPrice == 0){
            list2 = (ArrayList<Product>) Algorithm.<Product>collect(list2, pred -> pred.price <= maxPrice);
        }else{
            list2 = (ArrayList<Product>) Algorithm.<Product>collect(list2, pred -> pred.price >= minPrice && pred.price <= maxPrice);
        }

        return Algorithm.<Product>paginate(list2,page,pageSize,pred -> true);
    }
}
