package com.naufalJmartFA.controller;

import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.dbjson.JsonTable;
import com.naufalJmartFA.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        T obj = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);

        return obj;
    }

    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam(defaultValue = "2") int page,@RequestParam(defaultValue = "5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
