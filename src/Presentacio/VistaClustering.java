/*
 * Created by JFormDesigner on Mon May 16 17:29:57 CEST 2016
 */

package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @author Albert Val
 */
public class VistaClustering extends JFrame {
    private final CtrlPresentacio cp;
    private VistaCerques vcerques;
    private VistaCercaClustering vcclust;
    private VistaUltimsClust vultims;

    public VistaClustering(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
    }


    private void EnrereActionPerformed(ActionEvent e) {
        this2.setVisible(false);
        if(vcerques==null) vcerques = new VistaCerques(cp);
        vcerques.ferVisible();
    }

    private void clustActionPerformed(ActionEvent e) {
        this2.setVisible(false);
        if(vcclust==null) vcclust = new VistaCercaClustering(cp);
        vcclust.ferVisible();
    }

    private void utlimagrupActionPerformed(ActionEvent e) {
        this2.setVisible(false);
        if(vultims==null) vultims = new VistaUltimsClust(cp);
        vultims.ferVisible();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Albert Val
        this2 = new JFrame();
        jPanel1 = new JPanel();
        enrere = new JButton();
        clust = new JButton();
        utlimagrup = new JButton();

        //======== this2 ========
        {
            this2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container this2ContentPane = this2.getContentPane();

            //======== jPanel1 ========
            {

                // JFormDesigner evaluation mark
                jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- enrere ----
                enrere.setText("Enrere");
                enrere.addActionListener(e -> EnrereActionPerformed(e));

                //---- clust ----
                clust.setText("Clustering");
                clust.addActionListener(e -> clustActionPerformed(e));

                //---- utlimagrup ----
                utlimagrup.setText("\u00daltimes agrupacions");
                utlimagrup.addActionListener(e -> utlimagrupActionPerformed(e));

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup()
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup()
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(enrere, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(282, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 108, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clust, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(utlimagrup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(132, 132, 132))))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup()
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(enrere, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(clust, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(utlimagrup, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(88, Short.MAX_VALUE))
                );
            }

            GroupLayout this2ContentPaneLayout = new GroupLayout(this2ContentPane);
            this2ContentPane.setLayout(this2ContentPaneLayout);
            this2ContentPaneLayout.setHorizontalGroup(
                this2ContentPaneLayout.createParallelGroup()
                    .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            this2ContentPaneLayout.setVerticalGroup(
                this2ContentPaneLayout.createParallelGroup()
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Albert Val
    private JFrame this2;
    private JPanel jPanel1;
    private JButton enrere;
    private JButton clust;
    private JButton utlimagrup;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void ferVisible() {
        this2.setVisible(true);
    }
}
