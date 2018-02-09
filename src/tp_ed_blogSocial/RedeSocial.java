/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ed_blogSocial;

import java.util.Iterator;
import recursos.*;

/**
 *
 * @author ruifreitas
 */
public class RedeSocial extends Rede<User>{
    
    /**
     * Return caminho directo
     *
     * @param user1
     * @param user2
     * @return
     */
    
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
    public String isCaminho(User user1, User user2) {

        Iterator<User> it;

        if (adjMatrix[getIndex(user1)][getIndex(user2)] < Double.POSITIVE_INFINITY) {
            return "São amigos diretamente";
        } else {
            it = iteratorShortestPath(user1, user2);

            if (it.hasNext()) {
                return "Não são amigos, mas pode adicionar!!";
            } else {
                return "Não pode adicionar!! Se tiver email e username do utilizdor "+user2.getName()+" e créditos suficientes "
                        + "pode adicionar";
            }

        }
    }
    
    
    
    /**
     * Imprime todos as dados(utilizadores), existentes nos vertices.
     */
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


    


    
}
