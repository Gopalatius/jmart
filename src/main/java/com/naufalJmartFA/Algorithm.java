package com.naufalJmartFA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

/**
 * Class Algorithm to filter, collect, find, count, and find min and max
 * from a list.
 * @author Muhammad Naufal Faza
 */
public class Algorithm {
    /**
     * Default constructor consists of nothing because all the methods are
     * static.
     */
    private Algorithm(){
    }

    /**
     * Filtering an array
     * @param array The source of data that wants to be filtered.
     * @param value Value that matches with the data that wanted to be filtered.
     * @param <T> Generic
     * @return A filtered list
     */
    public static <T> List<T> collect (T[] array, T value){
        Predicate<T> predicate = value::equals;
        return collect(Arrays.stream(array).iterator(), predicate);
    }
    /**
     * Filtering an iterable
     * @param iterable The source of data that wants to be filtered.
     * @param value Value that matches with the data that wanted to be filtered.
     * @param <T> Generic
     * @return A filtered list
     */
    public static <T> List<T> collect (Iterable<T> iterable, T value){
        Predicate<T> predicate = value::equals;
        return collect(iterable.iterator(), predicate);
    }
    /**
     * Filtering an iterator
     * @param iterator The source of data that wants to be filtered.
     * @param value Value that matches with the data that wanted to be filtered.
     * @param <T> Generic
     * @return A filtered list
     */
    public static <T> List<T> collect (Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return collect(iterator, predicate);
    }
    /**
     * Filtering an array
     * @param array The source of data that wants to be filtered.
     * @param pred boolean expression from the lambda expression.
     * @param <T> Generic
     * @return A filtered list
     */
    public static <T> List<T> collect (T[] array, Predicate<T> pred){
        return collect(Arrays.stream(array).iterator(), pred);
    }
    /**
     * Filtering an iterable
     * @param iterable The source of data that wants to be filtered.
     * @param pred boolean expression from the lambda expression.
     * @param <T> Generic
     * @return A filtered list
     */
    public static <T> List<T> collect (Iterable<T> iterable, Predicate<T> pred){
        return collect(iterable.iterator(), pred);
    }
    /**
     * Filtering an iterator
     * @param iterator The source of data that wants to be filtered.
     * @param pred boolean expression from the lambda expression.
     * @param <T> Generic
     * @return A filtered list
     */
    public static <T> List<T> collect (Iterator<T> iterator, Predicate<T> pred){
        List<T> list = new ArrayList<T>();
        T obj;
        while (iterator.hasNext()) {
            obj = iterator.next();
            if (pred.predicate(obj)) {
                list.add(obj);
            }
        }
        return list;
    }

    /**
     * Counting how many value in an array
     * @param array the source array
     * @param value the value that wants to be counted
     * @param <T> generic
     * @return how many value are in the array
     */
    public static <T> int count(T[] array, T value){
        Predicate<T> predicate = value::equals;
        return count(Arrays.stream(array).iterator(), predicate);
    }
    /**
     * Counting how many value in an iterable.
     * @param iterable the source iterable
     * @param value the value that wants to be counted
     * @param <T> generic
     * @return how many value are in the iterable
     */
    public static <T> int count(Iterable<T> iterable, T value){
        Predicate<T> predicate = value::equals;
        return count(iterable.iterator(), predicate);
    }
    /**
     * Counting how many value in an iterator.
     * @param iterator the source iterable
     * @param value the value that wants to be counted
     * @param <T> generic
     * @return how many value are in the iterator
     */
    public static <T> int count(Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return count(iterator, predicate);
    }

    /**
     * Counting how many value in an array.
     * @param array the source array
     * @param pred the boolean expression expressed in lambda expression.
     * @param <T> generic
     * @return how many value are in the array
     */
    public static <T> int count(T[] array, Predicate<T> pred){
        return count(Arrays.stream(array).iterator(), pred);
    }
    /**
     * Counting how many value in an iterable.
     * @param iterable the source iterable.
     * @param pred the boolean expression expressed in lambda expression.
     * @param <T> generic
     * @return how many value are in the iterable.
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        return count(iterable.iterator(), pred);
    }
    /**
     * Counting how many value in an iterator.
     * @param iterator the source iterator.
     * @param pred the boolean expression expressed in lambda expression.
     * @param <T> generic
     * @return how many value are in the iterator.
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int counter = 0;
        while(iterator.hasNext()){
            if (pred.predicate(iterator.next())) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Check whether value exists in an array.
     * @param array the source array
     * @param value the value that wants to be checked.
     * @param <T> generic.
     * @return true if the value exists. Else, false.
     */
    public static <T> boolean exists(T[] array, T value){
        Predicate<T> predicate = value::equals;
        return exists(Arrays.stream(array).iterator(), predicate);
    }
    /**
     * Check whether value exists in an iterable.
     * @param iterable the source iterable
     * @param value the value that wants to be checked.
     * @param <T> generic.
     * @return true if the value exists. Else, false.
     */
    public static <T> boolean exists(Iterable<T> iterable, T value){
        Predicate<T> predicate = value::equals;
        return exists(iterable.iterator(), predicate);
    }
    /**
     * Check whether value exists in an iterator.
     * @param iterator the source iterator.
     * @param value the value that wants to be checked.
     * @param <T> generic.
     * @return true if the value exists. Else, false.
     */
    public static <T> boolean exists(Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return exists(iterator, predicate);
    }
    /**
     * Check whether value exists in an array.
     * @param array the source array
     * @param pred the boolean expression expressed in lambda expression.
     * @param <T> generic.
     * @return true if the value exists. Else, false.
     */
    public static <T> boolean exists(T [] array, Predicate<T> pred){
        return exists(Arrays.stream(array).iterator(), pred);
    }
    /**
     * Check whether value exists in an iterable.
     * @param iterable the source iterable.
     * @param pred the boolean expression expressed in lambda expression.
     * @param <T> generic.
     * @return true if the value exists. Else, false.
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        return exists(iterable.iterator(), pred);
    }
    /**
     * Check whether value exists in an iterator.
     * @param iterator the source iterator.
     * @param pred the boolean expression expressed in lambda expression.
     * @param <T> generic.
     * @return true if the value exists. Else, false.
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            if (pred.predicate(iterator.next())){
                return true;
            }
        }
        return false;
    }

    /**
     * Find value inside an array.
     * @param array the source array
     * @param value the value that wants to be found.
     * @param <T> generic
     * @return return the founded value
     */
    public static <T> T find (T[] array, T value){
        Predicate<T> predicate = value::equals;
        return find(Arrays.stream(array).iterator(), predicate);
    }
    /**
     * Find value inside an iterable.
     * @param iterable the source iterable
     * @param value the value that wants to be found.
     * @param <T> generic
     * @return return the founded value
     */
    public static <T> T find (Iterable<T> iterable, T value){
        Predicate<T> predicate = value::equals;
        return find(iterable.iterator(), predicate);
    }
    /**
     * Find value inside an iterator.
     * @param iterator the source iterator
     * @param value the value that wants to be found.
     * @param <T> generic
     * @return return the founded value
     */
    public static <T> T find (Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return find(iterator, predicate);
    }
    /**
     * Find value inside an array.
     * @param array the source array
     * @param pred boolean expression expressed in lambda expression.
     * @param <T> generic
     * @return return the founded value
     */
    public static <T> T find (T[] array, Predicate<T> pred){
        return find(Arrays.stream(array).iterator(), pred);
    }
    /**
     * Find value inside an iterable.
     * @param iterable the source iterable
     * @param pred boolean expression expressed in lambda expression.
     * @param <T> generic
     * @return return the founded value
     */
    public static <T> T find (Iterable<T> iterable, Predicate<T> pred){
        return find(iterable.iterator(), pred);
    }
    /**
     * Find value inside an iterable.
     * @param iterator the source iterable
     * @param pred boolean expression expressed in lambda expression.
     * @param <T> generic
     * @return return the founded value
     */
    public static <T> T find (Iterator<T> iterator, Predicate<T> pred){
        T temp;
        while (iterator.hasNext()){
            temp = iterator.next();
            if (pred.predicate(temp)){
                return temp ;
            }
        }
        return null;
    }

    /**
     * Find maximum from two value
     * @param first the first value
     * @param second the second value
     * @param <T> generic
     * @return which value is greater
     */
    public static <T extends Number> T max (T first, T second){
        if (first.doubleValue() > second.doubleValue()){
            return first;
        }else{
            return second;
        }
    }

    /**
     * Find maximum value from an array
     * @param array the source array
     * @param <T> generic
     * @return  the maximum value
     */
    public static <T extends Number> T max (T[] array){
        return max(Arrays.stream(array).iterator());
    }
    /**
     * Find maximum value from an iterable
     * @param iterable the source iterable
     * @param <T> generic
     * @return the maximum value
     */
    public static <T extends Number> T max (Iterable<T> iterable) {
        return max(iterable.iterator());
    }
    /**
     * Find maximum value from an iterator
     * @param iterator the source iterator
     * @param <T> generic
     * @return the maximum value
     */
    public static <T extends Number> T max (Iterator<T> iterator) {
        T terbesar = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terbesar = temp;
            }else if(temp.doubleValue() > terbesar.doubleValue()){
                terbesar = temp;
            }
        }
        return terbesar;
    }

    /**
     * Find maximum value from an two value
     * @param first the first value
     * @param second the second value
     * @param comparator the comparator object
     * @param <T> generic
     * @return the maximum value
     */
    public static <T extends Number> T max (T first, T second, Comparator<?super T> comparator) {
        if (comparator.compare(first,second) > 0){
            return first;
        }else{
            return second;
        }

    }
    /**
     * Find maximum from array using comparator
     * @param array the source array
     * @param comparator the comparator object
     * @param <T> generic
     * @return the maximum value
     */
    public static <T extends Number> T max (T[] array, Comparator<?super T> comparator) {
        return max(Arrays.stream(array).iterator(),comparator);
    }
    /**
     * Find maximum from iterable using comparator
     * @param iterable the source iterable
     * @param comparator the comparator object
     * @param <T> generic
     * @return the maximum value
     */
    public static <T extends Number> T max (Iterable<T> iterable, Comparator<?super T> comparator) {
        return max(iterable.iterator(), comparator);
    }
    /**
     * Find maximum from iterable using comparator
     * @param iterator the source iterator
     * @param comparator the comparator object
     * @param <T> generic
     * @return the maximum value
     */
    public static <T extends Number> T max (Iterator<T> iterator, Comparator<?super T> comparator) {
        T terbesar = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terbesar = temp;
            }else if(comparator.compare(temp,terbesar) > 0){
                terbesar = temp;
            }
        }
        return terbesar;
    }

    /**
     * Find the minimum value from two value
     * @param first the first value
     * @param second the second value
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (T first, T second){
        if (first.doubleValue() < second.doubleValue()){
            return first;
        }else{
            return second;
        }
    }
    /**
     * Find the minimum value from array
     * @param array the array source
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (T[] array){
        return min(Arrays.stream(array).iterator());
    }
    /**
     * Find the minimum value from iterable
     * @param iterable the iterable source
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (Iterable<T> iterable) {
        return min(iterable.iterator());
    }
    /**
     * Find the minimum value from iterable
     * @param iterator the iterator
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (Iterator<T> iterator) {
        T terkecil = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terkecil = temp;
            }else if(temp.doubleValue() < terkecil.doubleValue()){
                terkecil = temp;
            }
        }
        return terkecil;
    }
    /**
     * find the minimum of two value using comparator
     * @param first the first value
     * @param second the second value
     * @param comparator the comparator object
     * @param <T> generic
     * @return
     */
    public static <T extends Number> T min (T first, T second, Comparator<?super T> comparator) {

        T terkecil;
        if (comparator.compare(first,second) < 0){
            return first;
        }else{
            return second;
        }

    }

    /**
     * Finding minimum value using comparator of an array
     * @param array the source array
     * @param comparator the comparator object
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (T[] array, Comparator<?super T> comparator) {
        return min(Arrays.stream(array).iterator(), comparator);
    }
    /**
     * Finding minimum value using comparator of an iterable
     * @param iterable the source iterable
     * @param comparator the comparator object
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (Iterable<T> iterable, Comparator<?super T> comparator) {
        return min(iterable.iterator(), comparator);
    }

    /**
     * Finding minimum value using comparator of an iterator
     * @param iterator the source iterator
     * @param comparator the comparator object
     * @param <T> generic
     * @return the minimum value
     */
    public static <T extends Number> T min (Iterator<T> iterator, Comparator<?super T> comparator) {
        T terkecil = null;
        T temp;
        for (int counter = 0; iterator.hasNext(); counter++){
            temp = iterator.next();
            if (counter == 0){
                terkecil = temp;
            }else if(comparator.compare(temp,terkecil) < 0){
                terkecil = temp;
            }
        }
        return terkecil;
    }

    /**
     * filter the list and paginate
     * @param array the source array
     * @param page page
     * @param pageSize pagesize
     * @param pred boolean expression expressed in lambda expression
     * @param <T> generic
     * @return filtered and paginated list
     */
    public static <T> List<T> paginate (T[] array, int page, int pageSize, Predicate<T> pred){
        return paginate(Arrays.stream(array).iterator(), page, pageSize, pred);
    }
    /**
     * filter the list and paginate
     * @param iterable the source iterable
     * @param page page
     * @param pageSize pagesize
     * @param pred boolean expression expressed in lambda expression
     * @param <T> generic
     * @return filtered and paginated list
     */
    public static <T> List<T> paginate (Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        return paginate(iterable.iterator(), page, pageSize, pred);
    }
    /**
     * filter the list and paginate
     * @param iterator the source iterator
     * @param page page
     * @param pageSize pagesize
     * @param pred boolean expression expressed in lambda expression
     * @param <T> generic
     * @return filtered and paginated list
     */
    public static <T> List<T> paginate (Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        List<List<T>> newList = new ArrayList<List<T>>();
        List<T> filteredList = new ArrayList<T>();
        T obj;
        while (iterator.hasNext()){
            obj = iterator.next();
            if (pred.predicate(obj)){
                filteredList.add(obj);
            }
        }
        for (int i = 0; i < filteredList.size(); i += pageSize){
            newList.add(new ArrayList<T>(filteredList.subList
                    (i, Math.min(filteredList.size(), i + pageSize))));

        }
        return newList.get(page);
    }
}
