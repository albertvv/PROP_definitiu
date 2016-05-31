/*
 * Created by JFormDesigner on Tue May 31 23:40:42 CEST 2016
 */

package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Ãlvar HernÃ¡ndez
 */
public class VistaRelDir {
    private CtrlPresentacio cp;
    private VistaCerques vcerques;

    public VistaRelDir(CtrlPresentacio ctrl) {
        initComponents();
        this.cp = ctrl;
        emplenacombo();
    }

    private void emplenacombo() {
        String s[] = {"Paper","Autor","Conferencia","Termino"};
        for (int i = 0; i < s.length; i++) {
            tipus.addItem(s[i]);
        }
        tipus.setSelectedIndex(0);
    }

    private void enrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        if(vcerques==null)vcerques = new VistaCerques(cp);
        vcerques.ferVisible();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        label1 = new JLabel();
        enrere = new JButton();
        label2 = new JLabel();
        tipus = new JComboBox();
        label3 = new JLabel();
        textField1 = new JTextField();
        cerca = new JButton();
        dialog1 = new JDialog();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //---- label1 ----
            label1.setText("Relacions directes");

            //---- enrere ----
            enrere.setText("Enrere");
            enrere.addActionListener(e -> enrereActionPerformed(e));

            //---- label2 ----
            label2.setText("Tipus Entitat:");

            //---- label3 ----
            label3.setText("Nom Entitat:");

            //---- cerca ----
            cerca.setText("Cerca");

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGroup(frameContentPaneLayout.createParallelGroup()
                                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(enrere))
                                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(frameContentPaneLayout.createParallelGroup()
                                            .addComponent(label3)
                                            .addComponent(label2))))
                                .addGap(36, 36, 36)
                                .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                    .addComponent(cerca)
                                    .addComponent(label1)))
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                    .addComponent(tipus, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
                        .addContainerGap(27, Short.MAX_VALUE))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addComponent(enrere)
                            .addComponent(label1))
                        .addGap(50, 50, 50)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(tipus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(cerca)
                        .addGap(30, 30, 30))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== dialog1 ========
        {
            Container dialog1ContentPane = dialog1.getContentPane();

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGap(0, 399, Short.MAX_VALUE)
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGap(0, 286, Short.MAX_VALUE)
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
    private JFrame frame;
    private JLabel label1;
    private JButton enrere;
    private JLabel label2;
    private JComboBox tipus;
    private JLabel label3;
    private JTextField textField1;
    private JButton cerca;
    private JDialog dialog1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
