/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facebooktest;
import java.util.ArrayList;

/**
 *
 * @author Me
 */
public class StudentGroup {
    
    ArrayList<String> students;
    
    public StudentGroup(){
        students = new ArrayList<String>();
    }
    
    public void addData(String name){
        students.add(name);
    }
    
}
