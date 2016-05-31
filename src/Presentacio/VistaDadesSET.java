package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by marc on 19/5/16.
 */
public class VistaDadesSET {

    private CtrlPresentacio cp;

    public VistaDadesSET(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
        frame1.setVisible(true);
    }

    private void ferVisible() {
        frame1.setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDADES vd = new VistaDADES(cp);
    }

    private void button2ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        cp.VistaDadesSETid();
    }

    private void button3ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        cp.VistaDadesSETnom();
    }

    private void button4ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        cp.VistaDadesSETtag();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame1 = new JFrame();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();
        button3 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Editar entitat");
            Container frame1ContentPane = frame1.getContentPane();

            //---- button1 ----
            button1.setText("Enrere");
            button1.addActionListener(e -> button1ActionPerformed(e));

            //---- button2 ----
            button2.setText("Modificar ID");

            //---- button4 ----
            button4.setText("Modificar etiqueta");

            //---- button3 ----
            button3.setText("Modificar nom");

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(button1))
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(46, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button1)
                        .addGap(18, 18, 18)
                        .addComponent(button2)
                        .addGap(12, 12, 12)
                        .addComponent(button3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button4)
                        .addContainerGap(23, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame1;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
