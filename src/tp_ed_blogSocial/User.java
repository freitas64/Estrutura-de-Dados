/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import exception.ElementNotFoundException;
import exception.EmptyCollectionException;

import  recursos.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author ruifreitas
 */
public class User implements Comparable{
    private static final AtomicLong NEXT_ID = new AtomicLong(1);
    private final long id = NEXT_ID.getAndIncrement();
    private String name,email, username;
    private int credits;
    ArrayOrderedList<User> pedidosAmizade = new ArrayOrderedList(100);
    LinkedStack<Post> posts = new LinkedStack<>();
    
    

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
    
    public int getCredits(){
        return credits;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCredits(int credits){
        this.credits= credits;
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
    public void adicionarPedido (User request){
        pedidosAmizade.add(request);
    }
     
    public ArrayOrderedList getPedidos() {
       return pedidosAmizade;
        
    }
    
    public void removerDaListaDePedidos (User user) throws ElementNotFoundException,EmptyCollectionException{
        if (pedidosAmizade.isEmpty()){
        throw new EmptyCollectionException("Lista de pedidos de amizade");
        }else{
            pedidosAmizade.remove(user);
        }
        
    }
    
    public void publicarPost (Post post){
        posts.push(post);
    }
    
    public LinkedStack getPosts (){
       return posts;
    }
    
    

    

    @Override
    public int compareTo(Object other) {
        int result;
        if (name.equals(((User) other).name)) {
            result = name.compareTo(((User) other).name);
        } else {
            result = name.compareTo(((User) other).name);
        }
        return result;
    }
   
}
