/*
 * Created by JFormDesigner on Mon May 30 11:36:17 CEST 2016
 */

package Presentacio;

import java.awt.event.*;
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
    private VistaRelImportant vrelimp;
    private Vector<Pair<String, SparseVector>> conjresimps;

    public VistaAnteriorsImp(CtrlPresentacio ctrl) {
        initComponents();
        this.cp = ctrl;
        conjresimps = cp.UltimsImp();
        imprimeixResultats();
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    private void imprimeixResultats() {
        Vector<String> res = new Vector<>();
        for (int i = 0; i < conjresimps.size(); i++) {
            String id = new String();
            int j = 0;
            while(Character.isDigit(conjresimps.get(i).getKey().charAt(j))) {
                id += conjresimps.get(i).getKey().charAt(j);
                ++j;
            }
            ++j;
            String relacio = cp.get_nom_relacio(conjresimps.get(i).getKey().substring(j));
            String nom = cp.IDToNom(Integer.parseInt(id), cp.TipusEquilvalent(conjresimps.get(i).getKey().charAt(j)));
            res.add("Nom de la entitat cercada: " + nom);
            res.add("Tipus de relació per a la cerca: " + relacio);
            res.add("");
        }
        ultres.setListData(res.toArray(new String[res.size()]));
    }

    private void enrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        vrelimp = new VistaRelImportant(cp);
        vrelimp.ferVisible();
    }

    private void infoActionPerformed(ActionEvent e) {
        if(ultres.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(frame, "Per a informació adicional has de seleccionar un resultat", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            resdet.setVisible(true);
            resdet.pack();
            resdet.setLocationRelativeTo(frame);
            frame.setFocusable(false);
            int i = 0;
            while(Character.isDigit(conjresimps.get(ultres.getLeadSelectionIndex()/3).getKey().charAt(i))) {++i;}
            ++i;
            Character t = conjresimps.get(ultres.getLeadSelectionIndex()).getKey().charAt(i);
            res.setListData(cp.MostraRelImp(conjresimps.get(ultres.getLeadSelectionIndex()/3).getValue(),
                    cp.TipusEquilvalent(t)));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        enrere = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        ultres = new JList();
        info = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        resdet = new JDialog();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        res = new JList();
        button1 = new JButton();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //---- enrere ----
            enrere.setText("Enrere");
            enrere.addActionListener(e -> enrereActionPerformed(e));

            //---- label1 ----
            label1.setText("\u00daltims Resultats de Relacions Importants");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(ultres);
            }

            //---- info ----
            info.setText("Info");
            info.addActionListener(e -> infoActionPerformed(e));

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
                        .addComponent(enrere)
                        .addGap(26, 26, 26)
                        .addComponent(label1)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(info)
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
                            .addComponent(enrere)
                            .addComponent(label1))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(info)
                            .addComponent(button3)
                            .addComponent(button4))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== resdet ========
        {
            Container resdetContentPane = resdet.getContentPane();

            //---- label2 ----
            label2.setText("Resultat Important Detallat");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(res);
            }

            //---- button1 ----
            button1.setText("OK");

            GroupLayout resdetContentPaneLayout = new GroupLayout(resdetContentPane);
            resdetContentPane.setLayout(resdetContentPaneLayout);
            resdetContentPaneLayout.setHorizontalGroup(
                resdetContentPaneLayout.createParallelGroup()
                    .addGroup(resdetContentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(resdetContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label2)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button1))
                        .addContainerGap(28, Short.MAX_VALUE))
            );
            resdetContentPaneLayout.setVerticalGroup(
                resdetContentPaneLayout.createParallelGroup()
                    .addGroup(resdetContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1)
                        .addContainerGap(12, Short.MAX_VALUE))
            );
            resdet.pack();
            resdet.setLocationRelativeTo(resdet.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
    private JFrame frame;
    private JButton enrere;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList ultres;
    private JButton info;
    private JButton button3;
    private JButton button4;
    private JDialog resdet;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList res;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
