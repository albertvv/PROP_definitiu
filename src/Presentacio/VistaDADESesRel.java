package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marc on 16/5/16.
 */
public class VistaDADESesRel {

    private CtrlPresentacio cp;

    private String tipus;
    private String nom1;
    private String nom2;
    private Integer id1;
    private Integer id2;

    public VistaDADESesRel() {
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                VistaDADES vd = new VistaDADES();
            }
        });
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistaDADESesRel vder = new VistaDADESesRel();
                    }});
    }

    private void ESBORRARRELACIÓButtonActionPerformed(ActionEvent e) {
        try {
            if (!textField4.getText().equals("") && !textField3.getText().equals("")) {
                id1 = Integer.parseInt(textField4.getText());
                id2 = Integer.parseInt(textField3.getText());
                tipus = comboBox1.getSelectedItem().toString();
                cp.esborrar_relacio_graf(id1, id2, tipus);
            } else {
                JOptionPane.showMessageDialog(frame1,
                        "Es requereixen les ID de les dues entitats","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(frame1,
                    "ERROR","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hola bebes
        frame1 = new JFrame();
        panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        enrereButton = new JButton();
        JPanel vSpacer1 = new JPanel(null);
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        comboBox1 = new JComboBox<>();
        JLabel label1 = new JLabel();
        JPanel panel5 = new JPanel();
        ESBORRARRELACIÓButton = new JButton();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        textField4 = new JTextField();
        JLabel label3 = new JLabel();
        JPanel panel8 = new JPanel();
        textField3 = new JTextField();
        JLabel label4 = new JLabel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        textField1 = new JTextField();
        JLabel label5 = new JLabel();
        JPanel panel11 = new JPanel();
        textField2 = new JTextField();
        JLabel label6 = new JLabel();

        //======== frame1 ========
        {
            frame1.setTitle("Esborrar relaci\u00f3");
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
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(vSpacer1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(5, 5, 5)
                                .addComponent(vSpacer1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
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

                    //---- ESBORRARRELACIÓButton ----
                    ESBORRARRELACIÓButton.setText("ESBORRAR RELACI\u00d3");
                    ESBORRARRELACIÓButton.addActionListener(e -> ESBORRARRELACIÓButtonActionPerformed(e));

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(ESBORRARRELACIÓButton, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(ESBORRARRELACIÓButton)
                    );
                }

                //======== panel6 ========
                {

                    //======== panel7 ========
                    {

                        //---- label3 ----
                        label3.setText("ID [1]");

                        GroupLayout panel7Layout = new GroupLayout(panel7);
                        panel7.setLayout(panel7Layout);
                        panel7Layout.setHorizontalGroup(
                            panel7Layout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        );
                        panel7Layout.setVerticalGroup(
                            panel7Layout.createParallelGroup()
                                .addGroup(panel7Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(label3)
                                    .addGap(7, 7, 7)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        );
                    }

                    //======== panel8 ========
                    {

                        //---- label4 ----
                        label4.setText("ID [2]");

                        GroupLayout panel8Layout = new GroupLayout(panel8);
                        panel8.setLayout(panel8Layout);
                        panel8Layout.setHorizontalGroup(
                            panel8Layout.createParallelGroup()
                                .addComponent(label4)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        );
                        panel8Layout.setVerticalGroup(
                            panel8Layout.createParallelGroup()
                                .addGroup(panel8Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(label4)
                                    .addGap(7, 7, 7)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        );
                    }

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                );
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hola bebes
    private JFrame frame1;
    private JPanel panel1;
    private JButton enrereButton;
    private JComboBox<String> comboBox1;
    private JButton ESBORRARRELACIÓButton;
    private JTextField textField4;
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
