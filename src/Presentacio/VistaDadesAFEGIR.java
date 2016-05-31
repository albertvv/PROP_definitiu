package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesAFEGIR {

    private CtrlPresentacio cp;

    private String nom;
    private Integer id = null;
    private String tag = null;
    private String tipus;

    private VistaDADES vd;

    public VistaDadesAFEGIR(CtrlPresentacio cp) {
        this.cp = cp;
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        //this.cp = ctrlPresentacio;
        initComponents();
        frame1.setVisible(true);
        enrereButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                if (vd == null) vd = new VistaDADES(cp);
                vd.ferVisible();
            }
        });
        AFEGIRButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!textField1.getText().equals("")) {
                        nom = textField1.getText();
                        switch (comboBox1.getSelectedItem().toString()) {
                            case "Article":
                                tipus = "Articulo";
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
                        if (!textField2.getText().equals(""))
                            id = Integer.parseInt(textField2.getText());
                        else id = null;
                        if (!comboBox1.getSelectedItem().toString().equals("Terme") && !textField3.getText().equals(""))
                            tag = textField3.getText();
                        else tag = null;
                        cp.afegir_element(nom, id, tag, tipus);
                        JOptionPane.showMessageDialog(frame1,
                                "S'ha afegit una nova entitat '"+tipus+"' amb nom: "+nom,"",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame1,
                                "S'ha d'introduïr el nom de l'entitat","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exc) {
                    if (exc.getMessage().equals("ja existeix"))
                        JOptionPane.showMessageDialog(frame1,
                                "Ja existeix una entitat '"+tipus+"' amb la ID "+id,"Error",JOptionPane.ERROR_MESSAGE);
                    else if (exc.getMessage().equals("id negativa"))
                        JOptionPane.showMessageDialog(frame1,
                                "Les ID's no poden ser negatives!","Error",JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(frame1,
                                "ERROR"+exc.getClass(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void ferVisible() {
        frame1.setVisible(true);
    }

    private void AFEGIRButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
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
        textField1 = new JTextField();
        JLabel label1 = new JLabel();
        JPanel panel5 = new JPanel();
        comboBox1 = new JComboBox<>();
        JLabel label2 = new JLabel();
        JPanel panel6 = new JPanel();
        textField2 = new JTextField();
        JLabel label4 = new JLabel();
        JPanel panel7 = new JPanel();
        textField3 = new JTextField();
        JLabel label5 = new JLabel();
        JPanel panel8 = new JPanel();
        JLabel label6 = new JLabel();
        AFEGIRButton = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Afegir entitat");
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
                            .addComponent(enrereButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(274, 274, 274))
                    );
                }

                //======== panel3 ========
                {

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 44, Short.MAX_VALUE)
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 301, Short.MAX_VALUE)
                    );
                }

                //======== panel4 ========
                {

                    //---- label1 ----
                    label1.setText("Nom *");

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label1)
                                .addGap(10, 10, 10)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel5 ========
                {

                    //---- comboBox1 ----
                    comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Article",
                        "Autor",
                        "Congr\u00e9s",
                        "Terme"
                    }));

                    //---- label2 ----
                    label2.setText("Tipus d'entitat *");

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(label2)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label2)
                                .addGap(10, 10, 10)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel6 ========
                {

                    //---- label4 ----
                    label4.setText("ID");

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addComponent(label4)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label4)
                                .addGap(10, 10, 10)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel7 ========
                {

                    //---- label5 ----
                    label5.setText("Etiqueta");

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addComponent(label5)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label5)
                                .addGap(10, 10, 10)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel8 ========
                {

                    //---- label6 ----
                    label6.setText("Els camps marcats amb * s\u00f3n obligatoris");

                    //---- AFEGIRButton ----
                    AFEGIRButton.setText("AFEGIR");
                    AFEGIRButton.addActionListener(e -> AFEGIRButtonActionPerformed(e));

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                            .addComponent(label6)
                            .addComponent(AFEGIRButton, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                    );
                    panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                            .addGroup(panel8Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(label6)
                                .addGap(10, 10, 10)
                                .addComponent(AFEGIRButton))
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
                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
    private JTextField textField1;
    private JComboBox<String> comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton AFEGIRButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
