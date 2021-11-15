package naufalJmartFA;

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
    public void run (){

    }
    public int size(){
        return objectPool.size();
    }
}
