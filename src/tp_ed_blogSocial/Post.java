/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import recursos.*;
import sun.util.calendar.LocalGregorianCalendar;


/**
 *
 * @author ruifreitas
 */
public class Post implements Comparable {
    
   public enum Privacy {
     publica, privada
    };
   
   
    private String post,title;
    private GregorianCalendar date;
    
    private Privacy privacy;
    
    private final LinkedList<Comment> comentarios = new LinkedList<>();
    
    
    public Post (String post, String title, GregorianCalendar date, Privacy privacy){
           
            this.title = title;
            this.post =post;
            this.date =date;
            this.privacy = privacy;
            
    }
    
    public Post(){
        
    
    }
    
    public String getTitle (){
        return title;
    }
    
    public String getPost (){
        return post;
    }
    
    public String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy");
        return sdf.format(date.getTime());
    }
    
    public Privacy getPrivacy(){
        return privacy;
    }
    
    public void ComentarPost(Comment comentario){
        this.comentarios.addElemento(comentario);
    }
    
    public void getComments(){
        
        Iterator it = comentarios.iterator();
        System.out.println("Comentários:");
        while(it.hasNext()){
       System.out.println(it.next());
         
    }
    }
    
    public void setPost(String post){
        this.post = post;
    }
    
    public void serTitle (String title) {
        this.title = title;
    }
    
    public void setPrivacy (Privacy privacy){
        this.privacy = privacy;
    }
    
    @Override
    public int compareTo(Object other) {
        int result;
        if (title.equals(((Post) other).title)) {
            result = title.compareTo(((Post) other).title);
        } else {
            result = post.compareTo(((Post) other).post);
        }
        return result;
    }
    
    @Override
    public String toString() {
         
        return "Title: "+title+"\nCorpo: "+post+"\nPrivacidade: "+privacy
                +"\nData: "+getDate()+"\n";
    }
}
