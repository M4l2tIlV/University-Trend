/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facebooktest;

import com.restfb.*;
import com.restfb.json.*;
import com.restfb.types.*;
import com.restfb.util.*;
import com.restfb.exception.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Student Lab
 */
public class FaceBookTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String accessToken = "Put Your FB Token here!!";
      
        Facebook myfb = Facebook.getFB(accessToken);
        
        System.out.println(myfb.getMyName());
        System.out.println(myfb.getLastMsg(myfb.getFid(myfb.user)));
      
    }
}
