/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facebooktest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class Test {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String filename = "D:\\Location of friendlist\\friendlist.csv";
        
        Scanner sc = new Scanner(new File(filename));
        String line;
        String lineArr[];
        while(sc.hasNext()){
            line = sc.nextLine();
            lineArr = line.split(",");
            
            System.out.println(lineArr[0] + "-" + lineArr[1] + "-" + lineArr[2]);
        }
       
    }
    
}
