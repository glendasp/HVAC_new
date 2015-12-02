package com.Glenda;

import java.util.Date;

/**
 * Created by glendex on 10/30/15.
 */
public class WaterHeater extends ServiceCall {
    private String age ;
    private static  double cityfee = 20.00 ;

    public WaterHeater(String serviceAddress, String problemDescription, Date date , String age) {
        super(serviceAddress, problemDescription, date);
        this.age= age;

    }

    public String toString (){

        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);
        String totalString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee + cityfee);



        return "Water Heater Unit Service Call " + "\n" +
                "Water Heater age " + this.age + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString + "\n" +
                "City Fee = $" + cityfee  + "\n" +
                "Total Cost = "  + totalString +"\n"
                ;
    }
}
