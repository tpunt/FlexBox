package com.thomaspunt.flexbox;

/**
 * This class holds the data associated with a single type of box specified 
 * from the box order form.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxOrder
{
    /**
     * The type of box according to the grade, colour print,
     * and whether it has reinforced bottoms and/or corners
     * or not.
     */
    private final int boxType;
    /**
     * The width of the box (in cm).
     */
    private final int width;
    /**
     * The height of the box (in cm).
     */
    private final int height;
    /**
     * The length of the box (in cm).
     */
    private final int length;
    /**
     * The grade of card used for the box.
     */
    private final int grade;
    /**
     * The colour print used on the box.
     */
    private final int colourPrint;
    /**
     * Whether the box has a reinforced bottom.
     */
    private final boolean reinforcedBottom;
    /**
     * Whether the box has reinforced corners.
     */
    private final boolean reinforcedCorners;
    /**
     * Whether the box has sealable tops.
     */
    private final boolean sealableTops;
    /**
     * The quantity of these boxes ordered.
     */
    private int quantity;

    /**
     * Create a new box order.
     *
     * @param boxType  The type of box.
     * @param width    The width of the box (in cm).
     * @param height   The height of the box (in cm).
     * @param length   The length of the box (in cm).
     * @param grade    The grade of card used for the box.
     * @param print    The colour print used on the box.
     * @param rb       Whether the box has a reinforced bottom.
     * @param rc       Whether the box has reinforced corners.
     * @param st       Whether the box has sealable tops.
     * @param q        The quantity of these boxes ordered.
     */
    public BoxOrder(int boxType
                  , int width
                  , int height
                  , int length
                  , int grade
                  , int print
                  , boolean rb
                  , boolean rc
                  , boolean st
                  , int q)
    {
        this.boxType = boxType;
        this.width = width;
        this.height = height;
        this.length = length;
        this.grade = grade;
        colourPrint = print;
        reinforcedBottom = rb;
        reinforcedCorners = rc;
        sealableTops = st;
        quantity = q;
    }

    /**
     * Get the box type according to the grade, colour print,
     * and whether it has a reinforced bottom or corners.
     *
     * @return The type of box.
     */
    public int getBoxType()
    {
        return boxType;
    }
    
    /**
     * Get the width of the box (in cm).
     *
     * @return The width of the box.
     */
    public int getWidth()
    {
        return width;
    }
    
    /**
     * Get the height of the box (in cm).
     *
     * @return The height of the box.
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * Get the length of the box (in cm).
     *
     * @return The length of the box.
     */
    public int getLength()
    {
        return length;
    }
    
    /**
     * Get the card grade of the box.
     *
     * @return The grade of card for the box.
     */
    public int getGrade()
    {
        return grade;
    }
    
    /**
     * Get the colour print of the box.
     *
     * @return The colour print of the box.
     */
    public int getColourPrint()
    {
        return colourPrint;
    }
    
    /**
     * Check to see whether the box has a reinforced bottom.
     *
     * @return Whether the box has a reinforced bottom.
     */
    public boolean hasReinforcedBottom()
    {
        return reinforcedBottom;
    }
    
    /**
     * Check to see whether the box has reinforced corners.
     *
     * @return Whether the box has reinforced corners.
     */
    public boolean hasReinforcedCorners()
    {
        return reinforcedCorners;
    }
    
    /**
     * Check to see whether the box has sealable tops.
     *
     * @return Whether the box has sealable tops.
     */
    public boolean hasSealableTops()
    {
        return sealableTops;
    }
    
    /**
     * Get the number of boxes requested.
     *
     * @return The quantity of boxes of this type ordered.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * Check to see if another box order is identical to this one.
     *
     * @param  boxOrder  The BoxOrder object to compare its properties.
     * @return           Whether the other box order is identical to this one.
     */
    public boolean isIdenticalBox(BoxOrder boxOrder)
    {
        return width == boxOrder.getWidth()
               && height == boxOrder.getHeight()
               && length == boxOrder.getLength()
               && grade == boxOrder.getGrade()
               && colourPrint == boxOrder.getColourPrint()
               && reinforcedBottom == boxOrder.hasReinforcedBottom()
               && reinforcedCorners == boxOrder.hasReinforcedCorners()
               && sealableTops == boxOrder.hasSealableTops();
    }

    /**
     * Add the quantity of the duplicate box order to this one, effectively
     * merging the orders together.
     *
     * @param quantity  The quantity of the other identical box order.
     */
    public void addQuantity(int quantity)
    {
        this.quantity += quantity;
    }
}