package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesSETid {

    private CtrlPresentacio cp;

    private String tipus;
    private String nom;
    private Integer id1;
    private Integer id2;

    public VistaDadesSETid() {
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
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
                        VistaDadesSETid vdsid = new VistaDadesSETid();
                    }});
    }

    private void button1ActionPerformed(ActionEvent e) {
        try {
            tipus = comboBox1.getSelectedItem().toString();
            if (!textField1.getText().equals("")) {
                id1 = Integer.parseInt(textField1.getText());
                if (!textField2.getText().equals("")) {
                    id2 = Integer.parseInt(textField2.getText());
                    //cp.setID(id1, id2, tipus);
                } else {
                    JOptionPane.showMessageDialog(frame1,
                            "Cal introduir la nova ID","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else if (!textField3.getText().equals("")) {
                //
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
        textField1 = new JTextField();
        textField2 = new JTextField();
        JLabel label4 = new JLabel();
        JLabel label3 = new JLabel();
        textField3 = new JTextField();
        label2 = new JLabel();
        button2 = new JButton();
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

                //---- label4 ----
                label4.setText("Antiga ID");

                //---- label3 ----
                label3.setText("Nova ID");

                //---- label2 ----
                label2.setText("Nom de l'entitat:");

                //---- button2 ----
                button2.setText("Seleccionar ID");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGroup(panel1Layout.createParallelGroup()
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label2))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addGap(97, 97, 97)
                                            .addComponent(label3)))
                                    .addGap(10, 10, 10)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(button2))
                                            .addGap(18, 18, 18)))
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4)
                                        .addComponent(label3)))
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                );
            }

            //---- button1 ----
            button1.setText("MODIFICAR");

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
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label2;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
