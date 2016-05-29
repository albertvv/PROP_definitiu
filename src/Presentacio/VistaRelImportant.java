/*
 * Created by JFormDesigner on Thu May 19 11:50:26 CEST 2016
 */

package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Ãlvar HernÃ¡ndez
 */
public class VistaRelImportant {
    private CtrlPresentacio cp;
    private VistaCerques vcerques;
    private VistaCercaImportant vcercimp;
    private VistaClustering vclustering;

    public VistaRelImportant(CtrlPresentacio ctrl) {
        initComponents();
        this.cp = ctrl;
        vcerques = new VistaCerques(cp);
        vcercimp = new VistaCercaImportant(cp);
        vclustering = new VistaClustering(cp);
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    private void enrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        vcerques.ferVisible();
    }

    private void cercaActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        vcercimp.ferVisible();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        label1 = new JLabel();
        enrere = new JButton();
        ultrelimp = new JButton();
        cerca = new JButton();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //---- label1 ----
            label1.setText("Relacions Importants");

            //---- enrere ----
            enrere.setText("Enrere");
            enrere.addActionListener(e -> enrereActionPerformed(e));

            //---- ultrelimp ----
            ultrelimp.setText("Anteriors Relacions Importants");

            //---- cerca ----
            cerca.setText("Cerca Relaci\u00f3 Important");
            cerca.addActionListener(e -> cercaActionPerformed(e));

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enrere)
                        .addGap(67, 67, 67)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(ultrelimp)
                            .addComponent(label1)
                            .addComponent(cerca))
                        .addContainerGap(128, Short.MAX_VALUE))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(64, 64, 64)
                                .addComponent(cerca)
                                .addGap(64, 64, 64)
                                .addComponent(ultrelimp))
                            .addComponent(enrere))
                        .addContainerGap(69, Short.MAX_VALUE))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
    private JFrame frame;
    private JLabel label1;
    private JButton enrere;
    private JButton ultrelimp;
    private JButton cerca;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}