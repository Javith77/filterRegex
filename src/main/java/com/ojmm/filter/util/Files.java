/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ojmm.filter.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author over.meneses
 */
public class Files {
    
    public static String getFileExtension(String fileName){
        if (fileName == null) {
            throw new IllegalArgumentException("fileName must not be null!");
        }
        
        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }

        return extension;
    }
    
}
