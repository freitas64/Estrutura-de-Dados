/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author ruifreitas
 */
public class Comment {
    private GregorianCalendar date;
    private String comment;
    private User user;

    public Comment(GregorianCalendar date, String comment, User user) {
        this.date = date;
        this.comment = comment;
        this.user = user;
    }
    
    public Comment(){
    
    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy");
        return sdf.format(date.getTime());
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "################\nData: " + getDate() + "\nComentário: " + comment + "\nUtilizador: " + user.getName();
    }
    
    
}
