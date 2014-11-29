package com.thomaspunt.flexbox;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Parse the box sizes ini config file and populate the boxSizes instance variable with
 * the minimum and maximum sizes for lengths, widths, and heights.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class BoxSizesConfig
{
    /**
     * Store the box size limits in key => value fashion.
     */
    private HashMap<String, Integer> boxSizes;

    /**
     * The default configuration file for storing box sizes (if one is not specified
     * on class instantiation).
     */
    private static final String boxSizesConfigFile = System.getProperty("user.dir")
                                            + "/src/com/thomaspunt/flexbox/config/boxSizes.ini";
    
    /**
     * Parse the box sizes ini file and populate the boxSizes hash map with the valid box
     * sizes specified.
     *
     * @param  fileName               The name of the config file to be loaded in.
     * @throws FileNotFoundException  Thrown if the target config file cannot be found.
     * @throws IOException            Thrown if the BufferedReader encounters an I/O
     *                                problem when reading the next line.
     */
    public BoxSizesConfig(String fileName) throws FileNotFoundException, IOException
    {
        boxSizes = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while((line = br.readLine()) != null) {
            if(line.matches("^\\s*|\\s*;.*"))
                continue;

            String[] setting = line.split("\\s*=\\s*");
            boxSizes.put(setting[0], Integer.parseInt(setting[1]));
        }

        br.close();
    }
    
    /**
     * Provide an optional constructor so that the default config file can be loaded.
     *
     * @throws FileNotFoundException  Thrown if the box sizes config file cannot be found.
     * @throws IOException            Thrown if the BufferedReader throws an IOException.
     */
    public BoxSizesConfig() throws FileNotFoundException, IOException
    {
        this(boxSizesConfigFile);
    }
    
    /**
     * Get the minimum width for a box.
     * 
     * @return  The minimum box width.
     */
    public int getMinWidth()
    {
        return boxSizes.get("minwidth");
    }
    
    /**
     * Get the maximum width for a box.
     * 
     * @return  The maximum box width.
     */
    public int getMaxWidth()
    {
        return boxSizes.get("maxwidth");
    }
    
    /**
     * Get the minimum height for a box.
     * 
     * @return  The minimum box height.
     */
    public int getMinHeight()
    {
        return boxSizes.get("minheight");
    }
    
    /**
     * Get this maximum height for a box.
     * 
     * @return  This maximum box height.
     */
    public int getMaxHeight()
    {
        return boxSizes.get("maxheight");
    }
    
    /**
     * Get this minimum length for a box.
     * 
     * @return  This minimum box length.
     */
    public int getMinLength()
    {
        return boxSizes.get("minlength");
    }
    
    /**
     * Get this maximum length for a box.
     * 
     * @return  This maximum box length.
     */
    public int getMaxLength()
    {
        return boxSizes.get("maxlength");
    }
}
