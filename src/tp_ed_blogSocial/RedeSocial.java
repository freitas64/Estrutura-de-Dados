/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import adt.RedeSocialADT;
import exception.ElementNotFoundException;
import exception.EmptyCollectionException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author ruifreitas
 */
public class RedeSocial extends Rede<User> implements RedeSocialADT<User>{
     public enum Ligacao {
     Amigo, AmigoDeAmigo, NãoExisteLigação, Patrocinado
    };
     private int custoPedido;
    
    
    
    
    
    /**
     * Imprime todos as dados(utilizadores), existentes nos vertices.
     */
    @Override
    public void imprimeTudo() {

        for (int i = 0; i < numVertices; i++) {
            System.out.println("Id: " + vertices[i].getID());
            System.out.println("Nome: " + vertices[i].getName());
            System.out.println("Email: " + vertices[i].getEmail());
            System.out.println("Username: " + vertices[i].getUsername() + "\n");
            System.out.println("Créditos: " + vertices[i].getCredits() + "\n");
            System.out.println("Amigos:\n");
            for (int ii = 0; ii < numVertices; ii++) {

                for (int j = 0; j < numVertices; j++) {
                    if (adjMatrix[ii][0] < Double.POSITIVE_INFINITY && !vertices[i].equals(vertices[j]) && isCaminhoTf(vertices[i], vertices[j])) {
                        //  System.out.println("\t\tId: " + vertices[j].getId());
                        System.out.println("\t\tNome: " + vertices[j].getName());
                        // System.out.println("\t\tIdade: " + vertices[j].getIdade());
                        System.out.println("\t\tUsername: " + vertices[j].getUsername());
                        System.out.println("------------------------\n");

                    }
                }

            }

        }

    }
    
    /**
     * Imprime todos os dados(Utilizadores) de toda a matriz
     *
     * @return
     */
    @Override
    public String imprimetudoString() {

        al.clear();

        String s = "";
        for (int i = 0; i < numVertices; i++) {
            s += "ID: " + getVertices()[i].getID() + "\n";
            s += "Nome: " + getVertices()[i].getName() + "\n";
            s += "Email: " + getVertices()[i].getEmail() + "\n";
            s += "Username: " + getVertices()[i].getUsername() + "\n\n";
            s += "Créditos: " + getVertices()[i].getCredits() + "\n\n";
            s += "Amigos:\n";
            for (int ii = 0; ii < numVertices; ii++) {

                for (int j = 0; j < numVertices; j++) {
                    if (adjMatrix[ii][0] < Double.POSITIVE_INFINITY && !vertices[i].equals(vertices[j]) && isCaminhoTf(vertices[i], vertices[j]) && !al.contains(vertices[j])) {

                        al.add(vertices[j]);

                        s += "\t\tNome: " + getVertices()[j].getName();
                        s += "\t\tUsername: " + getVertices()[j].getUsername();
                        s += "------------------------\n";

                    }
                }

            }
            al.clear();
        }
        return s;
    }
    
    
    /**
     * Imprime os dados de uma pessoa e as amigos da mesma.
     *
     * @param u
     * @return
     */
    @Override
    public String imprimeDadosSTring(User u) {

        al.clear();
        String s = "";
        s += "Id: " + u.getID() + "\n";
        s += "Nome: " + u.getName() + "\n";
        s += "Email: " + u.getEmail() + "\n";
        s += "Username: " + u.getUsername() + "\n";
        s += "Créditos: " + u.getCredits() + "\n";
        s += "Amigos:\n\n";
        for (int i = 0; i < numVertices; i++) {

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][0] < Double.POSITIVE_INFINITY && !u.equals(vertices[j]) && isCaminhoTf(u, vertices[j]) && !al.contains(vertices[j])) {
                    al.add(vertices[j]);
                            s += "Id: " + u.getID() + "\n";
                            s += "Nome: " + u.getName() + "\n";
                            s += "Email: " + u.getEmail() + "\n";
                            s += "Username: " + u.getUsername() + "\n";
                            s += "Créditos: " + u.getCredits() + "\n";
                            s += "------------------------\n";

                }
            }

        }
        al.clear();

        return s;

    }
/**
     * Imprime os dados de um utilizador e as amigos da mesma.
     *
     * @param u
     */
    public void imprimeDados(User u) {

        System.out.println("Id: " + u.getID());
        System.out.println("Nome: " + u.getName());
        System.out.println("Username: " + u.getUsername());
        System.out.println("Email: " + u.getEmail() + "\n");
        System.out.println("Amigos:\n");
        for (int i = 0; i < numVertices; i++) {

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][0] < Double.POSITIVE_INFINITY && !u.equals(vertices[j]) && isCaminhoTf(u, vertices[j])) {
                    System.out.println("\t\tId: " + vertices[j].getID());
                    System.out.println("\t\tNome: " + vertices[j].getName());
                    System.out.println("\t\tEmail: " + vertices[j].getEmail());
                    System.out.println("\t\tUsername: " + vertices[j].getUsername());
                    System.out.println("\t\tCréditos: " + vertices[j].getCredits());
                    System.out.println("------------------------\n");

                }
            }

        }
    }
    /**
     * Return caminho directo
     *
     * @param user1
     * @param user2
     * @return
     */
   
    @Override
    public boolean isCaminhoTf(User user1, User user2) {
        return adjMatrix[getIndex(user1)][getIndex (user2)] < Double.POSITIVE_INFINITY;
    }
    
    /**
     * Return se existe caminho direto, indireto se nao existe caminho.
     *
     * @param user1
     * @param user2
     * @return
     */
     @Override
    public Ligacao isCaminho(User user1, User user2) {
        
            int custo = calcularCredito(user1, user2);
            switch (custo){
                case 0: return Ligacao.NãoExisteLigação; // não existe ligação
                case 2: return Ligacao.Amigo; //amigos 
                case 3: return Ligacao.AmigoDeAmigo; //amigo de amigos
                default: 
                    
                    return Ligacao.Patrocinado;   //pedido patrocinado
                        
            
        }
                
               
    }
    
    public int calcularCredito(User user1, User user2){
        Iterator<User> it;

        
            it = iteratorShortestPath(user1, user2);
            int custo=0;
            while(it.hasNext()){
                it.next();
                custo ++;
            }
           return custo;
           
    }
    
    public void comentarPost(Comment comentario, User user1, User user2, Post post){
        if (isCaminhoTf(user1, user2) == true && post.getPrivacy()== Post.Privacy.privada){
                post.ComentarPost(comentario);
                System.out.println("Comentou a mensagem privada"+post.getTitle()+"("+post.getPrivacy()+")");
                
        }else{
        }if (post.getPrivacy()== Post.Privacy.publica){
                post.ComentarPost(comentario);
                System.out.println("Comentou Mensagem Publica"+post.getTitle()+"("+post.getPrivacy()+")");
        }
    
    }
    
    public void verificarPedido (User user1, User target) {
        Scanner scan = new Scanner(System.in);
        String keyboardOption;
        if(isCaminho(user1, target).equals(Ligacao.Amigo)){
            System.out.println("Já são amigos");
            
        }else{
            if (isCaminho(user1, target).equals(Ligacao.AmigoDeAmigo)){
                target.adicionarPedido(user1);
                System.out.println("Pedido adicionado com sucesso");
            }else
            {
                if (isCaminho(user1, target).equals(Ligacao.Patrocinado)){
                System.out.println("Apenas pode efetuar um pedido patrocionado");
                System.out.println ("Deseja fazer pedido patrocinado? Insira S(sim) ou qualquer outra tecla para não");
                keyboardOption = scan.nextLine();
                keyboardOption = keyboardOption.toUpperCase();
                    if(keyboardOption.equals("S")){
                    pedidoPatrocinado(user1, target);
                                        
                    }
                    
                    else{
                    
                   
                   
                    }
                }else{
                     System.out.println("Não pode efetuar pedido");
                }
               
            }
            
        }
    }
    
     public Ligacao verificarPedidoGrafica (User user1, User target) {
        Ligacao tipo ;
        if(isCaminho(user1, target).equals(Ligacao.Amigo)){
            tipo = Ligacao.Amigo;
            
        }else{
            if (isCaminho(user1, target).equals(Ligacao.AmigoDeAmigo)){
                target.adicionarPedido(user1);
                tipo = Ligacao.AmigoDeAmigo;
            }else
            {
                if (isCaminho(user1, target).equals(Ligacao.Patrocinado)){
                    tipo = Ligacao.Patrocinado;
                
                }else{
                    tipo = Ligacao.NãoExisteLigação;
                }
               
            }
            
        }
        return tipo;
    }  
    
    public void aceitarPedido (User user1, User target) throws ElementNotFoundException, EmptyCollectionException{
               
            user1.removerDaListaDePedidos(target);
            addEdge(target, user1);
        
        
    }
    
    
    public String alcanceMensagem(User user, Post post){
        Iterator<User> it;
        if(post.getPrivacy() == Post.Privacy.privada){
            it = iteratorBFS(user, 1);
           
        }else{
           
            it = iteratorBFS(user, 4);
        }
        
         return imprimeUtilizadores(it);
    }
//     public void pedidoPatrocinado(User user, User target){
//        String emailKeyboard;
//         String usernameKeyboard;
//         Scanner scan = new Scanner(System.in);
//         custoPedido = calcularCredito(user, target);
//        
//        if (isCaminho(user, target).equals(Ligacao.Patrocinado)){
//                System.out.println("Insira email do utilizador a quem deseja fazer o pedido");
//                emailKeyboard = scan.nextLine();
//                System.out.println("Insira o username a quem deseja fazer o pedido");
//                usernameKeyboard = scan.nextLine();
//                if (emailKeyboard.equals(target.getEmail()) && usernameKeyboard.equals(target.getUsername())){
//                    
//                    target.adicionarPedido(user);
//                    user.setCredits(user.getCredits()-custoPedido);
//                    System.out.println("Pedido patrocinado efetuado com sucesso");
//                }else{
//                    System.out.println("E-Mail ou Username inválidos");
//                }
//            
//            
//        }else{
//            System.out.println("Não pode adicionar pedido pois não existe caminho entre ambos");
//        }
//    }
    public void pedidoPatrocinado(User user, User target){
        
         custoPedido = calcularCredito(user, target);
         target.adicionarPedido(user);
         user.setCredits(user.getCredits()-custoPedido);
          
    }
    
    public User[] getVertices() {
        return vertices;
    }

    public String imprimeUtilizadores(Iterator<User> it){
       User u;
       String s ="";
        while (it.hasNext()) {
            u = it.next();
            s+=              
                "           "+u.getID()+"-"+u.getName()+"\n";
        }
        return s;
    }
    
    
    
   
}
