/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ojmm.filter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author over.meneses
 */
public class Regex {
    
    private static final String REGEX_YYYY_MM = "^(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))(-|/)(0[1-9]|10|11|12)$";
    private static final String REGEX_DATE_DYNAMIC = "^($exp1)(-|/)($exp2)(-|/)(0[1-9]|10|11|12);[A-Z]{3}(-|\\s)?[0-9]{2}[A-Z].+";
//    private static final String REGEX_DOCUMENT_STRUCTURE = "^(.+;.+;.+;.+)$";
    private static final String REGEX_DOCUMENT_STRUCTURE = "^(([1][9]\\d{2})|([2]\\d{3}))(-|/)(0[1-9]|10|11|12)(-|/)(0[1-9]|1[1-9]|2[1-9]|3[1]);([A-Z]{3}(-|\\s)?\\d{3}|[A-Z]{3}(-|\\s)?\\d{2}[a-zA-Z]|[A-Z]{1}(-|\\s)?\\d{4}|[A-Z]{2}(-|\\s)?\\d{4}|(R|S)(-|\\s)?\\d{5});\\d+;.+";
    
    /**
     * evaluate date expression
     * @param term (yyyy (- o /) dd)
     * @return 
     */
    public static boolean isDateYYYYMM(String term){
        return Pattern.compile(REGEX_YYYY_MM).matcher(term).find();
    }
    
     /**
     * evaluation of license plate exprecion
     * 
     * @param term
     * @return 
     */
    public static boolean isAllowedtructure(String term){
        return Pattern.compile(REGEX_DOCUMENT_STRUCTURE, Pattern.CASE_INSENSITIVE).matcher(term).find();
    }
    
    /**
     * filtered content data
     * 
     * @param expression
     * @param content
     * @return 
     */
    public static String filterData(String expression, String content){
        String contentFiltered = "";
        String regexDynamic = REGEX_DATE_DYNAMIC.replace("$exp1", expression.substring(0, 4));
        regexDynamic = regexDynamic.replace("$exp2", expression.substring(5, expression.length())); 
        Pattern pattern = Pattern.compile(regexDynamic, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        
        while (matcher.find()) {
            contentFiltered +=  matcher.group().concat("\r\n");
        }
        return contentFiltered;
    }
}
