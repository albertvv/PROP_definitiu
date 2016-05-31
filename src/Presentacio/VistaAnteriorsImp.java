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
    private Integer index;

    public VistaAnteriorsImp(CtrlPresentacio ctrl) throws Exception {
        initComponents();
        this.cp = ctrl;
        conjresimps = cp.UltimsImp();
        imprimeixResultats();
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    private void imprimeixResultats() throws Exception {
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
            res.add("Nom de l'entitat cercada: " + nom + "  |  Tipus de relació per la cerca: " + relacio);
        }
        ultres.setListData(res.toArray(new String[res.size()]));
    }

    private void enrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        vrelimp = new VistaRelImportant(cp);
        vrelimp.ferVisible();
    }

    private void infoActionPerformed(ActionEvent e) throws Exception {
        if(ultres.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(frame, "Per a informació adicional has de seleccionar un resultat", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            index = ultres.getSelectedIndex();
            resdet.setVisible(true);
            resdet.pack();
            resdet.setLocationRelativeTo(frame);
            frame.setFocusable(false);
            int i = 0;
            while(Character.isDigit(conjresimps.get(index).getKey().charAt(i))) {++i;}
            Integer id = Integer.parseInt(conjresimps.get(index).getKey().substring(0,i));
            ++i;
            Character t = conjresimps.get(index).getKey().charAt(i);
            res.setListData(cp.MostraRelImp(conjresimps.get(index).getValue(),
                    cp.TipusEquilvalent(t),id));
        }
    }

    private void filtraActionPerformed(ActionEvent e) {
        if(ultres.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(frame, "Per a filtrar has de seleccionar un resultat", "Error Filtrat", JOptionPane.ERROR_MESSAGE);
        }
        else {
            index = ultres.getSelectedIndex();
            parfil.setVisible(true);
            parfil.pack();
            parfil.setLocationRelativeTo(frame);
            frame.setFocusable(false);
            String etiqs[] = {"Database","Data Mining","AI","Information Retrieval"};
            for (int i = 0; i < etiqs.length; i++) {
                etiquetes.addItem(etiqs[i]);
            }
            etiquetes.setSelectedIndex(0);
        }
    }

    private void acceptarActionPerformed(ActionEvent e) throws Exception {
        String etiq = (String)etiquetes.getSelectedItem();
        Double thres = 0.0;
        Integer nr = 0;
        String t = threshold.getText();
        if(!(nres.getText().length()==0)) {
            nr = Integer.parseInt(nres.getText());
        }
        else JOptionPane.showMessageDialog(frame, "Has d'inserir el nombre mínim de resultats que vols obtenir","Error", JOptionPane.ERROR_MESSAGE);
        if(!(threshold.getText().length() == 0)) {
            System.out.println("entrothres");
            thres = Double.parseDouble(threshold.getText());
        }
        SparseVector sv = cp.FiltraRelimportant(index, 0.0, nr, etiq);
        String id = new String();
        int i = 0;
        while(Character.isDigit(conjresimps.get(index).getKey().charAt(i))) {
            id += conjresimps.get(i).getKey().charAt(i);
            ++i;
        }
        ++i;
        Character tip = conjresimps.get(index).getKey().charAt(i);
        filtrat.setVisible(true);
        filtrat.pack();
        filtrat.setLocationRelativeTo(frame);
        frame.setFocusable(false);
        listafiltrat.setListData(cp.MostraRelImp(sv, cp.TipusEquilvalent(tip),Integer.parseInt(id)));
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
        filtra = new JButton();
        resdet = new JDialog();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        res = new JList();
        button1 = new JButton();
        filtrat = new JDialog();
        label3 = new JLabel();
        scrollPane3 = new JScrollPane();
        listafiltrat = new JList();
        button2 = new JButton();
        parfil = new JDialog();
        label4 = new JLabel();
        threshold = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        nres = new JTextField();
        acceptar = new JButton();
        etiquetes = new JComboBox();
        label7 = new JLabel();

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
            info.addActionListener(e -> {
                try {
                    infoActionPerformed(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

            //---- button3 ----
            button3.setText("Creua Resultats");

            //---- filtra ----
            filtra.setText("Filtra");
            filtra.addActionListener(e -> filtraActionPerformed(e));

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
                        .addComponent(filtra)
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
                            .addComponent(filtra))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== resdet ========
        {
            Container resdetContentPane = resdet.getContentPane();

            //---- label2 ----
            label2.setText("Resultat de Relaci\u00f3 Important Detallat");

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
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            resdet.pack();
            resdet.setLocationRelativeTo(resdet.getOwner());
        }

        //======== filtrat ========
        {
            Container filtratContentPane = filtrat.getContentPane();

            //---- label3 ----
            label3.setText("Resultat de Relaci\u00f3 Important Filtrat");

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(listafiltrat);
            }

            //---- button2 ----
            button2.setText("OK");

            GroupLayout filtratContentPaneLayout = new GroupLayout(filtratContentPane);
            filtratContentPane.setLayout(filtratContentPaneLayout);
            filtratContentPaneLayout.setHorizontalGroup(
                filtratContentPaneLayout.createParallelGroup()
                    .addGroup(filtratContentPaneLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(filtratContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label3)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2))
                        .addContainerGap(35, Short.MAX_VALUE))
            );
            filtratContentPaneLayout.setVerticalGroup(
                filtratContentPaneLayout.createParallelGroup()
                    .addGroup(filtratContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            filtrat.pack();
            filtrat.setLocationRelativeTo(filtrat.getOwner());
        }

        //======== parfil ========
        {
            Container parfilContentPane = parfil.getContentPane();

            //---- label4 ----
            label4.setText("Par\u00e0metres de Filtrat");

            //---- label5 ----
            label5.setText("Threshold:");

            //---- label6 ----
            label6.setText("Nombre de resultats:*");

            //---- acceptar ----
            acceptar.setText("Acceptar");
            acceptar.addActionListener(e -> {
                try {
                    acceptarActionPerformed(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

            //---- label7 ----
            label7.setText("Etiqueta:*");

            GroupLayout parfilContentPaneLayout = new GroupLayout(parfilContentPane);
            parfilContentPane.setLayout(parfilContentPaneLayout);
            parfilContentPaneLayout.setHorizontalGroup(
                parfilContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, parfilContentPaneLayout.createSequentialGroup()
                        .addContainerGap(140, Short.MAX_VALUE)
                        .addGroup(parfilContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, parfilContentPaneLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(134, 134, 134))
                            .addGroup(GroupLayout.Alignment.TRAILING, parfilContentPaneLayout.createSequentialGroup()
                                .addComponent(acceptar)
                                .addGap(146, 146, 146))))
                    .addGroup(parfilContentPaneLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(parfilContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, parfilContentPaneLayout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(etiquetes, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
                            .addGroup(parfilContentPaneLayout.createSequentialGroup()
                                .addGroup(parfilContentPaneLayout.createParallelGroup()
                                    .addComponent(label5)
                                    .addComponent(label6))
                                .addGap(18, 18, 18)
                                .addGroup(parfilContentPaneLayout.createParallelGroup()
                                    .addComponent(nres, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(threshold, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(26, Short.MAX_VALUE))
            );
            parfilContentPaneLayout.setVerticalGroup(
                parfilContentPaneLayout.createParallelGroup()
                    .addGroup(parfilContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label4)
                        .addGap(34, 34, 34)
                        .addGroup(parfilContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(etiquetes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(parfilContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(threshold, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(parfilContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(nres, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(acceptar)
                        .addGap(16, 16, 16))
            );
            parfil.pack();
            parfil.setLocationRelativeTo(parfil.getOwner());
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
    private JButton filtra;
    private JDialog resdet;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList res;
    private JButton button1;
    private JDialog filtrat;
    private JLabel label3;
    private JScrollPane scrollPane3;
    private JList listafiltrat;
    private JButton button2;
    private JDialog parfil;
    private JLabel label4;
    private JTextField threshold;
    private JLabel label5;
    private JLabel label6;
    private JTextField nres;
    private JButton acceptar;
    private JComboBox etiquetes;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
