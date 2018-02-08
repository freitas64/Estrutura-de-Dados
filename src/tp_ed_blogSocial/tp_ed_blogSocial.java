/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import exception.ElementNotFoundException;
import exception.EmptyCollectionException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import static tp_ed_blogSocial.Post.Privacy.*;

/**
 *
 * @author ruifreitas
 */
public class tp_ed_blogSocial {

    /**
     * @param args the command line arguments
     * @throws exception.EmptyCollectionException
     * @throws exception.ElementNotFoundException
     */
    public static void main(String[] args) throws EmptyCollectionException, ElementNotFoundException {
        User user1 = new User("Rui", "rui@mail.com", "ruifreitas", 200);
        User user2 = new User("RuiMiguel", "ruasdasi@mail.com", "ruifasdasdreitas", 250);
        User user3 = new User("RuiMiguel21321", "ruasdasi@mail.com", "ruifasdasdreitas", 250);
         User user4 = new User("CoisaAnaMiguel21321", "ana@mail.com", "anafilipa", 2220);
        
        System.out.println(user1.toString());
        System.out.println("\n");
        System.out.println(user2.toString());
        System.out.println("\n");
        System.out.println(user3.toString());
        user1.FriendshipRequest(user2);
        user1.FriendshipRequest(user3);
        user1.FriendshipRequest(user4);
        
        
        System.out.println("\nPedidos de Amizade Sem remove");
        System.out.println(user1.getPedidos());
        
        user1.removeAmizade(user3);
        System.out.println("\nPedidos de Amizade");
        System.out.println(user1.getPedidos());
              
        Post p1 = new Post("asfsf","sadasd",new GregorianCalendar(2018, 02, 8) , privada);
        System.out.println (p1.getPrivacy());
        System.out.println (p1.getDate());
        System.out.println (p1.getTitle());
    }
}