/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author bernat
 */
public class principal extends javax.swing.JFrame {

    /**
     * Creates new form principal
     */
    CtrlPresentacio ctr_pres;
    public principal(CtrlPresentacio ctr) {
        initComponents();
        ctr_pres = ctr;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Albert Val
    private void initComponents() {
        sortir = new JButton();
        usuari = new JButton();
        graf = new JButton();
        cerques = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //---- sortir ----
        sortir.setText("Sortir");
        sortir.addActionListener(e -> sortirActionPerformed(e));

        //---- usuari ----
        usuari.setText("Gestio usuari");
        usuari.addActionListener(e -> usuariActionPerformed(e));

        //---- graf ----
        graf.setText("Gestio graf");
        graf.addActionListener(e -> grafActionPerformed(e));

        //---- cerques ----
        cerques.setText("Cerques");
        cerques.addActionListener(e -> {
			cerquesActionPerformed(e);
			cerquesActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sortir)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(148, 148, 148)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(usuari, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(graf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cerques, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(138, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(sortir)
                    .addGap(56, 56, 56)
                    .addComponent(usuari)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(graf)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cerques)
                    .addGap(0, 68, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortirActionPerformed
        setVisible(false);
        ctr_pres.inici();
    }//GEN-LAST:event_sortirActionPerformed

    private void usuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariActionPerformed
        setVisible(false);
        ctr_pres.gestio_usuari();
    }//GEN-LAST:event_usuariActionPerformed

    private void grafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grafActionPerformed
        setVisible(false);
      //  ctr_pres.relacions_directes();
    }//GEN-LAST:event_grafActionPerformed

    private void cerquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerquesActionPerformed
       ctr_pres.vistacerques();
        setVisible(false);
    }//GEN-LAST:event_cerquesActionPerformed

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
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal(ctr_pres).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Albert Val
    private JButton sortir;
    private JButton usuari;
    private JButton graf;
    private JButton cerques;
    // End of variables declaration//GEN-END:variables
}
