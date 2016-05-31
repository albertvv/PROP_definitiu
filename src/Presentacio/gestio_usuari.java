/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author bernat
 */
public class gestio_usuari extends javax.swing.JFrame {
    private CtrlPresentacio ctr_pres;
    /**
     * Creates new form gestio_usuari
     */
    private void backActionPerformed(ActionEvent e) {
        ctr_pres.principal();
        setVisible(false);
    }

    private void saveActionPerformed(ActionEvent e) {
        try{
            ctr_pres.guardar_usuaris();
            resposta.setText("Usuaris guardats");
        }
        catch(FileNotFoundException |NullPointerException e2){}
    }

    public gestio_usuari(CtrlPresentacio ctr) {
        initComponents();
        ctr_pres = ctr;
        if(!ctr_pres.privilegiat()) privilegiat.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Bernat Diaz
    private void initComponents() {
        modificar = new JButton();
        borrar = new JButton();
        privilegiat = new JButton();
        relacions = new JButton();
        sortir = new JButton();
        back = new JButton();
        save = new JButton();
        resposta = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- modificar ----
        modificar.setText("modificar l'usuari");
        modificar.addActionListener(e -> modificarActionPerformed(e));

        //---- borrar ----
        borrar.setText("esborrar l'usuari");
        borrar.addActionListener(e -> borrarActionPerformed(e));

        //---- privilegiat ----
        privilegiat.setText("gesti\u00f3 privilegiat");
        privilegiat.addActionListener(e -> privilegiatActionPerformed(e));

        //---- relacions ----
        relacions.setText("gestio de relacions");
        relacions.addActionListener(e -> relacionsActionPerformed(e));

        //---- sortir ----
        sortir.setText("Sortir");
        sortir.addActionListener(e -> sortirActionPerformed(e));

        //---- back ----
        back.setText("Enrere");
        back.addActionListener(e -> backActionPerformed(e));

        //---- save ----
        save.setText("Guardar canvis");
        save.addActionListener(e -> saveActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(back)
                    .addGap(58, 58, 58)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(relacions)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                            .addComponent(sortir))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(borrar, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(modificar, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(save, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(privilegiat, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(resposta, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addContainerGap())))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sortir)
                            .addComponent(back))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(relacions)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(modificar)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(borrar)
                        .addComponent(resposta))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(save)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(privilegiat)
                    .addContainerGap(48, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        setVisible(false);
        ctr_pres.modificar_usuari_estandard();
    }//GEN-LAST:event_modificarActionPerformed

    private void relacionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacionsActionPerformed
        setVisible(false);
        ctr_pres.gestio_relacions();
    }//GEN-LAST:event_relacionsActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
       ctr_pres.borrar_usuari_estandard();
       setVisible(false);
       try {
           ctr_pres.inici();
       } catch (Exception exc) {
           System.out.println("error estrany");
       }
    }//GEN-LAST:event_borrarActionPerformed

    private void privilegiatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privilegiatActionPerformed
        setVisible(false);
        ctr_pres.gestio_privilegiat();
    }//GEN-LAST:event_privilegiatActionPerformed

    private void sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirActionPerformed
        setVisible(false);
        try {
            ctr_pres.inici();
        } catch (Exception exc) {
            System.out.println("error estrany");
        }
    }//GEN-LAST:event_sortirActionPerformed

    /**
     */
    public void vista() {
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
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestio_usuari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestio_usuari(ctr_pres).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bernat Diaz
    private JButton modificar;
    private JButton borrar;
    private JButton privilegiat;
    private JButton relacions;
    private JButton sortir;
    private JButton back;
    private JButton save;
    private JLabel resposta;
    // End of variables declaration//GEN-END:variables
}
