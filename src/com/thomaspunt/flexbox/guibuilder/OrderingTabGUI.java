package com.thomaspunt.flexbox.guibuilder;

import com.thomaspunt.flexbox.BoxSizes;
import com.thomaspunt.flexbox.BoxTypes;
import com.thomaspunt.flexbox.BoxOrder;
import com.thomaspunt.flexbox.BoxPrices;
import com.thomaspunt.flexbox.Order;
import org.json.JSONException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 * Contains all of the ordering tab logic, such as adding new order windows, validating
 * the order submission, handling order submissions on success, and updating the
 * OrdersTabGUI class to display the new order.
 * 
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class OrderingTabGUI
{
    /**
     * Holds the ordering panel object so that it can be updated throughout the class
     * (such as when new a new order window is added or removed).
     */
    private final JPanel orderingPanel = new JPanel();
    
    /**
     * Holds the order boxes in a way that enables the application to track the
     * order boxes when there are multiple ordering panels on the screen.
     * <p>
     * This enables the application to go through all ordering boxes, validate them,
     * and let the end user know (if any) which ordering boxes have validation issues.
     */
    private final HashMap<Integer, OrderBoxFields> orderingBoxes = new HashMap<>();
    
    /**
     * This is used in conjunction with the orderingBoxes instance variable, where
     * the value of this is used as the key in the hash map so that the correct ordering
     * box can be removed by the end user.
     */
    private int boxNumber = 0;
    
    /**
     * This variable limits the number of ordering boxes allowed on-screen at once.
     * This therefore sets the maximum limit of different ordering boxes that can
     * be placed in a single order.
     */
    private final int maxOrderBoxes = 5;
    
    /**
     * This contains the business logic for the valid box types in the ordering system.
     * <p>
     * It is used to collectively validate all of the box order fields to ensure that
     * they match a valid box type in the ordering system.
     */
    private final BoxTypes boxTypes;
    
    /**
     * Holds the limitation values for the dimensions of a box (width, height,
     * and length).
     */
    private final BoxSizes boxSizes;
    
    /**
     * Holds the box prices calculation logic to get a total price of the order.
     */
    private final BoxPrices boxPrices;
    
    /**
     * Holds the box orders from each ordering window.
     * <p>
     * It is used to collate all
     * box orders during validation of the box orders, and is either flushed on failure
     * (such as an invalid value being entered), or kept on success to be displayed on
     * the orders tab panel.
     */
    private final ArrayList<BoxOrder> boxOrders = new ArrayList<>();
    
    /**
     * Holds the outer panel JPanel object of the ordering tab, where components
     * are set to a layout object which is attached to this object.
     */
    private final JPanel outerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    /**
     * Holds the outer panel for the ordering tab, enabling scrolling of the
     * content in the ordering tab. This is required because of the ability to add
     * in new ordering windows.
     */
    private final JScrollPane orderingTabGUI = new JScrollPane(outerPanel);
    
    /**
     * Holds an instance of the FlexBoxTabsGUI to enable the application to
     * change the tab-focus when a successful order has submitted.
     */
    private final FlexBoxTabbedPaneGUI flexBoxTabs;
    
    /**
     * Instantiate the required classes and create the ordering tab.
     * 
     * @param flexBoxTabbedPane       The flex box JTabbedPane instance.
     * @throws FileNotFoundException  Thrown if the box prices config file cannot be found.
     * @throws IOException            Thrown if the BufferedReader in BoxSizesConfig 
     *                                encounters an I/O problem when reading the next line.
     * @throws JSONException          Thrown if the JSON file has an invalid syntax or if it
     *                                cannot be parsed properly.
     */
    public OrderingTabGUI(FlexBoxTabbedPaneGUI flexBoxTabbedPane) throws FileNotFoundException
                                                                       , IOException
                                                                       , JSONException
    {
        boxTypes = new BoxTypes();
        boxSizes = new BoxSizes();
        boxPrices = new BoxPrices();

        this.flexBoxTabs = flexBoxTabbedPane;

        createOrderingTab();
    }

    /**
     * Gets the ordering tab so that it can be added to the flex box JTabbedPane in
     * the FlexBoxTabbedPaneGUI class.
     * 
     * @return  The ordering tab content as a single JScrollPane component.
     */
    public JScrollPane getOrderingTab()
    {
        return orderingTabGUI;
    }
    
    /**
     * Creates the ordering tab by building the header and footer components, and
     * then collates them in a GroupLayout object which is then set as the layout
     * for the outerPanel instance variable.
     */
    private void createOrderingTab()
    {
        GroupLayout outerLayout = new GroupLayout(outerPanel);

        /*        Header Layout        */

        JPanel headerPanel = new JPanel();
        JLabel panelText = new JLabel("Place a new order:");
        headerPanel.add(panelText);
        headerPanel.setMaximumSize(headerPanel.getPreferredSize());

        collateOrderingPanels();

        /*        Footer Layout        */

        JPanel footerPanel = new JPanel();
        GroupLayout footerLayout = new GroupLayout(footerPanel);

        JButton addOrderButton = new JButton("Add Order Box");
        addOrderButton.setActionCommand("addOrderBox");
        addOrderButton.addActionListener(new OrderingTabGUI.ButtonClickListener());

        JButton submitButton = new JButton("Submit Order");
        submitButton.setActionCommand("submitOrder");
        submitButton.addActionListener(new OrderingTabGUI.ButtonClickListener());

        footerLayout.setHorizontalGroup(footerLayout.createSequentialGroup()
            .addComponent(addOrderButton)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED
                           , GroupLayout.DEFAULT_SIZE
                           , Short.MAX_VALUE)
            .addComponent(submitButton)
        );

        footerLayout.setVerticalGroup(footerLayout.createParallelGroup()
            .addComponent(addOrderButton)
            .addComponent(submitButton)
        );

        footerPanel.setLayout(footerLayout);

        /*        Collate the header, body, and footer        */

        outerLayout.setHorizontalGroup(outerLayout.createParallelGroup()
            .addComponent(headerPanel)
            .addComponent(orderingPanel)
            .addComponent(footerPanel)
        );

        outerLayout.setVerticalGroup(outerLayout.createSequentialGroup()
            .addComponent(headerPanel)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED
                           , GroupLayout.DEFAULT_SIZE
                           , 15)
            .addComponent(orderingPanel)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED
                           , GroupLayout.DEFAULT_SIZE
                           , 15)
            .addComponent(footerPanel)
        );

        outerPanel.setLayout(outerLayout);
    }

    /**
     * Handles the ordering windows logic by either creating a new order window
     * if one does not exist (such as the last ordering window just being removed),
     * or adds all existing ordering windows to the orderingPanel instance variable.
     */
    private void collateOrderingPanels()
    {
        if(orderingBoxes.isEmpty()) {
            addOrderWindow();
            return;
        }

        orderingPanel.removeAll();

        for(Integer orderBoxN : orderingBoxes.keySet())
           orderingPanel.add(orderingBoxes.get(orderBoxN).getOrderPanel());
    }

    /**
     * Creates a new order window to be added to the orderingPanel instance variable.
     */
    private void addOrderWindow()
    {
        /*        Body Layout        */

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(BorderFactory.createTitledBorder("Box Information"));

        GroupLayout bodyLayout = new GroupLayout(bodyPanel);

        bodyLayout.setAutoCreateGaps(false);
        bodyLayout.setAutoCreateContainerGaps(true);
        
        /*        Top Body Layout        */

        JPanel topBodyPanel = new JPanel();
        GroupLayout topBodyLayout = new GroupLayout(topBodyPanel);
        topBodyLayout.setAutoCreateGaps(false);
        topBodyLayout.setAutoCreateContainerGaps(true);

        JLabel bwhText = new JLabel("Size (cm):");

        JLabel bwText = new JLabel("Width:");
        JPanel bwField = new JPanel();
        JTextField bwTextField = new JTextField(3);
        bwField.add(bwTextField);
        bwField.setMaximumSize(bwField.getPreferredSize());
        JLabel bhText = new JLabel("Height:");
        JPanel bhField = new JPanel();
        JTextField bhTextField = new JTextField(3);
        bhField.add(bhTextField);
        bhField.setMaximumSize(bhField.getPreferredSize());
        JLabel blText = new JLabel("Lenght:");
        JPanel blField = new JPanel();
        JTextField blTextField = new JTextField(3);
        blField.add(blTextField);
        blField.setMaximumSize(blField.getPreferredSize());

        topBodyLayout.setHorizontalGroup(topBodyLayout.createSequentialGroup()
            .addComponent(bwhText)
            .addGroup(topBodyLayout.createParallelGroup()
                .addComponent(bwText)
                .addComponent(bhText)
                .addComponent(blText)
            )
            .addGroup(topBodyLayout.createParallelGroup()
                .addComponent(bwField)
                .addComponent(bhField)
                .addComponent(blField)
            )
        );

        topBodyLayout.setVerticalGroup(topBodyLayout.createSequentialGroup()
            .addComponent(bwhText)
            .addGroup(topBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(bwText)
                .addComponent(bwField)
            )
            .addGroup(topBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(bhText)
                .addComponent(bhField)
            )
            .addGroup(topBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(blText)
                .addComponent(blField)
            )
        );

        topBodyPanel.setLayout(topBodyLayout);

        /*        Middle Body Layout        */

        JPanel middleBodyPanel = new JPanel();
        GroupLayout middleBodyLayout = new GroupLayout(middleBodyPanel);
        middleBodyLayout.setAutoCreateGaps(false);

        JLabel bgText = new JLabel("Box Grade:");
        JPanel bgField = new JPanel();
        JTextField bgTextField = new JTextField(10);
        bgField.add(bgTextField);
        bgField.setMaximumSize(bgField.getPreferredSize());

        JLabel cpText = new JLabel("Colour Print:");
        JPanel cpField = new JPanel();
        JTextField cpTextField = new JTextField(10);
        cpField.add(cpTextField);
        cpField.setMaximumSize(cpField.getPreferredSize());

        String[] choices = { "Yes", "No" };

        JLabel rbText = new JLabel("Reinforced Bottom:");
        JPanel rbField = new JPanel();
        JComboBox<String> rbComboBox = new JComboBox<>(choices);
        rbComboBox.setSelectedIndex(1);
        rbField.add(rbComboBox);
        rbField.setMaximumSize(rbField.getPreferredSize());

        JLabel rcText = new JLabel("Reinforced Corners:");
        JPanel rcField = new JPanel();
        JComboBox<String> rcComboBox = new JComboBox<>(choices);
        rcComboBox.setSelectedIndex(1);
        rcField.add(rcComboBox);
        rcField.setMaximumSize(rcField.getPreferredSize());

        JLabel stText = new JLabel("Sealable Tops:");
        JPanel stField = new JPanel();
        JComboBox<String> stComboBox = new JComboBox<>(choices);
        stComboBox.setSelectedIndex(1);
        stField.add(stComboBox);
        stField.setMaximumSize(stField.getPreferredSize());

        JLabel qText = new JLabel("Quantity:");
        JPanel qField = new JPanel();
        JTextField qTextField = new JTextField("1", 4);
        qField.add(qTextField);
        qField.setMaximumSize(qField.getPreferredSize());

        middleBodyLayout.setHorizontalGroup(middleBodyLayout.createSequentialGroup()
            .addGroup(middleBodyLayout.createParallelGroup()
                .addComponent(bgText)
                .addComponent(cpText)
                .addComponent(rbText)
                .addComponent(rcText)
                .addComponent(stText)
                .addComponent(qText)
            )
            .addGroup(middleBodyLayout.createParallelGroup()
                .addComponent(bgField)
                .addComponent(cpField)
                .addComponent(rbField)
                .addComponent(rcField)
                .addComponent(stField)
                .addComponent(qField)
            )
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED
                           , GroupLayout.DEFAULT_SIZE
                           , Short.MAX_VALUE)
        );

        middleBodyLayout.setVerticalGroup(middleBodyLayout.createSequentialGroup()
            .addGroup(middleBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(bgText)
                .addComponent(bgField)
            )
            .addGroup(middleBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(cpText)
                .addComponent(cpField)
            )
            .addGroup(middleBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(rbText)
                .addComponent(rbField)
            )
            .addGroup(middleBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(rcText)
                .addComponent(rcField)
            )
            .addGroup(middleBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(stText)
                .addComponent(stField)
            )
            .addGroup(middleBodyLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(qText)
                .addComponent(qField)
            )
        );

        middleBodyPanel.setLayout(middleBodyLayout);

        /*        Bottom Body Layout        */

        JPanel bottomBodyPanel = new JPanel();
        GroupLayout bottomBodyLayout = new GroupLayout(bottomBodyPanel);
        bottomBodyLayout.setAutoCreateGaps(false);
        bottomBodyLayout.setAutoCreateContainerGaps(true);

        JLabel statusTextField = new JLabel(" ");
        statusTextField.setForeground(Color.red);
        
        bottomBodyLayout.setHorizontalGroup(bottomBodyLayout.createSequentialGroup()
            .addComponent(statusTextField)
        );

        bottomBodyLayout.setVerticalGroup(bottomBodyLayout.createParallelGroup()
            .addComponent(statusTextField)
        );
        
        bottomBodyPanel.setLayout(bottomBodyLayout);

        JPanel removeButtonPanel = new JPanel();
        removeButtonPanel.setLayout(new BorderLayout(0, 0));
        JButton removeButton = new JButton("Remove Order Box");
        removeButton.setActionCommand("removeComponent_" + ++boxNumber);
        removeButton.addActionListener(new OrderingTabGUI.ButtonClickListener());
        removeButton.setBackground(Color.red);
        removeButton.setOpaque(true);
        removeButton.setBorderPainted(false);
        removeButtonPanel.add(removeButton);

        /*        Collate the three layouts        */

        bodyLayout.setHorizontalGroup(bodyLayout.createParallelGroup()
            .addComponent(topBodyPanel)
            .addComponent(middleBodyPanel)
            .addComponent(bottomBodyPanel)
            .addComponent(removeButtonPanel)
        );

        bodyLayout.setVerticalGroup(bodyLayout.createSequentialGroup()
            .addComponent(topBodyPanel)
            .addComponent(middleBodyPanel)
            .addComponent(bottomBodyPanel)
            .addComponent(removeButtonPanel)
        );

        bodyPanel.setLayout(bodyLayout);

        orderingBoxes.put(boxNumber
                        , new OrderingTabGUI.OrderBoxFields(bodyPanel
                                                          , bwTextField
                                                          , bhTextField
                                                          , blTextField
                                                          , bgTextField
                                                          , cpTextField
                                                          , rbComboBox
                                                          , rcComboBox
                                                          , stComboBox
                                                          , qTextField
                                                          , statusTextField));

        collateOrderingPanels();
    }
    
    /**
     * Checks to see if all ordering windows contain valid information and order
     * box types.
     * 
     * @return  Whether the order as a whole was valid.
     */
    private boolean allValidOrders()
    {
        boolean validOrders = true;

        for(Integer orderBoxN : orderingBoxes.keySet()) {
            OrderBoxFields ob = orderingBoxes.get(orderBoxN);

            boolean errorOccurred = true;

            try {
                int boxWidth = Integer.parseInt(ob.getBoxWidth());
                int boxHeight = Integer.parseInt(ob.getBoxHeight());
                int boxLength = Integer.parseInt(ob.getBoxLength());
                int boxGrade = Integer.parseInt(ob.getBoxGrade());
                int boxColourPrint = Integer.parseInt(ob.getBoxColourPrint());
                int boxQuantity = Integer.parseInt(ob.getBoxQuantity());
                int boxType = boxTypes.checkBoxType(boxGrade
                                             , boxColourPrint
                                             , ob.hasReinforcedBottom()
                                             , ob.hasReinforcedCorners());

                if(!boxSizes.isValidWidth(boxWidth)) {
                    ob.setStatusText("Invalid box width: from "
                                     + boxSizes.getBoxSizes().getMinWidth()
                                     + "cm to "
                                     + boxSizes.getBoxSizes().getMaxWidth()
                                     + "cm.");
                    validOrders = false;
                }else if(!boxSizes.isValidHeight(boxHeight)) {
                    ob.setStatusText("Invalid box height: from "
                                     + boxSizes.getBoxSizes().getMinHeight()
                                     + "cm to "
                                     + boxSizes.getBoxSizes().getMaxHeight()
                                     + "cm.");
                    validOrders = false;
                }else if(!boxSizes.isValidLength(boxLength)) {
                    ob.setStatusText("Invalid box length: from "
                                     + boxSizes.getBoxSizes().getMinLength()
                                     + "cm to "
                                     + boxSizes.getBoxSizes().getMaxLength()
                                     + "cm.");
                    validOrders = false;
                }else if(boxQuantity < 1) {
                    ob.setStatusText("Invalid box quantity.");
                    validOrders = false;
                }else if (boxType == -1) {
                    ob.setStatusText("Invalid box type.");
                    validOrders = false;
                }else{
                    errorOccurred = false;
                    boxOrders.add(new BoxOrder(boxType
                                             , boxWidth
                                             , boxHeight
                                             , boxLength
                                             , boxGrade
                                             , boxColourPrint
                                             , ob.hasReinforcedBottom()
                                             , ob.hasReinforcedCorners()
                                             , ob.hasSealableTops()
                                             , boxQuantity));
                }
            }catch(NumberFormatException e) {
                ob.setStatusText("Invalid input.");
                validOrders = false;
            }
            
            if(!errorOccurred)
                ob.setStatusText(" ");
        }
        
        if(!validOrders)
            boxOrders.clear();
        
        return validOrders;
    }

    /**
     * Submits the order by calculating the price and attaching it to the order,
     * and then updating the orders tab to display the new order. It then resets
     * all instance variables in this class that are to do with placing an order
     * to ensure that the ordering page is ready to take new order submissions.
     */
    private void submitOrders()
    {
        Order order = new Order(boxOrders);
        order.setOrderPrice(boxPrices.calculateOrderPrice(order));

        flexBoxTabs.getOrdersTab().displayOrder(order);
        
        
        flexBoxTabs.getFlexBoxFrame().repaint();
        flexBoxTabs.getTabbedPane().setSelectedIndex(1);

        boxNumber = 0;
        orderingBoxes.clear();
        orderingPanel.removeAll();
        collateOrderingPanels();
        flexBoxTabs.getFlexBoxFrame().repaint();
        boxOrders.clear();
    }

    /**
     * This class is used to handle the action events when adding or removing order
     * windows, as well as submitting an order.
     */
    private class ButtonClickListener implements ActionListener
    {
        /**
         * Handle the event depending upon the action command used.
         * <p>
         * This method will be invoked when an event action has been triggered.
         * 
         * @param e  The event that was triggered.
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            switch(actionCommand) {
                case "addOrderBox":
                    if(orderingBoxes.size() < maxOrderBoxes) {
                        addOrderWindow();
                        flexBoxTabs.getFlexBoxFrame().repaint();
                    }
                    break;
                case "submitOrder":
                    if(allValidOrders())
                        submitOrders();
                    break;
                default:
                    if(actionCommand.matches("removeComponent_[0-9]+")) {
                        String[] parts = actionCommand.split("_");
                        orderingBoxes.remove(Integer.parseInt(parts[1]));
                        collateOrderingPanels();
                        flexBoxTabs.getFlexBoxFrame().repaint();
                    }
            }
        }
    }

    /**
     * This class is required to hold the ordering window fields for each individual
     * box order. It also stores the order panel object which is used when collating
     * all order panels, along with a status field to display an error message if
     * validation fails.
     */
    private class OrderBoxFields
    {
        /**
         * Stores the order window itself to be used when collating all ordering windows.
         */
        private final JPanel orderPanel;
        
        /**
         * Stores the entered value for the box width.
         */
        private final JTextField bwTextField;
        
        /**
         * Stores the entered value for the box height.
         */
        private final JTextField bhTextField;
        
        /**
         * Stores the entered value for the box length.
         */
        private final JTextField blTextField;
        
        /**
         * Stores the entered value for the box grade.
         */
        private final JTextField bgTextField;
        
        /**
         * Stores the entered value for the box colour print.
         */
        private final JTextField cpTextField;
        
        /**
         * Stores the selected value for whether the box has a reinforced bottom.
         */
        private final JComboBox<String> rbComboBox;
        
        /**
         * Stores the selected value for whether the box has reinforced corners.
         */
        private final JComboBox<String> rcComboBox;
        
        /**
         * Stores the selected value for whether the box has a sealable top.
         */
        private final JComboBox<String> stComboBox;
        
        /**
         * Stores the entered value for the box quantity.
         */
        private final JTextField qTextField;
        
        /**
         * Stores the status text field.
         */
        private final JLabel statusTextField;

        /**
         * Assign values to all instance variables.
         * 
         * @param orderPanel       The order window for the box.
         * @param bwTextField      The box width
         * @param bhTextField      The box height.
         * @param blTextField      The box length.
         * @param bgTextField      The card grade of the box.
         * @param cpTextField      The colour print of the box.
         * @param rbComboBox       Whether the box has a reinforced bottom.
         * @param rcComboBox       Whether the box has reinforced corners.
         * @param stComboBox       Whether the box has sealable tops.
         * @param qTextField       The box quantity.
         * @param statusTextField  The error message (if there is one).
         */
        public OrderBoxFields(JPanel orderPanel
                      , JTextField bwTextField
                      , JTextField bhTextField
                      , JTextField blTextField
                      , JTextField bgTextField
                      , JTextField cpTextField
                      , JComboBox<String> rbComboBox
                      , JComboBox<String> rcComboBox
                      , JComboBox<String> stComboBox
                      , JTextField qTextField
                      , JLabel statusTextField)
        {
            this.orderPanel = orderPanel;
            this.bwTextField = bwTextField;
            this.bhTextField = bhTextField;
            this.blTextField = blTextField;
            this.bgTextField = bgTextField;
            this.cpTextField = cpTextField;
            this.rbComboBox = rbComboBox;
            this.rcComboBox = rcComboBox;
            this.stComboBox = stComboBox;
            this.qTextField = qTextField;
            this.statusTextField = statusTextField;
        }

        /**
         * Gets the order window for the box.
         * 
         * @return  The order window.
         */
        public JPanel getOrderPanel()
        {
            return orderPanel;
        }
        
        /**
         * Gets the box width.
         * 
         * @return  The width of the box.
         */
        public String getBoxWidth()
        {
            return bwTextField.getText();
        }

        /**
         * Gets the box height.
         * 
         * @return  The height of the box.
         */
        public String getBoxHeight()
        {
            return bhTextField.getText();
        }

        /**
         * Gets the box length.
         * 
         * @return  The length of the box.
         */
        public String getBoxLength()
        {
            return blTextField.getText();
        }

        /**
         * Gets the grade of card for the box.
         * 
         * @return  The card grade of the box.
         */
        public String getBoxGrade()
        {
            return bgTextField.getText();
        }

        /**
         * Gets the box colour print.
         * 
         * @return  The colour print of the box.
         */
        public String getBoxColourPrint()
        {
            return cpTextField.getText();
        }

        /**
         * Get whether the box has a reinforced bottom.
         * 
         * @return  Whether the box has a reinforced bottom.
         */
        public boolean hasReinforcedBottom()
        {
            return rbComboBox.getSelectedItem().toString().equals("Yes");
        }

        /**
         * Get whether the box has reinforced corners.
         * 
         * @return  Whether the box has reinforced corners.
         */
        public boolean hasReinforcedCorners()
        {
            return rcComboBox.getSelectedItem().toString().equals("Yes");
        }

        /**
         * Get whether the box has sealable tops.
         * 
         * @return  Whether the box has sealable tops.
         */
        public boolean hasSealableTops()
        {
            return stComboBox.getSelectedItem().toString().equals("Yes");
        }

        /**
         * Gets the box quantity.
         * 
         * @return  The quantity of the box.
         */
        public String getBoxQuantity()
        {
            return qTextField.getText();
        }

        /**
         * Gets the box status text.
         * 
         * @return  The status text of the box.
         */
        public String getStatusText()
        {
            return statusTextField.getText();
        }

        /**
         * Sets the status text of a box - either to an empty string to show the
         * box is valid, or to an error message.
         * 
         * @param text  The error message to display.
         */
        public void setStatusText(String text)
        {
            statusTextField.setText(text);
        }
    }
}
