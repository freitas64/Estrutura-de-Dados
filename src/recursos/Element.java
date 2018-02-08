/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author Fábio Rêgo
 */
public class Element<T> {
    private T valor;
    Element next;

    public Element(T valor) {
        this.valor = valor;
        this.next = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    
    
    
}

