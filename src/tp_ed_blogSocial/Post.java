/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import recursos.*;
import sun.util.calendar.LocalGregorianCalendar;


/**
 *
 * @author ruifreitas
 */
public class Post {
    
   
    private String post,title;
    private GregorianCalendar date;
    public enum Privacy {
     publica, privada
    };
    private Privacy privacy;
    
    private final ArrayStack<Comment> comentarios;
    
    
    public Post (String post, String title, GregorianCalendar date, Privacy privacy){
            this.comentarios = new ArrayStack<>();
            this.title = title;
            this.post =post;
            this.date =date;
            this.privacy = privacy;
            
    }
    
    public Post(){
        this.comentarios = new ArrayStack<>();
    
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
        this.comentarios.push(comentario);
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
    
    
}
