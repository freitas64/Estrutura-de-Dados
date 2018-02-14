/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Iterator;
import recursos.*;



/**
 *
 * @author ruifreitas
 */
public class Post implements Comparable {
    
   public enum Privacy {
     publica, privada
    };
   
   
    private String post,title;
    private Calendar date;
    
    private Privacy privacy;
    
   private final DoubleOrderedList<Comment> comentarios = new DoubleOrderedList<>();
    
    
    public Post (String post, String title, Calendar date, Privacy privacy){
           
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
          SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy HH:mm");
        return sdf.format(date.getTime());
    }
    
    public Privacy getPrivacy(){
        return privacy;
    }
    
    public void ComentarPost(Comment comentario){
        this.comentarios.add(comentario);
    }

    public void getComments(){
        
             Iterator it = comentarios.iterator();
                     
       System.out.println("\u001B[34mPost:");
        System.out.println("\tTítulo: "+this.getTitle());
        System.out.println("\tMensagem: "+this.getPost());
        System.out.println("\tTítulo: "+this.getDate());
       System.out.println("\t\u001B[32mComentários("+comentarios.count+"):");
       
      
      while(!it.hasNext()){
             Comment c;
                c =  (Comment) it.next();
                System.out.println("\t\t------------------------------------------");
                System.out.println("\t\tComentário:" + c.getComment());
                System.out.println("\t\tData:" + c.getDate());
                System.out.println("\t\tUtilizador:"+c.getUser().getName());
                
       }
      System.out.println("\t\t------------------------------------------");
    }
    public void setDate(Calendar date){
        this.date = date;
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
