
package com.mycompany.hackernewsuutiset;

public class Uutinen {
    private String by;
    private String url;
    
    @Override
    public String toString(){
        return "tekijältä: " + by + " , linkki: " + url;
    }
}
