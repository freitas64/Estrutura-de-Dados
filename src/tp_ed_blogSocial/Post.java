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
    public enum Type {
     publica, privada
    };
    private Type type;
    
    private ArrayStack<Comment> comentarios = new ArrayStack<>();
    
    
    public Post (String post, String title, GregorianCalendar date, Type type){
            this.title = title;
            this.post =post;
            this.date =date;
            this.type = type;
            
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
    
    
}
