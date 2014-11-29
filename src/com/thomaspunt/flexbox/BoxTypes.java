package com.thomaspunt.flexbox;

import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * A wrapper class around the BoxTypesConfig class, using the box types pulled
 * from the configuration file to perform validations against the user input boxes.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxTypes
{
    /**
     * Holds all of the business logic (in BoxType objects) so that comparisons can be
     * performed against this variable from user input box types.
     */
    private final BoxTypesConfig boxTypes;
    
    /**
     * Get the valid box types and store them in an instance variable.
     *
     * @throws FileNotFoundException  Thrown if the config file cannot be found.
     * @throws IOException            Thrown if there is a problem parsing the config file.
     */
    public BoxTypes() throws FileNotFoundException, IOException
    {
        boxTypes = new BoxTypesConfig();
    }

    /**
     * Gets the box type according to the corresponding attributes entered by the user.
     *
     * @param  grade     The grade of card entered.
     * @param  print     The colour print entered.
     * @param  rBottom   Whether the entered box has a reinforced bottom.
     * @param  rCorners  Whether the entered box has reinforced corners.
     * @return           Returns -1 if the entered box is invalid (i.e. one or more
     *                   of its attributes don't align to the valid box type attributes),
     *                   or the box type number for a valid box type.
     */
    public int checkBoxType(int grade, int print, boolean rBottom, boolean rCorners)
    {
        int boxTypeN = -1;
        
        for(BoxType boxType : boxTypes.getBoxTypes())
            if(boxType.checksum(grade, print, rBottom, rCorners)) {
                boxTypeN = boxType.getBoxType();
                break;
            }
        
        return boxTypeN;
    }
}
