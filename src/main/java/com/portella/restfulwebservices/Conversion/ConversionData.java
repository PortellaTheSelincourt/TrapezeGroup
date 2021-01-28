package com.portella.restfulwebservices.Conversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 */
public class ConversionData {

    public int convertToDecimal(String romanNumeral) throws Exception {

        int result = 0;
        //I had a more elegant logic for this in a Map but decided to dumb it down as I was getting errors
        // and if i had time at the end then reintroduce the map.
        int[] decimal = {1000, 900, 500, 400, 100, 90, 80, 70, 60, 50, 40, 30, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "LXXX", "LXX", "LX", "L", "XL", "XXX", "XX", "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        //the idea was for the regex to identify that No digit is repeated in succession more than thrice,
        // i.e., I, X and C cannot be repeated more than 3 times.
        Pattern pattern = Pattern.compile("(.)\\1{3,}", Pattern.DOTALL);
        for (String s: roman){
            Matcher m = pattern.matcher(s);
            if (m.find()){
                throw new Exception("Invalid roman numeral");
            }
        }
        //validation
        if (romanNumeral ==null || romanNumeral.isEmpty()) {
            throw new Exception("Invalid roman numeral!");
        }
        //
        for (int i = 0; i < decimal.length; i++) {
            while (romanNumeral.indexOf(roman[i]) == 0) {
                result += decimal[i];
                romanNumeral = romanNumeral.substring(roman[i].length());
            }
        }
        return result;
    }
}
