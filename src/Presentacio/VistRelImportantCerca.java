package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


public class VistRelImportantCerca {

    private JFrame frameVista = new JFrame("VistaRelImportant");

    public VistRelImportantCerca() {
        initComponents();
        frame1.setVisible(true);
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistRelImportantCerca vr = new VistRelImportantCerca();
                    }});
    }

    private void enrereButtonActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        //----
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame1 = new JFrame();
        panel = new JPanel();
        JPanel panel1 = new JPanel();
        enrereButton = new JButton();
        JPanel panel2 = new JPanel();
        textField1 = new JTextField();
        JLabel label2 = new JLabel();
        JPanel panel3 = new JPanel();
        JLabel label3 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();
        JPanel vSpacer3 = new JPanel(null);
        JPanel panel4 = new JPanel();

        //======== frame1 ========
        {
            frame1.setTitle("Cerca relacions importants");
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new FormLayout(
                "default, $lcgap, default",
                "2*(default, $lgap), default"));

            //======== panel ========
            {
                panel.setBorder(new TitledBorder(""));

                // JFormDesigner evaluation mark
                panel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel.getBorder())); panel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //======== panel1 ========
                {

                    //---- enrereButton ----
                    enrereButton.setText("Enrere");
                    enrereButton.addActionListener(e -> enrereButtonActionPerformed(e));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addComponent(enrereButton)
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(157, 157, 157))
                    );
                }

                //======== panel2 ========
                {

                    //---- label2 ----
                    label2.setText("Path:");

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addComponent(label2)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(label2)
                                .addGap(7, 7, 7)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel3 ========
                {

                    //---- label3 ----
                    label3.setText("Label");

                    //---- button2 ----
                    button2.setText("CERCA");

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addComponent(label3)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(vSpacer3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(label3)
                                .addGap(7, 7, 7)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(vSpacer3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(button2))
                    );
                }

                //======== panel4 ========
                {

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGap(0, 71, Short.MAX_VALUE)
                    );
                }

                GroupLayout panelLayout = new GroupLayout(panel);
                panel.setLayout(panelLayout);
                panelLayout.setHorizontalGroup(
                    panelLayout.createParallelGroup()
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(panelLayout.createParallelGroup()
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                panelLayout.setVerticalGroup(
                    panelLayout.createParallelGroup()
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panelLayout.createParallelGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelLayout.createSequentialGroup()
                                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                );
            }
            frame1ContentPane.add(panel, CC.xy(1, 1));
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame1;
    private JPanel panel;
    private JButton enrereButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
