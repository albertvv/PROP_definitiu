/*
 * Created by JFormDesigner on Mon May 30 11:36:17 CEST 2016
 */

package Presentacio;

import org.la4j.vector.SparseVector;
import javafx.util.*;

import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Ãlvar HernÃ¡ndez
 */
public class VistaAnteriorsImp {
    private CtrlPresentacio cp;
    public VistaAnteriorsImp(CtrlPresentacio ctrl) {
        initComponents();
        this.cp = ctrl;
        imprimeixResultats();
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    private void imprimeixResultats() {
        //Vector<Pair<String, SparseVector>> conjresimps = cp.UltimsImps();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        button1 = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //---- button1 ----
            button1.setText("Enrere");

            //---- label1 ----
            label1.setText("\u00daltims Resultats de Relacions Importants");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(list1);
            }

            //---- button2 ----
            button2.setText("Info");

            //---- button3 ----
            button3.setText("Creua Resultats");

            //---- button4 ----
            button4.setText("Filtra");

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button1)
                        .addGap(26, 26, 26)
                        .addComponent(label1)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(button2)
                        .addGap(61, 61, 61)
                        .addComponent(button3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(button4)
                        .addGap(23, 23, 23))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(label1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button3)
                            .addComponent(button4))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
    private JFrame frame;
    private JButton button1;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
