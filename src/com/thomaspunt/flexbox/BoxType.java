package com.thomaspunt.flexbox;

import java.util.ArrayList;

/**
 * Hold the business logic for the valid box types and their respective attributes
 * in this simple POJO.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxType
{
    /**
     * The box type number.
     */
    private final int boxType;

    /**
     * All valid card grades this box type can have.
     */
    private ArrayList<Integer> grades = new ArrayList<>();

    /**
     * The colour print this box type can have.
     */
    private int print;

    /**
     * Whether this box type has a reinforced bottom or not.
     */
    private boolean reinforcedBottom;

    /**
     * Whether this box type has a reinforced bottom or not.
     */
    private boolean reinforcedCorners;

    /**
     * Set the box type.
     *
     * @param boxType  The box type to be set.
     */
    public BoxType(int boxType)
    {
        this.boxType = boxType;
    }

    /**
     * Get the box type.
     *
     * @return  The box type.
     */
    public int getBoxType()
    {
        return boxType;
    }

    /**
     * Get all valid grades of card this box type can have.
     *
     * @return  All the valid grades of card this box type can have.
     */
    public ArrayList<Integer> getGrades()
    {
        return grades;
    }
    
    /**
     * Add a grade to the valid grades this box type can have.
     *
     * @param grade  A grade of card this box type can have.
     */
    public void addGrade(int grade)
    {
        grades.add(grade);
    }

    /**
     * Get the colour print this box type can have.
     *
     * @return  The colour print of this box type.
     */
    public int getPrint()
    {
        return print;
    }
    
    /**
     * Set the colour print this box type can have.
     *
     * @param print  What the colour print for this box is.
     */
    public void setPrint(int print)
    {
        this.print = print;
    }

    /**
     * Get whether this box type has a reinforced bottom.
     *
     * @return  Whether the box has a reinforced bottom.
     */
    public boolean hasReinforcedBottom()
    {
        return reinforcedBottom;
    }
    
    /**
     * Set whether this box type has a reinforced bottom.
     *
     * @param rb  Whether the box has a reinforced bottom.
     */
    public void setReinforcedBottom(boolean rb)
    {
        reinforcedBottom = rb;
    }

    /**
     * Get whether this box type has reinforced corners.
     *
     * @return  Whether the box has reinforced corners.
     */
    public boolean hasReinforcedCorners()
    {
        return reinforcedCorners;
    }
    
    /**
     * Set whether this box type has reinforced corners.
     *
     * @param rc  Whether the box has reinforced corners.
     */
    public void setReinforcedCorners(boolean rc)
    {
        reinforcedCorners = rc;
    }

    /**
     * Perform a check against the input attributes of an order box to see if it is
     * of the same type.
     *
     * @param  grade     The grade of card the input box has.
     * @param  print     The colour print the input box has.
     * @param  rBottom   Whether the input box has a reinforced bottom.
     * @param  rCorners  Whether the input box has reinforced corners.
     * @return           Whether the input box has valid attributes to be considered
     *                   a type of this box.
     */
    public boolean checksum(int grade, int print, boolean rBottom, boolean rCorners)
    {
        return grades.contains(grade)
               && this.print == print
               && reinforcedBottom == rBottom
               && reinforcedCorners == rCorners;
    }
}