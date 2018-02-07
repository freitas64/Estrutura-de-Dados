/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_recurso;

import java.util.LinkedList;

/**
 *
 * @author ruifreitas
 */
public class User implements Comparable<User>  {

    private final String name,email, username;
    LinkedList<User> amizades = new LinkedList<>();
    
    private final int credits;

    public User(String name, String email, String username, int credits) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.credits = credits;
    }
    
    public User ReceiveRequest (User request){
        return null;
    
    }
    @Override
    public int compareTo(User o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
