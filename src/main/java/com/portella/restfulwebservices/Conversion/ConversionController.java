package com.portella.restfulwebservices.Conversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class ConversionController {


    @GetMapping(path = "/Convert/{romanNumber}")
    public ConversionBean ConversionDataPathVariable(@PathVariable String romanNumber) throws Exception {
       return new ConversionBean(new ConversionData().convertToDecimal(romanNumber.toUpperCase()));
   }
}
