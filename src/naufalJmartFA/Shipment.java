package naufalJmartFA;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Shipment
{
     public static class MultiDuration
    {
        public final byte bit;
        
        public MultiDuration(Duration... args){
            byte bitTemp = 0;
            for (Duration S:args){
                bitTemp |= S.bit;
                
            }
            this.bit = bitTemp;
        }
        
        public boolean isDuration(Duration reference){
            return ((this.bit & reference.bit) != 0);
        }
    }
    public static class Duration
    {
        public final static Duration INSTANT = new Duration((byte)(1 << 0));
        public final static Duration SAME_DAY = new Duration((byte)(1 << 1));
        public final static Duration NEXT_DAY = new Duration((byte)(1 << 2));
        public final static Duration REGULER = new Duration((byte)(1 << 3));
        public final static Duration KARGO = new Duration((byte)(1 << 4));
        public final static SimpleDateFormat ESTIMATION_FORMAT = new
        SimpleDateFormat("E MMMM dd yyyy");
        public final byte bit;
        
        private Duration(byte bit){
            this.bit =  bit;
        }
        public String getEstimatedArrival (Date reference){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(reference);
            if (this.bit == (byte)(1 << 4)){
                calendar.add(Calendar.DATE,5);
            }else if (this.bit == (byte)(1 << 3)){
                calendar.add(Calendar.DATE,2);
            }else if (this.bit == (byte)(1 << 2)){
                calendar.add(Calendar.DATE, 1);
            }
            String date = ESTIMATION_FORMAT.format(calendar);
            return date;
        }
    }
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    public Shipment(String address, int shipmentCost, Duration duration,
    String receipt){
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }
    public boolean read (String content){
        return false;
    }
}
