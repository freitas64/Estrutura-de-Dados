/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import exception.ElementNotFoundException;
import exception.EmptyCollectionException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        User user1 = new User("Rui", "rui@mail.com", "ruifreitas", 20);
        User user2 = new User("Miguel", "miguel@mail.com", "miguelribeiro", 30);
        User user3 = new User("Ana", "ana@mail.com", "anpereira", 15);
        User user4 = new User("Filipa", "filipa@mail.com", "filipaoliveira", 10);
        User user5 = new User("Rita", "rita@mail.com", "ritafreitas", 23);
        
        System.out.println(user1.toString());
        System.out.println("\n");
        System.out.println(user2.toString());
        System.out.println("\n");
        System.out.println(user3.toString());
        user1.adicionarPedido(user2);
        user1.adicionarPedido(user3);
        user1.adicionarPedido(user4);
        
        
        System.out.println("\nPedidos de Amizade Sem remove");
        System.out.println(user1.getPedidos());
        
        user1.removerDaListaDePedidos(user3);
        System.out.println("\nPedidos de Amizade");
        System.out.println(user1.getPedidos());
              
        Post p1 = new Post("asfsf","sadasd",new GregorianCalendar(2018, 02, 8) , privada);
        Post p2 = new Post("post 2","post2",new GregorianCalendar(2018, 11, 8) , privada);
        Post p3 = new Post("Mensagem ", "Teste", new GregorianCalendar(2018, 11, 1), publica);
        
         
        
       
       
        Comment c1 = new Comment(new GregorianCalendar(2018, 03, 8), "Primeiro Comentário", user3);
        Comment c2 = new Comment(new GregorianCalendar(2018, 03, 8), "Segundo Comentário", user2);
        Comment c3 = new Comment(new GregorianCalendar(2018, 02, 8), "Terceiro Comentário", user1);
        Comment c4 = new Comment(new GregorianCalendar(2018, 02, 8), "Quarto Comentário", user2);
        
        user1.publicarPost(p3);
        user1.publicarPost(p1);
        
        
        
       
        System.out.println("\nPosts:");

        System.out.println(user1.getPosts());
        Iterator<User> it;
       
        RedeSocial r = new RedeSocial();
        
        r.addVertex(user1);
        r.addVertex(user2);
        r.addVertex(user3);
        r.addVertex(user4);
        r.addVertex(user5);
        
        r.addEdge(user1, user2);
        
        
        
        r.addEdge(user3, user2);
        r.addEdge(user3, user4);
        r.addEdge(user4, user5);
         
        
        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------\n");
      System.out.println(r.isCaminho(user1, user3));
        System.out.println(r.isCaminhoTf(user1, user2));
        r.imprimeDados(user2);
        
        r.comentarPost(c4, user2, user1, p1);
        r.comentarPost(c2, user2, user1, p1);
        r.comentarPost(c1, user2, user1, p1);
        r.comentarPost(c4, user2, user1, p1);
        p1.getComments();
        r.comentarPost(c3, user1, user2, p2);
        p2.getComments();
        
        p2.ComentarPost(c4);
         Iterator<Comment> itComment;
                itComment = p2.getComments().iterator();
                while(!itComment.hasNext()){
                Comment c;
                c =  (Comment) itComment.next();
                System.out.println("\t------------------------------------------");
                System.out.println("\tComentário:" + c.getComment());
                System.out.println("\tData:" + c.getDate());
                System.out.println("\tUtilizador:"+c.getUser().getName());
                
        
                }
        
         System.out.println("Teste");
         
         it = r.iteratorBFS(user1);
        User p;
        p = it.next();

        System.out.println("Id:" + p.getID());
        System.out.println("Nome:" + p.getName());
        
        System.out.println("Amigos:");

        while (it.hasNext()) {
            p = it.next();

            System.out.println("------------------------------------");
                System.out.println("\tId: " + p.getID());
                System.out.println("\tNome: " + p.getName());
                
                

            

        }
        
        r.verificarPedido(user1, user3);
       
       r.imprimeUtilizadores(r.iteratorShortestPath(user1, user3));
        System.out.println("Pedidos");
        System.out.println(user3.getPedidos());
        r.aceitarPedido(user3, user1);
        r.verificarPedido(user1, user3);
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy HH:mm");
        
        System.out.println(sdf.format(Calendar.getInstance().getTime()));
        
        
        
        
//        //r.verificarPedido(user1, user5);
//        System.out.println(user1.getCredits());
//        System.out.println("Pedidos do user "+user5.getName());
//        System.out.println(user5.getPedidos());
//        System.out.println(user5.getName()+"\tNcreditos:"+user5.getCredits());
//        
//        r.aceitarPedido(user5, user1);
//        System.out.println(user1.getCredits());
//        System.out.println("Ver pedido depois de aceite");
//        System.out.println(user5.getName()+"\tNPedidos:"+user5.getPedidos());
//        System.out.println(user5.getName()+"\tNcreditos:"+user5.getCredits());
//        //r.verificarPedido(user1, user5);
//        
        System.out.println(r.toString());
    
       
      
    }
}