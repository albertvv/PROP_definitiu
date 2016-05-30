package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesESBORRAR {

    private CtrlPresentacio cp;

    private String tipus;
    private String nom;
    private Integer id;

    public VistaDadesESBORRAR() {
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                VistaDADES vd = new VistaDADES();
            }
        });
        /*ESBORRARButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!textField2.getText().equals("")) {
                        tipus = comboBox1.getSelectedItem().toString();
                        id = Integer.parseInt(textField2.getText());
                        cp.esborrar_element(null, id, tipus);
                    }
                    else {
                        JOptionPane.showMessageDialog(frame1,
                                "Es requereix la ID de l'element a esborrar","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(frame1,
                            "ERROR","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });*/
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistaDadesESBORRAR vde = new VistaDadesESBORRAR();
                    }});
    }

    private void ESBORRARButtonActionPerformed(ActionEvent e) {
        try {
            if (!textField2.getText().equals("")) {
                tipus = comboBox1.getSelectedItem().toString();
                id = Integer.parseInt(textField2.getText());
                cp.esborrar_element(null, id, tipus);
            }
            else {
                JOptionPane.showMessageDialog(frame1,
                        "Es requereix la ID de l'element a esborrar","Error",JOptionPane.ERROR_MESSAGE);
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
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        comboBox1 = new JComboBox<>();
        JLabel label1 = new JLabel();
        JPanel panel5 = new JPanel();
        ESBORRARButton = new JButton();
        JPanel panel6 = new JPanel();
        textField1 = new JTextField();
        JLabel label3 = new JLabel();
        button1 = new JButton();
        JPanel panel7 = new JPanel();
        textField2 = new JTextField();
        JLabel label4 = new JLabel();

        //======== frame1 ========
        {
            frame1.setTitle("Esborrar entitat");
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
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(243, 243, 243))
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
                            .addGap(0, 270, Short.MAX_VALUE)
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
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
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

                    //---- ESBORRARButton ----
                    ESBORRARButton.setText("ESBORRAR");
                    ESBORRARButton.addActionListener(e -> ESBORRARButtonActionPerformed(e));

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(ESBORRARButton, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(ESBORRARButton)
                    );
                }

                //======== panel6 ========
                {

                    //---- label3 ----
                    label3.setText("Nom");

                    //---- button1 ----
                    button1.setText("Seleccionar ID amb el nom introdu\u00eft");

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGroup(panel6Layout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(label3)
                                .addGap(7, 7, 7)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(button1))
                    );
                }

                //======== panel7 ========
                {

                    //---- label4 ----
                    label4.setText("ID");

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addComponent(label4)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(label4)
                                .addGap(7, 7, 7)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(32, Short.MAX_VALUE))
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
                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
                                    .addGap(18, 18, 18)
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
    private JButton ESBORRARButton;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
