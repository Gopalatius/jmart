package naufalJmartFA;



public class Recognizable
{
    public final int id;
    
    protected Recognizable(int id){
        this.id = id;
    }
    public boolean equals(Object object){
        if (object instanceof Recognizable){
            Recognizable recognizable = (Recognizable) object;
            return (recognizable.id == this.id);
        }else{
           return false;
        }
        
    }
    public boolean equals (Recognizable recognizable){
        return (this.id == recognizable.id); 
    }
}
