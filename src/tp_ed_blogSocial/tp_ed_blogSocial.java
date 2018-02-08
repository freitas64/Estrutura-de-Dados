/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

/**
 *
 * @author ruifreitas
 */
public class tp_ed_blogSocial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user1 = new User("Rui", "rui@mail.com", "ruifreitas", 200);
        User user2 = new User("RuiMiguel", "ruasdasi@mail.com", "ruifasdasdreitas", 250);
        System.out.println(user1.toString());
        System.out.println("\n");
        System.out.println(user2.toString());
    }
    
}
