package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesSETnom {

    private CtrlPresentacio cp;

    private String nom1;
    private String nom2;
    private String tipus;
    private Integer id;

    public VistaDadesSETnom() {
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                VistaDadesSET vd = new VistaDadesSET();
            }
        });
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistaDadesSETnom vdsnom = new VistaDadesSETnom();
                    }});
    }

    private void MODIFICARButtonActionPerformed(ActionEvent e) {
        try {
            tipus = comboBox1.getSelectedItem().toString();
            if (!textField3.getText().equals("")) {
                id = Integer.parseInt(textField3.getText());
                if (!textField2.getText().equals("")) {
                    nom2 = textField2.getText();
                    //cp.setNom(id, nom2, tipus);
                }
                else {
                    JOptionPane.showMessageDialog(frame1,
                            "Cal saber el nou nom","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if (!textField1.equals("")) {
                ;
            } else {
                JOptionPane.showMessageDialog(frame1,
                        "Cal saber quina entitat es vol modificar","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(frame1,
                    "ERROR","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hola bebes
        frame1 = new Frame();
        panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        enrereButton = new JButton();
        JPanel vSpacer1 = new JPanel(null);
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        comboBox1 = new JComboBox<>();
        JLabel label1 = new JLabel();
        JPanel panel5 = new JPanel();
        MODIFICARButton = new JButton();
        JPanel panel6 = new JPanel();
        textField3 = new JTextField();
        JLabel label3 = new JLabel();
        JPanel panel7 = new JPanel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();

        //======== frame1 ========
        {
            frame1.setTitle("Modificar nom");

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
                            .addComponent(enrereButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(vSpacer1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(5, 5, 5)
                                .addComponent(vSpacer1, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))
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
                            .addGap(0, 375, Short.MAX_VALUE)
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
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(label1)
                                .addGap(30, 30, 30)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel5 ========
                {

                    //---- MODIFICARButton ----
                    MODIFICARButton.setText("MODIFICAR");
                    MODIFICARButton.addActionListener(e -> MODIFICARButtonActionPerformed(e));

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(MODIFICARButton, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(MODIFICARButton))
                    );
                }

                //======== panel6 ========
                {

                    //---- label3 ----
                    label3.setText("ID de l'entitat");

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addComponent(label3)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(label3)
                                .addGap(23, 23, 23)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel7 ========
                {

                    //---- label4 ----
                    label4.setText("Antic nom");

                    //---- label5 ----
                    label5.setText("Nou nom");

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(106, 106, 106)
                                .addComponent(label5))
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addComponent(label4)
                                    .addComponent(label5))
                                .addGap(20, 20, 20)
                                .addGroup(panel7Layout.createParallelGroup()
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                );
            }

            GroupLayout frame1Layout = new GroupLayout(frame1);
            frame1.setLayout(frame1Layout);
            frame1Layout.setHorizontalGroup(
                frame1Layout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            frame1Layout.setVerticalGroup(
                frame1Layout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hola bebes
    private Frame frame1;
    private JPanel panel1;
    private JButton enrereButton;
    private JComboBox<String> comboBox1;
    private JButton MODIFICARButton;
    private JTextField textField3;
    private JTextField textField1;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
