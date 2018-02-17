/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author ruifreitas
 */
public class Comment implements Comparable{
    private Calendar date;
    private String comment;
    private User user;

    public Comment(Calendar date, String comment, User user) {
        this.date = date;
        this.comment = comment;
        this.user = user;
    }
    
    public Comment(){
    
    }

    public String getDate() {
       SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyy HH:mm:ss");
        return sdf.format(date.getTime());
    }

    public String getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public void setDate(Calendar date) {
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

   @Override
    public int compareTo(Object other) {
        int result;
        if (date.equals(((Comment) other).date)) {
            result = date.compareTo(((Comment) other).date);
        } else {
            result = date.compareTo(((Comment) other).date);
        }
        return result;
    }
    
    
}
