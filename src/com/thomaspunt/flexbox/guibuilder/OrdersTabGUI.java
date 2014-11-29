package com.thomaspunt.flexbox.guibuilder;

import com.thomaspunt.flexbox.BoxOrder;
import com.thomaspunt.flexbox.Order;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Contains the display logic for the orders tab.
 * 
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class OrdersTabGUI
{
    /**
     * Stores the outer panel for the orders tab so that components can be added to
     * it and displayed.
     */
    private final JPanel outerPanel = new JPanel();
    
    /**
     * Holds the outer panel for the orders tab, enabling scrolling of the
     * content in the orders tab. This is required to display many placed orders.
     */
    private final JScrollPane ordersTabGUI = new JScrollPane(outerPanel);
    
    /**
     * The order count number to attach to each order when displaying them.
     */
    private int orderNo = 0;
    
    /**
     * Enables orders to be added to it so that they can be displayed. This is
     * then added as a component to the outerPanel instance variable.
     */
    private final JPanel ordersPanel = new JPanel();
    
    /**
     * Sets the layout for the ordersPanel so that each order is displayed under
     * one-another.
     * 
     * @param tabbedPane  The flex box JTabbedPane instance.
     */
    public OrdersTabGUI(FlexBoxTabbedPaneGUI tabbedPane)
    {
        ordersPanel.setLayout(new BoxLayout(ordersPanel, BoxLayout.Y_AXIS));
    }
    
    /**
     * Displays the order that is passed as an argument on the orders page.
     * 
     * @param order  The order to be displayed.
     */
    public void displayOrder(Order order)
    {
        String[] columnNames = {"Size (W x H x L)"
                              , "Grade"
                              , "Print"
                              , "Rein. Bottom?"
                              , "Rein. Corners?"
                              , "Tops Sealable?"
                              , "Quantity"};

        JPanel boxOrderPanel = new JPanel();
        boxOrderPanel.setLayout(new BoxLayout(boxOrderPanel, BoxLayout.Y_AXIS));
        boxOrderPanel.setBorder(BorderFactory.createTitledBorder("Order Information #" + ++orderNo));
        int orderSize = order.getBoxOrders().size();

        Object[][] data = new Object[orderSize][7];

        for(int orderNo = 0;orderNo < orderSize; ++orderNo) {
            BoxOrder boxOrder = order.getBoxOrder(orderNo);

            data[orderNo][0] = boxOrder.getWidth()
                       + "x" + boxOrder.getHeight()
                       + "x" + boxOrder.getLength();
            data[orderNo][1] = boxOrder.getGrade();
            data[orderNo][2] = boxOrder.getColourPrint();
            data[orderNo][3] = boxOrder.hasReinforcedBottom() ? "Yes" : "No";
            data[orderNo][4] = boxOrder.hasReinforcedCorners() ? "Yes" : "No";
            data[orderNo][5] = boxOrder.hasSealableTops() ? "Yes" : "No";
            data[orderNo][6] = boxOrder.getQuantity();
        }

        JTable boxOrderTable = new JTable(data, columnNames);
        boxOrderTable.setPreferredScrollableViewportSize(boxOrderTable.getPreferredSize());
        boxOrderTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        boxOrderTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        boxOrderTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        boxOrderTable.getColumnModel().getColumn(3).setPreferredWidth(85);
        boxOrderTable.getColumnModel().getColumn(4).setPreferredWidth(90);
        boxOrderTable.getColumnModel().getColumn(5).setPreferredWidth(90);
        boxOrderTable.getColumnModel().getColumn(6).setPreferredWidth(55);
        JScrollPane tableScroll = new JScrollPane(boxOrderTable);
        JPanel price = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        price.add(new JLabel("Total Price: "
                            + String.format("£%.2f"
                                          , order.getOrderPrice())));
        boxOrderPanel.add(tableScroll);
        boxOrderPanel.add(price);

        ordersPanel.add(boxOrderPanel);
        outerPanel.add(ordersPanel);
    }
    
    /**
     * Gets the ordering tab so that it can be added to the flex box JTabbedPane in
     * the FlexBoxTabbedPaneGUI class.
     * 
     * @return  The orders tab content as a single JScrollPane component.
     */
    public JScrollPane getOrdersTab()
    {
        return ordersTabGUI;
    }
}
