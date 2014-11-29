package com.thomaspunt.flexbox;

import java.util.ArrayList;

/**
 * This class holds a single order, which may contain multiple box types.
 *
 * @author Student ID: 696944
 * @version %I%, %G%
 */
public class Order
{
    /**
     * Hold all box orders from a single order.
     */
    private final ArrayList<BoxOrder> boxOrders = new ArrayList<>();

    /**
     * Hold the total order price (by summing all box prices in this order).
     */
    private double orderPrice;
    
    /**
     * Add box orders to this Order object.
     *
     * @param boxOrders  The boxes specified in the submitted order.
     */
    public Order(ArrayList<BoxOrder> boxOrders)
    {
        for(BoxOrder boxOrder : boxOrders)
            addOrder(boxOrder);
    }
    
    /**
     * Get the total order price for this order.
     *
     * @return  The order total order price.
     */
    public double getOrderPrice()
    {
        return orderPrice;
    }
    
    /**
     * Get the box orders for this order.
     *
     * @return  the box orders in this order.
     */
    public ArrayList<BoxOrder> getBoxOrders()
    {
        return boxOrders;
    }
    
    /**
     * Get a specific box order from this order.
     *
     * @param  boxOrderNo  The number of the box order to get.
     * @return             The specified box order.
     */
    public BoxOrder getBoxOrder(int boxOrderNo)
    {
        return boxOrders.get(boxOrderNo);
    }
    
    /**
     * Set the total order price (after it has been externally calculated).
     *
     * @param orderPrice  The total price of this order.
     */
    public void setOrderPrice(double orderPrice)
    {
        this.orderPrice = orderPrice;
    }
    
    /**
     * Check to see if an individual box order with identical properties already
     * exists. If so, then increment the quantity by the duplicate box order quantity,
     * otherwise add the unique box order to the boxOrders arraylist.
     *
     * @param boxOrder  A single box order from an order.
     */
    private void addOrder(BoxOrder boxOrder)
    {
        if(boxOrders.isEmpty()) {
            boxOrders.add(boxOrder);
        }else{
            boolean isIdentical = false;
            for(BoxOrder box : boxOrders) {
                if(box.isIdenticalBox(boxOrder)) {
                    box.addQuantity(boxOrder.getQuantity());
                    isIdentical = true;
                    break;
                }
            }

            if(!isIdentical)
                boxOrders.add(boxOrder);
        }
    }
}
