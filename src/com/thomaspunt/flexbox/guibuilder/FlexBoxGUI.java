package com.thomaspunt.flexbox.guibuilder;

import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.io.IOException;
import org.json.JSONException;

/**
 * This class builds the base of the user interface.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class FlexBoxGUI
{
    /**
     * Hold the JFrame object so that it can be used later (such as repainting the
     * window).
     */
    private final JFrame flexBoxFrame = new JFrame();
    
    /**
     * Hold the tabbedPane menu so that it can be referenced later (such as
     * setting the focus on another tab).
     */
    private final JTabbedPane tabbedPane = new JTabbedPane();

    /**
     * Build the application base, initialise and add its components, then set
     * it to be visible.
     * 
     * @throws FileNotFoundException  Thrown if the box prices config file cannot be found.
     * @throws IOException            Thrown if the BufferedReader in BoxSizesConfig 
     *                                encounters an I/O problem when reading the next line.
     * @throws JSONException          Thrown if the JSON file has an invalid syntax or if it
     *                                cannot be parsed properly.
     */
    public FlexBoxGUI() throws FileNotFoundException
                             , IOException
                             , JSONException
    {
        setupApplicationBase();
        new FlexBoxTabbedPaneGUI(flexBoxFrame, tabbedPane); 
        
        flexBoxFrame.add(tabbedPane);
        flexBoxFrame.setVisible(true);
    }

    /**
     * Setup the JFrame object by setting various properties of it.
     */
    private void setupApplicationBase()
    {
        flexBoxFrame.setTitle("Flex Box");
        flexBoxFrame.setSize(650, 610);
        flexBoxFrame.setLocationRelativeTo(null);
        flexBoxFrame.setDefaultCloseOperation(flexBoxFrame.EXIT_ON_CLOSE);
    }
}