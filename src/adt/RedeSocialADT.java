/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import exception.ElementNotFoundException;
import exception.EmptyCollectionException;
import java.util.Iterator;
import tp_ed_blogSocial.Post;
import tp_ed_blogSocial.RedeSocial;
import tp_ed_blogSocial.User;

/**
 *
 * @author ruifreitas
 */
public interface RedeSocialADT<T> extends RedeADT<T>{
    
    /**
     * Return Caminho direto
     *
     * @param user1
     * @param user2
     */
   public boolean isCaminhoTf(User user1, User user2);
   
    /**
     * Return se existe caminho direto, indireto se nao existe caminho.
     *
     * @param user1
     * @param user2
     * @return
     */
    public RedeSocial.Ligacao isCaminho(User user1, User user2);
    
    
   
    /**
     * Calcula custo de caminho entre dois utilizadores
     *
     * @param user1
     * @param user2
     * @return
     */
    public int calcularCredito(User user1, User user2);
      /**
     * Verifica e adiciona amizade entre dois utilizadores
     *
      * @param user1
     * @param user2
     * @return
     */
    public RedeSocial.Ligacao verificarPedido (User user1, User target);
    
    /**
     * Aceitar pedido de amizade e adicionar aresta à rede
     *
     * @param user1
     * @param user2
     * @return
     */
     public void aceitarPedido (User user1, User target) throws ElementNotFoundException, EmptyCollectionException;
     /**
     * Devolve alcance da mensagem de uma publicação
     *
     * @param user1
     * @param user2
     * @return
     */       
    public String alcanceMensagem(User user, Post post);
    
    
     /**
     * Imprime utilizadores
     *
     * 
     * @return
     */
    public String imprimeUtilizadores(Iterator<User> it);
    
     public User[] getVertices();
     
     /**
     * Efetua um pedido patrocinado quando a ligação entre os dois utilizadores assim requer
     *
     * 
     * @return
     */
     public void pedidoPatrocinado(User user, User target);
}
