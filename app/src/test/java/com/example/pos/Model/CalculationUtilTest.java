package com.example.pos.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationUtilTest {

    private CalculationUtil calc= new CalculationUtil(2,25000);
    private double taxes= 7500,total=57500;
    @Test
    public void calculateTaxes() throws Exception{
        assertEquals(taxes,calc.calculateTaxes(),(double)2.0);
    }

    @Test
    public void calculateTotal() {
        assertEquals(total,calc.calculateTotal(2,7500,25000),(double)2.0);
    }
}