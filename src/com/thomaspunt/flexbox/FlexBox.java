package com.thomaspunt.flexbox;

import com.thomaspunt.flexbox.guibuilder.FlexBoxGUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.JSONException;

/**
 * This class is the entrance to the application. It instantiates this class
 * and creates the GUI.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class FlexBox
{
    /**
     * Instantiate this application. Command line arguments are ignored.
     * 
     * @param args  The command line arguments of the application.
     */
    public static void main(String[] args)
    {
        new FlexBox();
    }

    /**
     * Create the GUI, and catch any exceptions thrown during the application
     * execution. Any exceptions that are being caught here safely prevent the
     * application from attempting to continue to execute since they make the
     * application unusable in some way. (For example, a missing config file or
     * a parse error in a config file).
     */
    public FlexBox()
    {
        try {
            new FlexBoxGUI();
        }catch(FileNotFoundException fnfe) {
            System.out.println("A configuration file could not be found.");
        }catch(IOException ioe) {
            System.out.println("There was a problem with parsing the config file.");
        }catch(JSONException je) {
            System.out.println("The box prices (JSON) config file contains a syntax error.");
        }catch(Exception e) {
            System.out.println("The program has failed for an unknown reason: " + e);
        }
    }
}