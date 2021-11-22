package com.naufalJmartFA.controller;

import com.naufalJmartFA.Algorithm;
import com.naufalJmartFA.JsonTable;
import com.naufalJmartFA.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/{id}")
    public default T getById(int id){
//        T obj = Algorithm.<T>find(getJsonTable(),pred -> pred.id == id);
//        ArrayList<T> list = (ArrayList<T>) getJsonTable();
//
////        for (T object: getJsonTable()){
////            if (object.id == id){
////                return object;
////            }
////        }
//        return Algorithm.<T>find(getJsonTable(),id);
        return null;
    }

    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
