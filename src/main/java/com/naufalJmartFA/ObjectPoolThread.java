package com.naufalJmartFA;

import java.util.Vector;
import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread {
    private boolean exitSignal = false;
    private Vector<T> objectPool;
    private Function<T, Boolean> routine;

    public ObjectPoolThread (String name, Function<T, Boolean> routine){
        super(name);
        this.routine = routine;

    }
    public ObjectPoolThread (Function<T, Boolean> routine){

    }
    synchronized public void add (T object){
        objectPool.add(object);
    }
    synchronized public void exit (){
        this.exitSignal = true;
    }
    @Override
    public void run () {
        while (!this.exitSignal) {
            int lastSize = objectPool.size() - 1;
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
