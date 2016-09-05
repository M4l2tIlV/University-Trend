/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebooktest;

import java.awt.Color;

/**
 *
 * @author Me
 */
public class StudentController {

    private static StudentGroup freshman;
    private static StudentGroup sophomore;
    private static StudentGroup junior;
    private static StudentGroup senior;

    public StudentController() {
        freshman = new StudentGroup();
        senior = new StudentGroup();
        junior = new StudentGroup();
        sophomore = new StudentGroup();
    }

    public void addNewStudent(String lastpost, String year) {
        switch (year) {
            case "1":
                freshman.addData(lastpost);
                break;
            case "2":
                sophomore.addData(lastpost);
                break;
            case "3":
                junior.addData(lastpost);
                break;
            case "4":
                senior.addData(lastpost);
                break;
        }
    }

    public Color getColorByYear(String y) {
        int totalscoreH = 0;
        int totalscoreS = 0;
        int cntH = 0;
        int cntS = 0;
        int color;

        if (y.equals("1")) {
            for (int i = 0; i < freshman.students.size(); i++) {
                String post = freshman.students.get(i);
                int score = Trend.getTrendScore(post);
                if (score < 0) {
                    totalscoreS += Math.abs(score);
                    cntS++;
                } else {
                    totalscoreH += Math.abs(score);
                    cntH++;
                }
            }
        } else if (y.equals("2")) {
            for (int i = 0; i < sophomore.students.size(); i++) {
                String post = sophomore.students.get(i);
                int score = Trend.getTrendScore(post);
                if (score < 0) {
                    totalscoreS += Math.abs(score);
                    cntS++;
                } else {
                    totalscoreH += Math.abs(score);
                    cntH++;
                }
            }
        } else if (y.equals("3")) {
            for (int i = 0; i < junior.students.size(); i++) {
                String post = junior.students.get(i);
                int score = Trend.getTrendScore(post);
                if (score < 0) {
                    totalscoreS += Math.abs(score);
                    cntS++;
                } else {
                    totalscoreH += Math.abs(score);
                    cntH++;
                }
            }
        } else {
            for (int i = 0; i < senior.students.size(); i++) {
                String post = senior.students.get(i);
                int score = Trend.getTrendScore(post);
                if (score < 0) {
                    totalscoreS += Math.abs(score);
                    cntS++;
                } else {
                    totalscoreH += Math.abs(score);
                    cntH++;
                }
            }

        }
        if (cntS < cntH) {
            color = totalscoreH;
        } else {
            color = -totalscoreS;
        }

        return scoreToColor(color);
    }

    public Color scoreToColor(int score) {
        Color color;
        
        if(score < 0){
            int g = 255 - Math.abs(score);
            int b = 255 - Math.abs(score);
            color = new Color(255, g, b);
        } else {
            int r = 62;
            int b = 161;
            color = new Color(r+score/2,b+score*2,0);
        }
        
        return color;
    }

}
