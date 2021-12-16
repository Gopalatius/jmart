package com.naufalJmartFA;

import java.util.Vector;
import java.util.function.Function;

/**
 * A poolthread class to run thread using multithreading.
 * @param <T> generic data types.
 * @author Muhammad Naufal Faza
 */
public class ObjectPoolThread<T> extends Thread {
    private boolean exitSignal = false;
    private Vector<T> objectPool = new Vector<>();
    private Function<T, Boolean> routine;

    /**
     * The default constructor.
     * @param name The name of the thread
     * @param routine what function does it want to be applied
     */
    public ObjectPoolThread (String name, Function<T, Boolean> routine){
        super(name);
        this.routine = routine;

    }

    /**
     * Constructor that will implicitly call the other constructor
     * @param routine what function does it want to be applied
     */
    public ObjectPoolThread (Function<T, Boolean> routine){

    }

    /**
     * add to objectpool synchronously so no racing condition will happened.
     * @param object the object that wanted to be add to the object pool.
     */
    synchronized public void add (T object){
        objectPool.add(object);
    }

    /**
     * The function to terminate the thread.
     */
    synchronized public void exit (){
        this.exitSignal = true;
    }

    /**
     * What to run when the thread starts
     */
    @Override
    public void run () {
        while (!this.exitSignal) {
            int lastSize = size() - 1;
            while(routine.apply(objectPool.get(lastSize)));

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            notifyAll();
        }
    }
    public int size(){
        return objectPool.size();
    }
}
