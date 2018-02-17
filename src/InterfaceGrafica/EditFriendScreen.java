/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import tp_ed_blogSocial.User;
import exception.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Sanches 8070027
 * @author José Teixeira 8080328
 */
public class EditFriendScreen extends javax.swing.JFrame {

    private MainScreen screen;

    /**
     * Creates new form EditFriendScreen
     */
    public EditFriendScreen() {
        initComponents();
    }

    public EditFriendScreen(MainScreen screen) {
        this();
        this.screen = screen;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registarPessoa = new javax.swing.JButton();
        removerPessoa = new javax.swing.JButton();
        amigos = new javax.swing.JButton();
        inimigos = new javax.swing.JButton();
        back2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        registarPessoa.setText("Registar (Utilizador)");
        registarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarPessoaActionPerformed(evt);
            }
        });

        removerPessoa.setText("Remover (Utilizador)");
        removerPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPessoaActionPerformed(evt);
            }
        });

        amigos.setText("Amigos");
        amigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amigosActionPerformed(evt);
            }
        });

        inimigos.setText("Inimigos");
        inimigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inimigosActionPerformed(evt);
            }
        });

        back2.setText("Back");
        back2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registarPessoa)
                    .addComponent(removerPessoa)
                    .addComponent(inimigos)
                    .addComponent(amigos))
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(registarPessoa)
                .addGap(18, 18, 18)
                .addComponent(removerPessoa)
                .addGap(18, 18, 18)
                .addComponent(amigos)
                .addGap(18, 18, 18)
                .addComponent(inimigos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(back2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarPessoaActionPerformed

        
    }//GEN-LAST:event_registarPessoaActionPerformed

    private void removerPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPessoaActionPerformed

        

    }//GEN-LAST:event_removerPessoaActionPerformed

    private void amigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amigosActionPerformed

        int i;
        String s = "Introduza o id da Pessoa 1 \n";

        for (i = 0; i < this.screen.netWork.size(); i++) {
            s += "" + this.screen.netWork.getVertices()[i].getID() + "-" + this.screen.netWork.getVertices()[i].getName();
            s += "\n";
        }

        int j;
        String s1 = "Introduza o id da Pessoa 2 \n";

        for (j = 0; j < this.screen.netWork.size(); j++) {
            s1 += "" + this.screen.netWork.getVertices()[j].getID() + "-" + this.screen.netWork.getVertices()[j].getName();
            s1 += "\n";
        }

        String nome1 = JOptionPane.showInputDialog(s);
        String nome2 = JOptionPane.showInputDialog(s1);

        long id1 = Long.parseLong(nome1);
        long id2 = Long.parseLong(nome2);

        try {
            this.screen.netWork.addEdgeById(id1, id2);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(EditFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_amigosActionPerformed

    private void inimigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inimigosActionPerformed

        int i;
        String s = "Introduza o id da Pessoa 1 \n";

        for (i = 0; i < this.screen.netWork.size(); i++) {
            s += "" + this.screen.netWork.getVertices()[i].getID() + "-" + this.screen.netWork.getVertices()[i].getName();
            s += "\n";
        }

        int j;
        String s1 = "Introduza o id da Pessoa 2 \n";

        for (j = 0; j < this.screen.netWork.size(); j++) {
            s1 += "" + this.screen.netWork.getVertices()[j].getID() + "-" + this.screen.netWork.getVertices()[j].getName();
            s1 += "\n";
        }

        String nome1 = JOptionPane.showInputDialog(s);
        String nome2 = JOptionPane.showInputDialog(s1);

        long id1 = Long.parseLong(nome1);
        long id2 = Long.parseLong(nome2);

        try {
            this.screen.netWork.removeEdgeById(id1, id2);
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(EditFriendScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_inimigosActionPerformed

    private void back2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back2ActionPerformed
        this.screen.setEnabled(true);
        this.screen.toFront();
        this.screen.loadLinks();
    }//GEN-LAST:event_back2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditFriendScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFriendScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFriendScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFriendScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFriendScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton amigos;
    private javax.swing.JButton back2;
    private javax.swing.JButton inimigos;
    private javax.swing.JButton registarPessoa;
    private javax.swing.JButton removerPessoa;
    // End of variables declaration//GEN-END:variables
}