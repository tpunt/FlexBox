package com.thomaspunt.flexbox;

import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parse the box prices JSON config file and populate the instance variables with
 * the price data.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxPricesConfig
{
    /**
     * The prices of each grade of card.
     */
    private HashMap<Integer, Double> gradePrices = new HashMap<>();
    
    /**
     * The colour prints available and their respective prices.
     */
    private HashMap<Integer, Integer> colourPrintPrices = new HashMap<>();
    
    /**
     * The price for a box with a reinforced bottom.
     */
    private int reinforcedBottomPrice;
    
    /**
     * The price for a box with reinforced corners.
     */
    private int reinforcedCornersPrice;
    
    /**
     * The price for a box with sealable tops.
     */
    private int sealableTopsPrice;
    
    /**
     * The default configuration file for storing box prices (if one is not specified
     * on class instantiation).
     */
    private static final String boxPricesConfigFile = System.getProperty("user.dir")
                                             + "/src/com/thomaspunt/flexbox/config/boxPrices.json";

    /**
     * Parse the JSON file of box prices and save the box prices to instance variables
     * of this object.
     *
     * @param  fileName               The name of the config file to be loaded in.
     * @throws FileNotFoundException  Thrown if the box prices config file cannot be found.
     * @throws JSONException          Thrown if the JSON file has an invalid syntax or if it
     *                                cannot be parsed properly.
     */
    public BoxPricesConfig(String fileName) throws FileNotFoundException, JSONException
    {
        String priceConfig = new Scanner(new File(fileName)).useDelimiter("\\A").next();

        JSONObject rootObject = new JSONObject(priceConfig); // Parse the JSON to a JSONObject
        JSONArray grades = rootObject.getJSONArray("cardGradePrices");

        for(int i = 0; i < grades.length(); ++i) { // Loop over each object
            JSONObject boxGrade = grades.getJSONObject(i);
            gradePrices.put((Integer) boxGrade.get("grade"), (Double) boxGrade.get("price"));
        }

        JSONArray boxAdditionals = rootObject.getJSONArray("boxAdditionalPrices");

        for(int i = 0; i < boxAdditionals.length(); ++i) { // Loop over each object
            JSONObject boxAddon = boxAdditionals.getJSONObject(i);
            String type = (String) boxAddon.get("type");

            switch(type) {
                case "colourPrint":
                    colourPrintPrices.put((Integer) boxAddon.get("value"), (Integer) boxAddon.get("price"));
                    break;
                case "reinforcedBottom":
                    reinforcedBottomPrice = (Integer) boxAddon.get("price");
                    break;
                case "reinforcedCorners":
                    reinforcedCornersPrice = (Integer) boxAddon.get("price");
                    break;
                case "sealableTops":
                    sealableTopsPrice = (Integer) boxAddon.get("price");
                    break;
            }
        }
    }
    
    /**
     * Provide an optional constructor so that the default config file can be loaded.
     *
     * @throws FileNotFoundException  Thrown if the box prices config file cannot be found.
     * @throws JSONException          Thrown if the JSON file has an invalid syntax or if it
     *                                cannot be parsed properly.
     */
    public BoxPricesConfig() throws FileNotFoundException, JSONException
    {
        this(boxPricesConfigFile);
    }
    
    /**
     * Gets the box grade prices in key => value form, where the key is the box grade,
     * and the value is the price for that box grade.
     *
     * @return  The hash map of box grade prices.
     */
    public HashMap<Integer, Double> getBoxGradePrices()
    {
        return gradePrices;
    }
    
    /**
     * Get a single box grade price for the specified box grade.
     *
     * @param  grade  The grade of card.
     * @return        The corresponding price of the grade specified.
     */
    public double getBoxGradePrice(int grade)
    {
        return gradePrices.get(grade);
    }
    
    /**
     * Get the colour print price for the specified colour print.
     *
     * @param  colourPrint  The colour print type.
     * @return              The corresponding price for the specified colour print
     *                      (as a percentage of the base box price).
     */
    public int getColourPrintPrice(int colourPrint)
    {
        return colourPrintPrices.get(colourPrint);
    }
    
    /**
     * Get the price of a box that has a reinforced bottom
     *
     * @return  The price (as a percentage of the base box price) of a reinforced bottom.
     */
    public int getReinforcedBottomPrice()
    {
        return reinforcedBottomPrice;
    }
    
    /**
     * Get the price of a box that has a reinforced bottom
     *
     * @return  The price (as a percentage of the base box price) of reinforced corners.
     */
    public int getReinforcedCornersPrice()
    {
        return reinforcedCornersPrice;
    }
    
    /**
     * Get the price of a box that has a reinforced bottom
     *
     * @return  The price (as a percentage of the base box price) of sealable tops.
     */
    public int getSealableTopsPrice()
    {
        return sealableTopsPrice;
    }
}