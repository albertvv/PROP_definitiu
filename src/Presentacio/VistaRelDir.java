/*
 * Created by JFormDesigner on Tue May 31 23:40:42 CEST 2016
 */

package Presentacio;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
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

    private void cercaActionPerformed(ActionEvent e) throws Exception {
        String t = (String)tipus.getSelectedItem();
        String nom = nome.getText();
        Integer id = obteid(nom,t);
        Vector<String> v = cp.CercaRelDirecta(id,t);
        resultat.setVisible(true);
        resultat.pack();
        resultat.setLocationRelativeTo(frame);
        frame.setFocusable(false);
        String s[] = v.toArray(new String[v.size()]);
        listres.setListData(s);
    }

    private Integer obteid(String nom, String tipus) throws Exception {
        Vector<Integer> v = cp.NomToID(nom,tipus);
        if(v.size() == 1) {return v.get(0);}
        else {
            String ids[] = cp.convert(v);
            String s = (String) JOptionPane.showInputDialog(frame, nom+" es refereix a múltiples entitats, escull quina",
                    "Multiples refèrencies", JOptionPane.QUESTION_MESSAGE, null, ids, ids[0]);
            return Integer.parseInt(s);
        }
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
        nome = new JTextField();
        cerca = new JButton();
        resultat = new JDialog();
        label4 = new JLabel();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        listres = new JList();
        button3 = new JButton();

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
            cerca.addActionListener(e -> {
                try {
                    cercaActionPerformed(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

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
                                    .addComponent(nome, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
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
                            .addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(cerca)
                        .addGap(30, 30, 30))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== resultat ========
        {
            Container resultatContentPane = resultat.getContentPane();

            //---- label4 ----
            label4.setText("Relacions Directes");

            //---- button2 ----
            button2.setText("Enrere");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(listres);
            }

            //---- button3 ----
            button3.setText("OK");

            GroupLayout resultatContentPaneLayout = new GroupLayout(resultatContentPane);
            resultatContentPane.setLayout(resultatContentPaneLayout);
            resultatContentPaneLayout.setHorizontalGroup(
                resultatContentPaneLayout.createParallelGroup()
                    .addGroup(resultatContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(resultatContentPaneLayout.createParallelGroup()
                            .addGroup(resultatContentPaneLayout.createSequentialGroup()
                                .addComponent(button2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(label4)
                                .addGap(144, 144, 144))
                            .addGroup(GroupLayout.Alignment.TRAILING, resultatContentPaneLayout.createSequentialGroup()
                                .addGap(0, 32, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))
                    .addGroup(resultatContentPaneLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(button3)
                        .addGap(0, 174, Short.MAX_VALUE))
            );
            resultatContentPaneLayout.setVerticalGroup(
                resultatContentPaneLayout.createParallelGroup()
                    .addGroup(resultatContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(resultatContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(button2))
                        .addGap(26, 26, 26)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button3)
                        .addContainerGap(8, Short.MAX_VALUE))
            );
            resultat.pack();
            resultat.setLocationRelativeTo(resultat.getOwner());
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
    private JTextField nome;
    private JButton cerca;
    private JDialog resultat;
    private JLabel label4;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList listres;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
