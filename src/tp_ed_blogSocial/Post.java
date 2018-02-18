/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;


import recursos.*;



/**
 *
 * @author ruifreitas
 */
public class Post implements Comparable {

    public void ComentarPost(String comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public enum Privacy {
     publica, privada
    };
   
   private static final AtomicLong NEXT_ID = new AtomicLong(1);
    private final long id = NEXT_ID.getAndIncrement();
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
    public static AtomicLong getNEXT_ID() {
        return NEXT_ID;
    }
    public long getID(){
        return id;
    }
    public String getTitle (){
        return title;
    }
    
    public String getPost (){
        return post;
    }
    
    public String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy HH:mm:ss");
        return sdf.format(date.getTime());
    }
    
    public Privacy getPrivacy(){
        return privacy;
    }
    
    public void ComentarPost(Comment comentario){
        this.comentarios.add(comentario);
    }

    public DoubleOrderedList getComments(){
//        String result="";
//      Iterator it = comentarios.iterator();
//                     
//      while(!it.hasNext()){
//             
//          Comment c;
//                c =  (Comment) it.next();
//               result += "\n\tComentário:" + c.getComment()+
//                "\n\tData:" + c.getDate()+
//                "\n\tUtilizador:"+c.getUser().getName()+"\n\t------------------------------------------\n";
//                
//     }
//      
//        return result;
//      Iterator it = comentarios.iterator();
//                     
//       System.out.println("Post:");
//       System.out.println("\tTítulo: "+this.getTitle());
//       System.out.println("\tMensagem: "+this.getPost());
//      System.out.println("\tTítulo: "+this.getDate());
//       System.out.println("\tComentários("+comentarios.count+"):");
//       
//      
//      while(!it.hasNext()){
//             Comment c;
//                c =  (Comment) it.next();
//                System.out.println("\t\t------------------------------------------");
//                System.out.println("\t\tComentário:" + c.getComment());
//                System.out.println("\t\tData:" + c.getDate());
//                System.out.println("\t\tUtilizador:"+c.getUser().getName());
//                
//      }
//      System.out.println("\t\t------------------------------------------");
        return comentarios;
    }
    public String getCommentsToString(){
                 
        String comentario= "";
        
        Iterator it = this.comentarios.iterator();
        Comment c;           
        while(!it.hasNext()){
         
                c =  (Comment) it.next();
               comentario += "\t................................................"
                       + "\n\tComentário:" + c.getComment()+
                "\n\tData:" + c.getDate()+
                "\n\tUtilizador:"+c.getUser().getID()+"-"+c.getUser().getName()+
                       "\n";
                
     }
        return comentario;
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
        result = date.compareTo(((Post) other).date);
        return result;
        
    }
    
    @Override
    public String toString() {
         
        return "Title: "+title+"\nCorpo: "+post+"\nPrivacidade: "+privacy
                +"\nData: "+getDate()+"\n";
    }
    
    
}
