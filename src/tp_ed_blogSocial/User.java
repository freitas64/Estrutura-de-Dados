/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author ruifreitas
 */
public class User  {
    private static final AtomicLong NEXT_ID = new AtomicLong(1);
    private final long id = NEXT_ID.getAndIncrement();
    private String name,email, username;
    private long credits;
    LinkedList<User> pedidosAmizade = new LinkedList<>();
    
    

    public User(String name, String email, String username, int credits) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.credits = credits;
    }
    
    public User() {

    }
    
    public static AtomicLong getNEXT_ID() {
        return NEXT_ID;
    }
    public long getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getEmail(){
        return email;
    }
    
    public long getCredits(){
        return credits;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setEmail (String email){
           this.email = email;
    }
    
    @Override
    public String toString() {
         
        return "ID: "+id+"\nNome: "+name+"\nUsername: "+username
                +"\nE-mail: "+email+"\nCréditos: "+credits;
    }
    public User ReceiveRequest (User request){
        return null;
    
    }
   
}
