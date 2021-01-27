package com.portella.restfulwebservices.Conversion;

public class ConversionBean {
    private int integerValue;

   public ConversionBean(int integerValue) {
       this.integerValue = integerValue;
   }

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    @Override
    public String toString() {
        return "ConversionBean{" +
                "integerValue=" + integerValue +
                '}';
    }
}
