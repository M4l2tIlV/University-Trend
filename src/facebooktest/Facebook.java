/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facebooktest;
import com.restfb.*;
import com.restfb.types.*;

/**
 *
 * @author Me
 */
public class Facebook {
    private String myFid;
    private  String accessToken;
    private FacebookClient fbClient;
    private static Facebook fb;
    public User user;
    
    
    public static boolean isConnected;
            
    private Facebook(String accessToken){
        isConnected = false;
        initialFB(accessToken);
    }
    
    public static Facebook getFB(String accessToken){
        if(fb==null){
            return fb = new Facebook(accessToken);
        }
        return fb;
    }

    public void initialFB(String accessToken){
        fbClient = new DefaultFacebookClient(accessToken);
        user = fbClient.fetchObject("me", User.class);
    }

    public String getMyName(){
        return user.getName();
    }

    public User getFriend(String id){
        //User friend;
        User fl = fbClient.fetchObject(id, User.class);
        //friend = fl.getData().get(0);
        
        return fl;
    }
    
    public Connection<User> getFriends(){
        Connection<User> friends = fbClient.fetchConnection("me/friends", User.class);
        return friends;
    }

    public Connection<Post> getFeed(String fid, int limitPost){
        Connection<Post> post = fbClient.fetchConnection(fid+"/feed", Post.class, 
                Parameter.with("limit", limitPost));
        return post;
    }

    public String getLastMsg(String fid){
        return getFeed(fid,1).getData().get(0).getMessage();
        
    }

    public Connection<Post> getMyFeed(){
        Connection<Post> feed = fbClient.fetchConnection("me/feed", Post.class);
        return feed;
    }

    public String getFid(User user){
        return user.getId();
    }

    public String getName(User user){
        return user.getName();
    }
    
    
}
