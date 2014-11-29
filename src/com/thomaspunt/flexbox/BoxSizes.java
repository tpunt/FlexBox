package com.thomaspunt.flexbox;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * A wrapper class around the BoxSizesConfig class, using its box sizes pulled
 * from the configuration file to perform validations against the input sizes.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxSizes
{
    /**
     * Store the box size limits in key => value fashion.
     */
    private final BoxSizesConfig boxSizes;
    
    /**
     * Get the box sizes and populate the boxSizes instance variable.
     * 
     * @throws FileNotFoundException  Thrown if the target config file cannot be found.
     * @throws IOException            Thrown if the BufferedReader throws an IOException.
     */
    public BoxSizes() throws FileNotFoundException, IOException
    {
        boxSizes = new BoxSizesConfig();
    }

    /**
     * Checks to see if the width specified is within the range of valid widths.
     *
     * @param  width  The input width.
     * @return        Whether the width is valid.
     */
    public boolean isValidWidth(int width)
    {
        return !(boxSizes.getMinWidth() > width || boxSizes.getMaxWidth() < width);
    }
    
    /**
     * Checks to see if the height specified is within the range of valid heights.
     *
     * @param  height  The input height.
     * @return         Whether the height is valid.
     */
    public boolean isValidHeight(int height)
    {
        return !(boxSizes.getMinHeight() > height || boxSizes.getMaxHeight() < height);
    }
    
    /**
     * Checks to see if the length specified is within the range of valid lengths.
     *
     * @param  length  The input length.
     * @return         Whether the length is valid.
     */
    public boolean isValidLength(int length)
    {
        return !(boxSizes.getMinLength() > length || boxSizes.getMaxLength() < length);
    }
}
