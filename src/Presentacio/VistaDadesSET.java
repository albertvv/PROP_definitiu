package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by marc on 19/5/16.
 */
public class VistaDadesSET {
    public VistaDadesSET() {
        initComponents();
        frame1.setVisible(true);
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistaDadesSET vd = new VistaDadesSET();
                        vd.ferVisible();
                    }});
    }

    private void ferVisible() {
        frame1.setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDADES vd = new VistaDADES();
    }

    private void button2ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDadesSETid vd = new VistaDadesSETid();
    }

    private void button3ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDadesSETnom vd = new VistaDadesSETnom();
    }

    private void button4ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDadesSETtag vd = new VistaDadesSETtag();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hola bebes
        frame1 = new JFrame();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Editar entitat");
            Container frame1ContentPane = frame1.getContentPane();

            //---- button1 ----
            button1.setText("Enrere");
            button1.addActionListener(e -> button1ActionPerformed(e));

            //---- button2 ----
            button2.setText("Modificar ID");
            button2.addActionListener(e -> button2ActionPerformed(e));

            //---- button3 ----
            button3.setText("Modificar nom");
            button3.addActionListener(e -> button3ActionPerformed(e));

            //---- button4 ----
            button4.setText("Modificar etiqueta");
            button4.addActionListener(e -> button4ActionPerformed(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button1)
                        .addGap(32, 32, 32)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(button4))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(button1)
                            .addComponent(button2))
                        .addGap(31, 31, 31)
                        .addComponent(button3)
                        .addGap(31, 31, 31)
                        .addComponent(button4))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hola bebes
    private JFrame frame1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
