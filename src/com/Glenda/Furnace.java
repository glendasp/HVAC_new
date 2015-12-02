package com.Glenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by glendex on 10/30/15.
 */
public class Furnace  extends  ServiceCall{
    private int furnaceType;

    public Furnace(String serviceAddress, String problemDescription, Date date, int furnaceType) {

        super(serviceAddress, problemDescription, date);

        //TODO Error checking - is this a valid furnace type?
        this.furnaceType = furnaceType;
    }

    @Override
    public String toString() {

        String typeString = FurnaceTypeManager.getTypeString(furnaceType);
        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Furnace Service Call " + "\n" +
                "Service Address= " + serviceAddress + "\n" +
                "Problem Description = " + problemDescription  + "\n" +
                "Furnace Type = " + typeString + "\n" +
                "Reported Date = " + reportedDate + "\n" +
                "Resolved Date = " + resolvedDateString + "\n" +
                "Resolution = " + resolutionString + "\n" +
                "Fee = " + feeString ;

    }


    //Inner class to collect the different varieties of furnace
    //When we ask for the type, we'll use the constants from this class to display the choice of types.

    protected static class FurnaceTypeManager {

        protected static final int FORCED_AIR = 1;
        protected static final int BOILER = 2;
        protected static final int OCTOPUS = 3;

        static HashMap<Integer, String> furnaceTypes;

        //Inicia o bloco
        static {
            furnaceTypes = new HashMap<Integer, String>();
            furnaceTypes.put(FORCED_AIR,"Forced Air");
            furnaceTypes.put(BOILER,"Boiler/Radiators");
            furnaceTypes.put(OCTOPUS,"Older 'Octopus' Style");
        }

        public static String getTypeString(int typeInt) {

            if (furnaceTypes.containsKey(typeInt)) {
                return furnaceTypes.get(typeInt);
            }
            else {
                return "Unknown type";
            }

        }

        public static String furnaceTypeUserChoices() {

            //Pega todas as chaves enviado pelo hashmap e sort em ordem
            ArrayList<Integer> keys = new ArrayList<Integer>(furnaceTypes.keySet());
            Collections.sort(keys);


            //Monta e retorna as strings de todas as chaves e seus valores
            String userChoices = "";
            for (Integer k : keys) {
                userChoices = userChoices + k + " : " + furnaceTypes.get(k) + "\n";
            }
            return userChoices;
        }
    }
}


