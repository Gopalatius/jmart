package naufalJmartFA;



public abstract class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    @Override
    public int compareTo(Recognizable other){
//        return Recognizable.compareTo(other);
        return 0;
    }

    public boolean equals(Object other){
        if (other instanceof Recognizable){
            Recognizable recognizable = (Recognizable) other;
            return (recognizable.id == this.id);
        }else{
           return false;
        }
        
    }
    public boolean equals (Recognizable other){
        return (this.id == other.id);
    }
    public static <T> int getClosingId(Class<T> clazz){
//        if (clazz instanceof Recognizable){
//            return 0;
//        }
        return 0;
    }
    public static <T> int setClosingId(Class<T> clazz, int id){
//        if (clazz instanceof Recognizable){
//            return 0;
//        }
        return 0;
    }

}
