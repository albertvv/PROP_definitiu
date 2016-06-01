/*
 * Created by JFormDesigner on Mon May 30 11:36:17 CEST 2016
 */

package Presentacio;

import java.awt.event.*;

import org.la4j.iterator.VectorIterator;
import org.la4j.vector.SparseVector;
import javafx.util.*;
import org.la4j.vector.sparse.CompressedVector;

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
        String etiqs[] = {"no","Database","Data Mining","AI","Information Retrieval"};
        for (int i = 0; i < etiqs.length; i++) {
            etiquetes.addItem(etiqs[i]);
        }
        etiquetes.setSelectedIndex(0);
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
        if(vrelimp==null)vrelimp = new VistaRelImportant(cp);
        vrelimp.ferVisible();
    }

    private void infoActionPerformed(ActionEvent e) {
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
            try {
                res.setListData(cp.MostraRelImp(conjresimps.get(index).getValue(),
                        cp.TipusEquilvalent(t), id));
            } catch (Exception exc) {
                ;
            }
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
        }
    }

    private void acceptarActionPerformed(ActionEvent e) {
        String etiq = (String)etiquetes.getSelectedItem();
        Double thres = 0.0;
        Integer nr = 0;
        String t = threshold.getText();
        if(!(nres.getText().length()==0)) {
            nr = Integer.parseInt(nres.getText())+1;
        }
        else nr=-1;
        if(!(threshold.getText().length() == 0)) {
            System.out.println("entrothres");
            thres = Double.parseDouble(threshold.getText());
        }
        try {
            SparseVector sv = cp.FiltraRelimportant(index, thres, nr, etiq);
            VectorIterator it = sv.nonZeroIterator();
            while(it.hasNext()) {
                Double rel = it.next();
                System.out.println(rel);
            }
            String id = new String();
            int i = 0;
            while (Character.isDigit(conjresimps.get(index).getKey().charAt(i))) {
                id += conjresimps.get(index).getKey().charAt(i);
                ++i;
            }
            ++i;
            Character tip = conjresimps.get(index).getKey().charAt(i);
            filtrat.setVisible(true);
            filtrat.pack();
            filtrat.setLocationRelativeTo(frame);
            frame.setFocusable(false);
            listafiltrat.setListData(cp.MostraRelImp(sv, cp.TipusEquilvalent(tip), Integer.parseInt(id)));
        } catch (Exception exc) {
            ;
        }
    }

    private void creuarActionPerformed(ActionEvent e) {
        int[] indexs = ultres.getSelectedIndices();
        if(indexs.length!=2){
            JOptionPane.showMessageDialog(frame, "Has de seleccionar 2 resultats per poder creuar-los","Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(indexs.length);
        System.out.println(indexs[0]);
        System.out.println(indexs[1]);
        Vector<Pair<Integer,Double>> rcreu = cp.CercaCreuada(indexs[0],indexs[1]);
        SparseVector sv = new CompressedVector(cp.maxid());
        for (int i = 0; i < rcreu.size(); i++) {
            sv.set(rcreu.get(i).getKey(),rcreu.get(i).getValue());
        }
        String id = new String();
        int i = 0;
        while(Character.isDigit(conjresimps.get(indexs[0]).getKey().charAt(i))) {
            id += conjresimps.get(i).getKey().charAt(i);
            ++i;
        }
        ++i;
        Character tip = conjresimps.get(indexs[0]).getKey().charAt(i);
        rescreuat.setVisible(true);
        rescreuat.pack();
        rescreuat.setLocationRelativeTo(frame);
        frame.setFocusable(false);
        try {
            listcreu.setListData(cp.MostraRelImp(sv, cp.TipusEquilvalent(tip), Integer.parseInt(id)));
        } catch (Exception exc) {
            ;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame = new JFrame();
        enrere = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        ultres = new JList();
        info = new JButton();
        creuar = new JButton();
        filtra = new JButton();
        resdet = new JDialog();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        res = new JList();
        filtrat = new JDialog();
        label3 = new JLabel();
        scrollPane3 = new JScrollPane();
        listafiltrat = new JList();
        parfil = new JDialog();
        label4 = new JLabel();
        threshold = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        nres = new JTextField();
        acceptar = new JButton();
        etiquetes = new JComboBox();
        label7 = new JLabel();
        rescreuat = new JDialog();
        label8 = new JLabel();
        scrollPane4 = new JScrollPane();
        listcreu = new JList();

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

            //---- creuar ----
            creuar.setText("Creua Resultats");
            creuar.addActionListener(e -> creuarActionPerformed(e));

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
                        .addComponent(creuar)
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
                            .addComponent(creuar)
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

            GroupLayout resdetContentPaneLayout = new GroupLayout(resdetContentPane);
            resdetContentPane.setLayout(resdetContentPaneLayout);
            resdetContentPaneLayout.setHorizontalGroup(
                resdetContentPaneLayout.createParallelGroup()
                    .addGroup(resdetContentPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(resdetContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label2)
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
            );
            resdetContentPaneLayout.setVerticalGroup(
                resdetContentPaneLayout.createParallelGroup()
                    .addGroup(resdetContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
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

            GroupLayout filtratContentPaneLayout = new GroupLayout(filtratContentPane);
            filtratContentPane.setLayout(filtratContentPaneLayout);
            filtratContentPaneLayout.setHorizontalGroup(
                filtratContentPaneLayout.createParallelGroup()
                    .addGroup(filtratContentPaneLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(filtratContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label3)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))
            );
            filtratContentPaneLayout.setVerticalGroup(
                filtratContentPaneLayout.createParallelGroup()
                    .addGroup(filtratContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
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
            acceptar.addActionListener(e -> acceptarActionPerformed(e));

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

        //======== rescreuat ========
        {
            Container rescreuatContentPane = rescreuat.getContentPane();

            //---- label8 ----
            label8.setText("Resultats de Relacions Importants Creuats");

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(listcreu);
            }

            GroupLayout rescreuatContentPaneLayout = new GroupLayout(rescreuatContentPane);
            rescreuatContentPane.setLayout(rescreuatContentPaneLayout);
            rescreuatContentPaneLayout.setHorizontalGroup(
                rescreuatContentPaneLayout.createParallelGroup()
                    .addGroup(rescreuatContentPaneLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(rescreuatContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(label8)
                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(39, Short.MAX_VALUE))
            );
            rescreuatContentPaneLayout.setVerticalGroup(
                rescreuatContentPaneLayout.createParallelGroup()
                    .addGroup(rescreuatContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
            );
            rescreuat.pack();
            rescreuat.setLocationRelativeTo(rescreuat.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame;
    private JButton enrere;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList ultres;
    private JButton info;
    private JButton creuar;
    private JButton filtra;
    private JDialog resdet;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList res;
    private JDialog filtrat;
    private JLabel label3;
    private JScrollPane scrollPane3;
    private JList listafiltrat;
    private JDialog parfil;
    private JLabel label4;
    private JTextField threshold;
    private JLabel label5;
    private JLabel label6;
    private JTextField nres;
    private JButton acceptar;
    private JComboBox etiquetes;
    private JLabel label7;
    private JDialog rescreuat;
    private JLabel label8;
    private JScrollPane scrollPane4;
    private JList listcreu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
