package naufalJmartFA;


public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0);
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1);
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2);
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3);
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4);
    
    private int bit;
    
    private ShipmentDuration(int bit){
        this.bit =  bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args){
        
        for (ShipmentDuration S:args){
            if (S == ShipmentDuration.INSTANT){
                bit |= (1 << 0);
            }else if (S == ShipmentDuration.SAME_DAY){
                bit |= (1 << 1);
            }else if (S == ShipmentDuration.NEXT_DAY){
                bit |= (1 << 2);
            }else if (S == ShipmentDuration.REGULER){
                bit |= (1 << 3);
            }else if (S == ShipmentDuration.KARGO){
                bit |= (1 << 4);
            }
            
        }
    }
    
    public boolean isDuration(ShipmentDuration reference){
        if (reference == ShipmentDuration.INSTANT){
            return (((bit & (1 << 0)) >> 0)) == 1;
        }else if (reference == ShipmentDuration.SAME_DAY){
            return (((bit & (1 << 1)) >> 1)) == 1;
        }else if (reference == ShipmentDuration.SAME_DAY){
            return (((bit & (1 << 2)) >> 2)) == 1;
        }else if (reference == ShipmentDuration.SAME_DAY){
            return (((bit & (1 << 3)) >> 3)) == 1;
        }else if (reference == ShipmentDuration.SAME_DAY){
            return (((bit & (1 << 4)) >> 4)) == 1;
        } else{
            return false;
        }
    }
    
    
    
    
}
