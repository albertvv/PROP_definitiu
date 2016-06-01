package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by marc on 16/5/16
 */
public class VistaDADESafRel {

    private CtrlPresentacio cp;

    private VistaDADES vd;

    private Integer id1;
    private Integer id2;
    private String nom1;
    private String nom2;
    private String rel;
    private String tipus1;
    private String tipus2;

    public VistaDADESafRel(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                if (vd == null) vd = new VistaDADES(cp);
                vd.ferVisible();
            }
        });
        AFEGIRRELACIÓButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!textField1.getText().equals("") && !textField2.getText().equals("")) {
                        afegir();
                    } else {
                        JOptionPane.showMessageDialog(frame1,
                                "Cal introduïr el nom de les dues entitats","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exc) {
                    if (exc.getMessage().equals("id negativa")) {
                        JOptionPane.showMessageDialog(frame1,
                                "La ID no pot ser negativa!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (exc.getMessage().equals("no existeix 1")) {
                        JOptionPane.showMessageDialog(frame1,
                                "No existeix cap '" + tipus1 + "' anomenat " + nom1, "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (exc.getMessage().equals("no existeix 2")) {
                        JOptionPane.showMessageDialog(frame1,
                                "No existeix cap '" + tipus2 + "' anomenat " + nom2, "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (exc.getMessage().equals("ja existeix")) {
                        JOptionPane.showMessageDialog(frame1,
                                "La relació entre aquestes dues entitats ja existeix", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame1,
                                "No s'ha realitzat cap canvi", "Informació", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    public void ferVisible() {
        frame1.setVisible(true);
    }

    private void afegir() throws Exception {
        rel = comboBox1.getSelectedItem().toString().charAt(0)+""+comboBox1.getSelectedItem().toString().charAt(1);

        nom1 = textField1.getText();
        switch (rel.charAt(0)) {
            case 'A':
                tipus1 = "Autor";
                break;
            case 'P':
                tipus1 = "Paper";
                break;
            case 'C':
                tipus1 = "Conferencia";
                break;
            case 'T':
                tipus1 = "Termino";
                break;
        }
        if ((id1 = NomtoID(nom1, tipus1)) == null) throw new Exception("no existeix 1");

        nom2 = textField2.getText();
        switch (rel.charAt(1)) {
            case 'A':
                tipus2 = "Autor";
                break;
            case 'P':
                tipus2 = "Paper";
                break;
            case 'C':
                tipus2 = "Conferencia";
                break;
            case 'T':
                tipus2 = "Termino";
                break;
        }
        if ((id2 = NomtoID(nom2, tipus2)) == null) throw new Exception("no existeix 2");

        cp.afegir_relacio_graf(id1, id2, rel);

        JOptionPane.showMessageDialog(frame1,
                "La relació s'ha afegit");
    }

    private String showOptDialog(String[] ids,String nom) {
        String f = (String) JOptionPane.showInputDialog(frame1,
                nom+" es refereix a múltiples entitats, escull quina",
                "Multiples refèrencies",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ids,
                ids[0]);
        return f;
    }

    private Integer NomtoID(String strings, String tipus) throws Exception {
        Integer v;

        Vector<Integer> w = cp.NomToID(strings, tipus);
        System.out.println(w);
        if (w.size()>1) v = ((Integer.parseInt(showOptDialog(cp.convert(w), strings))));
        else if (w.size() == 0) v = null;
        else v = w.get(0);

        return v;
    }

    private void AFEGIRRELACIÓButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame1 = new Frame();
        panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        enrereButton = new JButton();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        comboBox1 = new JComboBox<>();
        JLabel label1 = new JLabel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        textField1 = new JTextField();
        JLabel label5 = new JLabel();
        JPanel panel11 = new JPanel();
        textField2 = new JTextField();
        JLabel label6 = new JLabel();
        AFEGIRRELACIÓButton = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Afegir relaci\u00f3 directa");

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //======== panel2 ========
                {

                    //---- enrereButton ----
                    enrereButton.setText("Enrere");

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addComponent(enrereButton)
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(168, 168, 168))
                    );
                }

                //======== panel3 ========
                {

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 195, Short.MAX_VALUE)
                    );
                }

                //======== panel4 ========
                {

                    //---- comboBox1 ----
                    comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                        "AP (Autor-Paper)",
                        "PA (Paper-Autor)",
                        "CP (Confer\u00e8ncia-Paper)",
                        "PC (Paper-Confer\u00e8ncia)",
                        "TP (Terme-Paper)",
                        "PT (Paper-Terme)"
                    }));

                    //---- label1 ----
                    label1.setText("Tipus de relaci\u00f3:");

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(label1)
                                .addGap(7, 7, 7)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel5 ========
                {

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                }

                //======== panel6 ========
                {

                    //======== panel7 ========
                    {

                        GroupLayout panel7Layout = new GroupLayout(panel7);
                        panel7.setLayout(panel7Layout);
                        panel7Layout.setHorizontalGroup(
                            panel7Layout.createParallelGroup()
                                .addGap(0, 34, Short.MAX_VALUE)
                        );
                        panel7Layout.setVerticalGroup(
                            panel7Layout.createParallelGroup()
                                .addGap(0, 25, Short.MAX_VALUE)
                        );
                    }

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    );
                }

                //======== panel9 ========
                {

                    //======== panel10 ========
                    {

                        //---- label5 ----
                        label5.setText("Nom [1]");

                        GroupLayout panel10Layout = new GroupLayout(panel10);
                        panel10.setLayout(panel10Layout);
                        panel10Layout.setHorizontalGroup(
                            panel10Layout.createParallelGroup()
                                .addComponent(label5)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        );
                        panel10Layout.setVerticalGroup(
                            panel10Layout.createParallelGroup()
                                .addGroup(panel10Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(label5)
                                    .addGap(7, 7, 7)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        );
                    }

                    //======== panel11 ========
                    {

                        //---- label6 ----
                        label6.setText("Nom [2]");

                        GroupLayout panel11Layout = new GroupLayout(panel11);
                        panel11.setLayout(panel11Layout);
                        panel11Layout.setHorizontalGroup(
                            panel11Layout.createParallelGroup()
                                .addComponent(label6)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        );
                        panel11Layout.setVerticalGroup(
                            panel11Layout.createParallelGroup()
                                .addGroup(panel11Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(label6)
                                    .addGap(7, 7, 7)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        );
                    }

                    GroupLayout panel9Layout = new GroupLayout(panel9);
                    panel9.setLayout(panel9Layout);
                    panel9Layout.setHorizontalGroup(
                        panel9Layout.createParallelGroup()
                            .addGroup(panel9Layout.createSequentialGroup()
                                .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                    panel9Layout.setVerticalGroup(
                        panel9Layout.createParallelGroup()
                            .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    );
                }

                //---- AFEGIRRELACIÓButton ----
                AFEGIRRELACIÓButton.setText("AFEGIR RELACI\u00d3");
                AFEGIRRELACIÓButton.addActionListener(e -> AFEGIRRELACIÓButtonActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                    .addGap(228, 228, 228)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(AFEGIRRELACIÓButton, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(AFEGIRRELACIÓButton, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                );
            }

            GroupLayout frame1Layout = new GroupLayout(frame1);
            frame1.setLayout(frame1Layout);
            frame1Layout.setHorizontalGroup(
                frame1Layout.createParallelGroup()
                    .addGroup(frame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame1Layout.setVerticalGroup(
                frame1Layout.createParallelGroup()
                    .addGroup(frame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private Frame frame1;
    private JPanel panel1;
    private JButton enrereButton;
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton AFEGIRRELACIÓButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
