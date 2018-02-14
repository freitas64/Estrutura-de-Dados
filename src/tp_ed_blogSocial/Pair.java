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
public class Pair<T> {
    private T left,right;

    public Pair(T left, T right) {
        this.left = left;
        this.right = right;
    }

    
    
    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
    
}
