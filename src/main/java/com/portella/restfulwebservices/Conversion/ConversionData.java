package com.portella.restfulwebservices.Conversion;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 */
public class ConversionData {

    private final static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    private int getRomanNumeralValue(char roman) {
        if (map.containsKey(roman)) {
            return map.get(roman);
        } else {
            throw new RuntimeException("Roman numeral string contains invalid characters " + roman);
        }
    }
    public int convertRomanToDecimal(String romanDecimal) {
        String a = romanDecimal.toUpperCase();
        if (!StringUtils.hasLength(a)) {
            throw new RuntimeException("Roman numeral string is either null or empty");
        }
        else {
            int index = a.length() - 1;
            int result = getRomanNumeralValue(a.charAt(index));

            for (int i = index - 1; i >= 0; i--) {
                if (getRomanNumeralValue(a.charAt(i)) >= getRomanNumeralValue(a.charAt(i + 1))) {
                    result = result + getRomanNumeralValue(a.charAt(i));
                }
                else {
                    result = result - getRomanNumeralValue(a.charAt(i));
                }
            }
            return result;
        }
    }

}