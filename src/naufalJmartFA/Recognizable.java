package naufalJmartFA;



public abstract class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }

    public int compareTo(Recognizable other){
        return Integer.compare(this.id, other.id);
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
    public static <T extends Recognizable> int getClosingId(Class<T> clazz){
       
        return 0;
    }
    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id){

        return 0;
    }

}
