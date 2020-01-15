package com.example.pos.Model;

public class CalculationUtil {

    private static final int tax = 15;
    private double taxesCalculated,totalCalculated;
    private int quantity,unitprice;


    /**
     *
     * @param quantity
     * @param unitprice
     *
     */
    public CalculationUtil(int quantity,int unitprice) {
        this.quantity = quantity;
        this.unitprice = unitprice;
        this.calculateTaxes();
        this.calculateTotal(quantity,taxesCalculated,unitprice);

    }

    public double getTaxesCalculated() {
        return taxesCalculated;
    }

    public double getTotalCalculated() {
        return totalCalculated;
    }


    /**
     * it needs the quantity and the unit price set from the constructor.
     * @return taxes calculated from this method.
     */
    public double calculateTaxes(){

        taxesCalculated =  (15*quantity*unitprice)/100;
        return taxesCalculated;
    }

    /**
     *
     * @param quantity
     * @param taxesCalculated
     * @param unitprice
     * @return the totalCalculated for the Total of the vehicles bought with the taxes of 15 percent.
     */
    public double calculateTotal(int quantity,double taxesCalculated,int unitprice){
        totalCalculated =  quantity*unitprice+taxesCalculated;
        return totalCalculated;
    }

}
