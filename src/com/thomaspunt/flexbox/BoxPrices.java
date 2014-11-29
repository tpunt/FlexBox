package com.thomaspunt.flexbox;

import java.io.FileNotFoundException;
import org.json.JSONException;

/**
 * A wrapper class around the BoxPricesConfig class, using its box prices pulled
 * from the configuration file to perform price calculations for BoxOrder objects.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxPrices
{
    /**
     * The BoxPricesConfig variable containing all box price information.
     */
    private final BoxPricesConfig boxPrices; 
    
    /**
     * Set the boxPrices variable.
     *
     * @throws FileNotFoundException  Thrown if the box prices config file cannot be found.
     * @throws JSONException          Thrown if the JSON file has an invalid syntax or if it
     *                                cannot be parsed properly.
     */
    public BoxPrices() throws FileNotFoundException, JSONException
    {
        boxPrices = new BoxPricesConfig();
    }
    
    /**
     * Calculate the order price for the Order object specified. It must loop through
     * every box type in the order to calculate the total order price.
     *
     * @param order  The order object containing each box order information.
     * @return       The total order price.
     */
    public double calculateOrderPrice(Order order)
    {
        double boxOrderPrice = 0.0;

        for(BoxOrder boxOrder : order.getBoxOrders())
            boxOrderPrice += calculateBoxPrice(boxOrder);

        return boxOrderPrice;
    }
    
    /**
     * Calculate a single box order price.
     * 
     * @param box  The BoxOrder object containing the information for the box order.
     * @return     The price of the box order.
     */
    private double calculateBoxPrice(BoxOrder box)
    {
        double boxPrice = 0.0;
        
        double areaPrice = calculateAreaPrice(
                                    calculateArea(box.getWidth()
                                                , box.getHeight()
                                                , box.getLength())
                                  , box.getGrade());
        
        int boxAdditionalsPerc = calculateBoxAdditionalsPerc(box.getColourPrint()
                                                           , box.hasReinforcedBottom()
                                                           , box.hasReinforcedCorners()
                                                           , box.hasSealableTops());
        
        if(boxAdditionalsPerc != 0)
            boxPrice += (areaPrice + areaPrice * boxAdditionalsPerc / 100)
                       * box.getQuantity();
        else
            boxPrice += areaPrice * box.getQuantity();
        
        return boxPrice;
    }
    
    /**
     * Calculate the surface area of a box in metres squared.
     *
     * @param width   The width of the box (in cm)
     * @param height  The height of the box (in cm)
     * @param length  The length of the box (in cm)
     * @return        The box surface area in metres squared.
     */
    private double calculateArea(int width, int height, int length)
    {
        return (width * height * 2 + width * length * 2 + height * length * 2) / 10000.0;
    }
    
    /**
     * Calculate the box area price according to the box surface area and the
     * grade of card used to build the box.
     *
     * @param area   The surface area of the box in metres squared.
     * @param grade  The grade of card used for the box.
     * @return       The base price of the box without any additionals.
     */
    private double calculateAreaPrice(double area, int grade)
    {
        return area * boxPrices.getBoxGradePrice(grade);
    }
    
    /**
     * Calculate the total percentage of all box additionals.
     *
     * @param colourPrint        The colour print used on the box.
     * @param reinforcedBottom   Whether the box has a reinforced bottom.
     * @param reinforcedCorners  Whether the box has reinforced corners.
     * @param sealableTops       Whether the box has sealable tops.
     * @return                   The total percentage of all box additionals.
     */
    private int calculateBoxAdditionalsPerc(int colourPrint
                                          , boolean reinforcedBottom
                                          , boolean reinforcedCorners
                                          , boolean sealableTops)
    {
        int extrasPerc = 0;
        
        if(colourPrint != 0)
            extrasPerc += boxPrices.getColourPrintPrice(colourPrint);
        
        if(reinforcedBottom)
            extrasPerc += boxPrices.getReinforcedBottomPrice();
        
        if(reinforcedCorners)
            extrasPerc += boxPrices.getReinforcedCornersPrice();
        
        if(sealableTops)
            extrasPerc += boxPrices.getSealableTopsPrice();
        
        return extrasPerc;
    }
}
