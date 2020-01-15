package com.example.pos.Model;

public class CalculationUtil {

    private static final int tax = 15;
    private double taxesCalculated,totalCalculated;
    private int quantity,unitprice;


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

    public double calculateTaxes(){

        taxesCalculated =  (15*quantity*unitprice)/100;
        return taxesCalculated;
    }

    public double calculateTotal(int quantity,double taxesCalculated,int unitprice){
        totalCalculated =  quantity*unitprice+taxesCalculated;
        return totalCalculated;
    }

}
