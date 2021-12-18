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
        Product product = new Product(accountId,name,weight,conditionUsed,price,discount,category,shipmentPlans);
        productTable.add(product);
        return product;
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
     * Getting all the product, literally.
     * @param page which page
     * @param pageSize the page size
     * @return all the product
     */
    @GetMapping("/getProducts")
    List<Product> getProducts (@RequestParam String name,
                               @RequestParam int page,
                               @RequestParam int pageSize,
                               @RequestParam double lowestPrice,
                               @RequestParam double HighestPrice,
                               @RequestParam boolean conditionUsed,
                               @RequestParam ProductCategory category){
        List<Product> list1 = Algorithm.<Product>collect(getJsonTable(),pred -> pred.price >= lowestPrice &&
                pred.price <= HighestPrice && !conditionUsed && pred.category.equals(category));
        if (!name.isBlank()){
            list1 = Algorithm.<Product>paginate(list1,page,pageSize,pred -> pred.name.toLowerCase().contains(name.toLowerCase()));
        }else{
            list1 = Algorithm.<Product>paginate(list1,page,pageSize,pred -> true);
        }

        return list1;
    }

    /**
     * Gettign the product that is filtered according to the condition
     * @param page page
     * @param pageSize page size
     * @param search strings to be search
     * @param minPrice minimum price
     * @param maxPrice maximum price
     * @param category category of the product
     * @return List of all filtered product
     */
    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(@RequestParam int page,
                                     @RequestParam int pageSize,
                                     @RequestParam boolean conditionUsed,
                                     @RequestParam String search,
                                     @RequestParam double minPrice,
                                     @RequestParam double maxPrice,
                                     @RequestParam ProductCategory category){
        try
        {
            List<Product> filterPrice = null;
            if (minPrice != 0 && maxPrice != 0) {
                filterPrice = Algorithm.<Product>collect(productTable,prod -> prod.price >= minPrice && prod.price <= maxPrice);
            }else {
                filterPrice = Algorithm.<Product>collect(productTable,prod -> true);
            }
            List<Product> filterName = null;
            if(!search.isEmpty()) {
                filterName = Algorithm.<Product>collect(filterPrice,prod -> prod.name.toLowerCase().contains(search.toLowerCase()));
            }else {
                filterName = Algorithm.<Product>collect(filterPrice, prod -> true);
                return filterName;
            }
            List<Product> filterCategory = null;
            filterCategory = Algorithm.<Product>collect(filterName,prod -> prod.category == category);

            List<Product> filterCondition = null;
            filterCondition = Algorithm.<Product>collect(filterCategory,prod -> prod.conditionUsed == conditionUsed);

            List<Product> paginated = Algorithm.<Product>paginate(filterCondition, page, pageSize, prod -> true);
            return paginated;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

