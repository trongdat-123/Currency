package com.example.currency;

public class Currency {
    private String country;
    private String type;
    private String symbol;
    private double value;

    public Currency(String country, String type, String symbol, double value) {
        this.country = country;
        this.type = type;
        this.symbol = symbol;
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getFull(){
        return this.country + " - " + this.type;
    }
    @Override
    public String toString()  {
        return this.getFull();
    }
}
