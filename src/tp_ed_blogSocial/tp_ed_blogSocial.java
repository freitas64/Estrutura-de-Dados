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
import java.util.Iterator;
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
        Post p2 = new Post("post 2","post2",new GregorianCalendar(2018, 11, 8) , privada);
        
        
        
        Comment c1 = new Comment();
        p1.ComentarPost(c1);
        user1.publicarPost(new Post("Mensagem ", "Teste", new GregorianCalendar(2018, 11, 1), publica));
        user1.publicarPost(p2);
        p1.getComments();
        System.out.println(user1.getPosts());
        Iterator<User> it;
       
        RedeSocial r = new RedeSocial();
        
        r.addVertex(user1);
        r.addVertex(user4);
        r.addVertex(user3);
        r.addVertex(user2);
        
        r.addEdge(user1, user2);
        
        
        
        r.addEdge(user3, user2);
         
        
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------\n");
      System.out.println(r.isCaminho(user1, user4));
        System.out.println(r.isCaminhoTf(user1, user2));
        r.imprimeDados(user2);

    
       
      
    }
}