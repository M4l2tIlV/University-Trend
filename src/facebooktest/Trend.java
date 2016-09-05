/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facebooktest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.Writer;
 

/**
 *
 * @author Me
 */
public class Trend {
    public static int scoreH;
    public static int scoreS;
    public static ArrayList<String> read;
    
    
    private static ArrayList<String> readFile(String fileName){
         read = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File(fileName));
            while(in.hasNext()){
                read.add(in.nextLine());
            }
            } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found: "+e.getMessage());
        }
        return read;
    }
    
   
    public static int getTrendScore(final String message){
        scoreH = 0;
        scoreS = 0;
        ArrayList<String> fileGood = readFile("goodword.txt");
        ArrayList<String> fileBad = readFile("badword.txt");
        
        //Compute Score for good
        for (Iterator<String> it = fileGood.iterator(); it.hasNext();) {
            String word = it.next();
            if(message.contains(word)){
                scoreH++;
            }
        }
        
        //Compute score for bad
        for (Iterator<String> it = fileBad.iterator(); it.hasNext();) {
            String word = it.next();
            if(message.contains(word)){
                scoreS++;
            }
        }
        
        if(scoreH < scoreS){
            return -scoreS;
        } 
            return scoreH;
        
    }   
    
    public void resetScore(){
        
    }
    
    public static int countLine(String fileName) throws FileNotFoundException{
        //read file
        int cnt = 0;
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNextLine()){
            cnt++;
            sc.nextLine();
        }
        
        return cnt;
    }
    
    public static void writeFile(String fileName, StringBuilder sb){
        try{
            try (Writer output = new FileWriter(new File(fileName))) {
                output.write(sb.toString());
            }
            JOptionPane.showMessageDialog(null, "Write file successful",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public static String scoreToColor(int score){
        return null;
    }
}
