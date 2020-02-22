package com.example.pos;

import com.example.pos.Model.Calculatoreq;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculatoreq calc = new Calculatoreq();
    double total = 4;
    @Test
    public void equal() {
        assertEquals(total,calc.equal("+",2.0,2.0),(double)0.0);
    }
}