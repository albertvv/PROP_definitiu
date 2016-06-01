package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesSETid {

    private CtrlPresentacio cp;

    private VistaDadesSET vs;

    private String tipus;
    private String nom;
    private Integer idOld;
    private Integer idNew;

    public VistaDadesSETid(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                if (vs == null) vs = new VistaDadesSET(cp);
                vs.ferVisible();
            }
        });
    }

    public void ferVisible() {
        frame1.setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        try {
            tipus = comboBox1.getSelectedItem().toString();
            if (!textField3.getText().equals("") && !textField2.getText().equals("")) {
                if (Integer.parseInt(textField2.getText()) < 0) throw new Exception("id negativa");
                setID();
            } else {
                JOptionPane.showMessageDialog(frame1,
                        "Cal saber quina entitat es vol modificar i la nova ID","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exc) {
            if (exc.getMessage().equals("id negativa")) {
                JOptionPane.showMessageDialog(frame1,
                        "Les IDs no poden ser negatives", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (exc.getMessage().equals("ja existeix")) {
                JOptionPane.showMessageDialog(frame1,
                        "No es pot dur a terme el canvi perquè ja existeix una entitat '"
                                + tipus + "' amb ID " + idNew, "Error", JOptionPane.ERROR_MESSAGE);
            } else if (exc.getMessage().equals("no existeix")) {
                JOptionPane.showMessageDialog(frame1,
                        "No existeix cap '" + tipus + "' anomenat " + nom, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame1,
                        "No s'ha realitzat cap canvi", "Informació", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void setID() throws Exception {
        switch (comboBox1.getSelectedItem().toString()) {
            case "Article":
                tipus = "Paper";
                break;
            case "Autor":
                tipus = "Autor";
                break;
            case "Congrés":
                tipus = "Conferencia";
                break;
            case "Terme":
                tipus = "Termino";
                break;
        }
        nom = textField3.getText();
        if ((idOld = NomtoID(nom, tipus)) == null) throw new Exception("no existeix");
        idNew = Integer.parseInt(textField2.getText());
        cp.setId(idOld, idNew, tipus);
        JOptionPane.showMessageDialog(frame1,
                "S'ha canviat la ID","",JOptionPane.INFORMATION_MESSAGE);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame1 = new JFrame();
        panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        enrereButton = new JButton();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        comboBox1 = new JComboBox<>();
        JLabel label1 = new JLabel();
        JPanel panel6 = new JPanel();
        textField2 = new JTextField();
        JLabel label3 = new JLabel();
        textField3 = new JTextField();
        label2 = new JLabel();
        button1 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Modificar ID");
            Container frame1ContentPane = frame1.getContentPane();

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
                            .addComponent(enrereButton)
                    );
                }

                //======== panel3 ========
                {

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 20, Short.MAX_VALUE)
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 127, Short.MAX_VALUE)
                    );
                }

                //======== panel4 ========
                {

                    //---- comboBox1 ----
                    comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Article",
                        "Autor",
                        "Congr\u00e9s",
                        "Terme"
                    }));

                    //---- label1 ----
                    label1.setText("Tipus d'entitat");

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

                //======== panel6 ========
                {

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGap(0, 313, Short.MAX_VALUE)
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGap(0, 51, Short.MAX_VALUE)
                    );
                }

                //---- label3 ----
                label3.setText("Nova ID");

                //---- label2 ----
                label2.setText("Nom de l'entitat:");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label3)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(label2)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(10, 10, 10)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(90, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label3)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(71, Short.MAX_VALUE))))
                );
            }

            //---- button1 ----
            button1.setText("MODIFICAR");
            button1.addActionListener(e -> button1ActionPerformed(e));

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button1)
                        .addContainerGap())
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame1;
    private JPanel panel1;
    private JButton enrereButton;
    private JComboBox<String> comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
