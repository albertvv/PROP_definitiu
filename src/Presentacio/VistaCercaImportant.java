/*
 * Created by JFormDesigner on Sun May 29 19:51:04 CEST 2016
 */

package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Ãlvar HernÃ¡ndez
 */
public class VistaCercaImportant {
    private CtrlPresentacio cp;
    private VistaRelImportant vrelimp;

    public VistaCercaImportant(CtrlPresentacio ctrl) {
        initComponents();
        this.cp = ctrl;
        vrelimp = new VistaRelImportant(cp);
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    private void enrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        vrelimp.ferVisible();
    }

    private void cercaActionPerformed(ActionEvent e) {
        try {
            if(cp.exist_relacio(tiprel.getText())) {

            }
            else JOptionPane.showMessageDialog(frame,
                    "Aquest tipus de relació no existeix", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e1) {
            JOptionPane.showMessageDialog(frame, "aquí hi ha algún problema","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        label1 = new JLabel();
        enrere = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        tiprel = new JTextField();
        priment = new JTextField();
        cerca = new JButton();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //---- label1 ----
            label1.setText("Cerca Relaci\u00f3 Important");

            //---- enrere ----
            enrere.setText("Enrere");
            enrere.addActionListener(e -> enrereActionPerformed(e));

            //---- label2 ----
            label2.setText("Tipus de relaci\u00f3:");

            //---- label3 ----
            label3.setText("Primera entitat:");

            //---- cerca ----
            cerca.setText("Cerca");
            cerca.addActionListener(e -> cercaActionPerformed(e));

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addComponent(enrere)
                                .addGap(56, 56, 56)
                                .addComponent(label1))
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGroup(frameContentPaneLayout.createParallelGroup()
                                    .addComponent(label2)
                                    .addComponent(label3))
                                .addGap(18, 18, 18)
                                .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tiprel, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(priment, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap(287, Short.MAX_VALUE)
                        .addComponent(cerca)
                        .addGap(14, 14, 14))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addComponent(enrere)
                            .addComponent(label1))
                        .addGap(18, 18, 18)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(tiprel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(priment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(cerca)
                        .addGap(17, 17, 17))
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
    private JLabel label2;
    private JLabel label3;
    private JTextField tiprel;
    private JTextField priment;
    private JButton cerca;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
