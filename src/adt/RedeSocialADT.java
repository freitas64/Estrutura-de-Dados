/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

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
    public String isCaminho(User user1, User user2);
    
    /**
     * Imprime todos as dados(utilizadores), existentes nos vertices.
     */
    public void imprimeTudo();
    
     /**
     * Imprime todos os dados(Utilizadores) de toda a matriz
     *
     * @return
     */
    public String imprimetudoString();
    
      /**
     * Imprime os dados de uma pessoa e as amigos da mesma.
     *
     * @param u
     * @return
     */
    public String imprimeDadosSTring(User u);
}
