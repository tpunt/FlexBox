package com.thomaspunt.flexbox.guibuilder;

import java.io.FileNotFoundException;
import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import java.io.IOException;
import org.json.JSONException;

/**
 * Set up the tabs for the tabs menu object (tabbedPane) in FlexBoxGUI.
 * 
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class FlexBoxTabbedPaneGUI
{
    /**
     * Hold the JFrame object instance to be used in separate tabs for repainting
     * the window.
     */
    private final JFrame flexBoxFrame;
    
    /**
     * Hold the JTabbedPane instance for resetting the focus tab in another tab.
     */
    private final JTabbedPane tabbedPane;
    
    /**
     * Hold the OrderingTabGUI instance so that it can be used and updated in the
     * OrderingTabGUI class and then added to the JTabbedPane.
     */
    private final OrderingTabGUI orderingTab;
    
    /**
     * Hold the OrdersTabGUI instance so that it can be used and updated in the
     * OrdersTabGUI class and then added to the JTabbedPane.
     */
    private final OrdersTabGUI ordersTab;
    
    /**
     * Build the application base, initialise and add its components, then set
     * it to be visible.
     * 
     * @param  flexBoxFrame           The JFrame object of the FlexBox application.
     * @param  tabbedPane             The JTabbedPane object of the FlexBox application.
     * @throws FileNotFoundException  Thrown if the box prices config file cannot be found.
     * @throws IOException            Thrown if the BufferedReader in BoxSizesConfig 
     *                                encounters an I/O problem when reading the next line.
     * @throws JSONException          Thrown if the JSON file has an invalid syntax or if it
     *                                cannot be parsed properly.
     */
    public FlexBoxTabbedPaneGUI(JFrame flexBoxFrame, JTabbedPane tabbedPane) throws FileNotFoundException
                                                                                  , IOException
                                                                                  , JSONException
    {
        this.flexBoxFrame = flexBoxFrame;
        this.tabbedPane = tabbedPane;

        orderingTab = new OrderingTabGUI(this);
        ordersTab = new OrdersTabGUI(this);
        
        createTabbedPane();
    }
    
    /**
     * Add tabs to the tabbedPane object.
     */
    private void createTabbedPane()
    {
        tabbedPane.addTab("New Order", orderingTab.getOrderingTab());
        tabbedPane.addTab("Placed Orders", ordersTab.getOrdersTab());
    }
    
    /**
     * Get the tabbedPane object so that it can be used to update the current tab
     * in focus in one of the tab classes (such as OrderingTabGUI).
     * 
     * @return  The tabbedPane instance variable.
     */
    public JTabbedPane getTabbedPane()
    {
        return tabbedPane;
    }
    
    /**
     * Get the flexBoxFrame object so that it can used to update the JFrame content
     * in one of the tab classes.
     * 
     * @return  The flexBoxFrame instance variable.
     */
    public JFrame getFlexBoxFrame()
    {
        return flexBoxFrame;
    }
    
    /**
     * Get the ordersTab object so that it can be used in the OrderingTabGUI to
     * display the orders on.
     * 
     * @return  The ordersTab instance variable.
     */
    public OrdersTabGUI getOrdersTab()
    {
        return ordersTab;
    }
}
