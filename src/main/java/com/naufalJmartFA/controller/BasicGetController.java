package com.naufalJmartFA.controller;

import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.dbjson.JsonTable;
import com.naufalJmartFA.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * A public interface for GetController. Other controller inherits from this class.
 * @param <T> generic
 * @author Muhammad Naufal Faza
 */
@RestController
public interface BasicGetController <T extends Serializable> {
    /**
     * Getting the object by ID of the account user.
     * @param id The account user ID
     * @return the object that wanted to be found based on the ID
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        T obj = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);

        return obj;
    }

    /**
     * Getter to getJsonTable
     * @return jsonTable of the inherited class
     */
    public abstract JsonTable<T> getJsonTable();

    /**
     * Getting the page of the inherited object later.
     * @param page the page
     * @param pageSize the page size
     * @return list of paginated page.
     */
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam(defaultValue = "2") int page,@RequestParam(defaultValue = "5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
