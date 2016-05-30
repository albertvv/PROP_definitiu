package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesSETtag {

    private CtrlPresentacio cp;

    private String nom;
    private String tipus;
    private Integer id;
    private String tag;

    public VistaDadesSETtag() {
        initComponents();
        frame1.setVisible(true);
        button1.addActionListener(new ActionListener() {
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
                        VistaDadesSETtag vdstag = new VistaDadesSETtag();
                    }});
    }

    private void MODIFICARButton2ActionPerformed(ActionEvent e) {
        try {
            tipus = comboBox2.getSelectedItem().toString();
            if (!textField1.getText().equals("")) {
                id = Integer.parseInt(textField1.getText());
                if (!textField5.getText().equals("")) {
                    tag = textField5.getText();
                    //cp.setTag(id, tag, tipus);
                } else {
                    JOptionPane.showMessageDialog(frame1,
                            "Cal introduir la nova etiqueta","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame1,
                        "Cal l'entitat a modificar","Error",JOptionPane.ERROR_MESSAGE);
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
        button1 = new JButton();
        JLabel label2 = new JLabel();
        comboBox2 = new JComboBox<>();
        label1 = new JLabel();
        textField6 = new JTextField();
        button2 = new JButton();
        JLabel label8 = new JLabel();
        textField1 = new JTextField();
        JLabel label6 = new JLabel();
        textField5 = new JTextField();
        MODIFICARButton2 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Modificar etiqueta");
            Container frame1ContentPane = frame1.getContentPane();

            //---- button1 ----
            button1.setText("Enrere");

            //---- label2 ----
            label2.setText("Tipus d'entitat");

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "Article",
                "Autor",
                "Congr\u00e9s"
            }));

            //---- label1 ----
            label1.setText("Nom de l'entitat:");

            //---- button2 ----
            button2.setText("Seleccionar ID");

            //---- label8 ----
            label8.setText("ID de l'entitat");

            //---- label6 ----
            label6.setText("Nova etiqueta");

            //---- MODIFICARButton2 ----
            MODIFICARButton2.setText("MODIFICAR");
            MODIFICARButton2.addActionListener(e -> {
			MODIFICARButton2ActionPerformed(e);
			MODIFICARButton2ActionPerformed(e);
		});

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button1)
                        .addGap(59, 59, 59)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(label8, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(MODIFICARButton2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(button1)
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(label2)))
                        .addGap(5, 5, 5)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(label1)
                        .addGap(5, 5, 5)
                        .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(button2)
                        .addGap(5, 5, 5)
                        .addComponent(label8)
                        .addGap(5, 5, 5)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(label6)
                        .addGap(5, 5, 5)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(MODIFICARButton2))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hola bebes
    private JFrame frame1;
    private JButton button1;
    private JComboBox<String> comboBox2;
    private JLabel label1;
    private JTextField textField6;
    private JButton button2;
    private JTextField textField1;
    private JTextField textField5;
    private JButton MODIFICARButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
