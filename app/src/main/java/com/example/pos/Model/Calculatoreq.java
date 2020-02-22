package com.example.pos.Model;

public class Calculatoreq {

    String num4="";
    public double equal(String num, double ca1,double ca2)
    {
        if(num == "+")
        {
            //cal2 = Double.parseDouble(num3);
            num4 = String.valueOf(ca1 + ca2);
        }
        else if(num == "-")
        {
            //cal2 = Double.parseDouble(num3);
            num4 = String.valueOf(ca1 - ca2);
        }
        else if(num == "/")
        {
            //cal2 = Double.parseDouble(num3);
            num4 = String.valueOf(ca1 / ca2);
        }
        else if(num == "*")
        {
            //cal2 = Double.parseDouble(num3);
            num4 = String.valueOf(ca1 * ca2);
        }
        double res = Double.parseDouble(num4);
        return res;

    }
}
