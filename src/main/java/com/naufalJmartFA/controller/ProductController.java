package com.naufalJmartFA.controller;



import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.dbjson.JsonTable;
import com.naufalJmartFA.Product;

import com.naufalJmartFA.ProductCategory;
import com.naufalJmartFA.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the product
 * @author Muhammad Naufal Faza
 */
@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{

    @JsonAutowired(value = Product.class,filepath ="/My Drive/PC/Kuliah/Semester 3/Pemrograman Berorientasi Objek/Praktikum/Testing/jmart/lib/product.json" )
    public static JsonTable<Product> productTable;

    /**
     * getter for the productTable
     * @return productTable
     */
    public JsonTable<Product> getJsonTable(){
        return productTable;
    }

    /**
     * Create product
     * @param accountId ID of the account
     * @param name name of the product
     * @param weight weight of the product
     * @param conditionUsed whether the product is used or not
     * @param price the price of the product
     * @param discount discount of the product
     * @param category category of the product
     * @param shipmentPlans shipment plan of the product
     * @return product if it is succesfully created
     */
    @PostMapping("/create")
    Product create (@RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans){

        return new Product(accountId,name,weight,conditionUsed,price,discount,category,shipmentPlans);
    }

    /**
     * Getting the all the product according to store
     * @param id ID of the product
     * @param page page
     * @param pageSize pagesize
     * @return product
     */
    @GetMapping("/{id}/store")
    List<Product> getProductByStore (@PathVariable int id,
                                     @RequestParam int page,
                                     @RequestParam int pageSize){
        return Algorithm.<Product>paginate(getJsonTable(),page,pageSize,pred -> pred.id ==
                id);
    }

    /**
     * Gettign the product that is filtered according to the condition
     * @param page page
     * @param pageSize page size
     * @param accountId the ID of the account
     * @param search strings to be search
     * @param minPrice minimum price
     * @param maxPrice maximum price
     * @param category category of the product
     * @return List of all filtered product
     */
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
        if (search.isBlank()){
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
