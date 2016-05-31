package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by marc on 15/5/16.
 */
public class VistaDadesSETtag {

    private CtrlPresentacio cp;

    private String nom;
    private String tipus;
    private Integer id;
    private String tag;

    public VistaDadesSETtag(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
        frame1.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                VistaDadesSET vd = new VistaDadesSET(cp);
            }
        });
    }

    public void ferVisible() {
        frame1.setVisible(true);
    }

    private void MODIFICARButton2ActionPerformed(ActionEvent e) {
        try {
            if (!textField6.getText().equals("") && !textField5.getText().equals("")) {
                setTAG();
            } else {
                JOptionPane.showMessageDialog(frame1,
                        "Cal l'entitat a modificar i la nova etiqueta","Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(frame1,
                    "ERROR","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setTAG() throws Exception {
        tipus = comboBox2.getSelectedItem().toString();
        nom = textField6.getText();
        id = NomtoID(nom, tipus);
        tag = textField5.getText();
        //cp.setTag(id, tag, tipus);
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
        button1 = new JButton();
        JLabel label2 = new JLabel();
        comboBox2 = new JComboBox<>();
        label1 = new JLabel();
        textField6 = new JTextField();
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
                        .addGap(55, 55, 55)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBox2, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(textField6, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(MODIFICARButton2, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addGap(69, 69, 69))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                                .addComponent(button1)
                                .addGap(167, 167, 167))
                            .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(MODIFICARButton2)
                        .addGap(19, 19, 19))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame1;
    private JButton button1;
    private JComboBox<String> comboBox2;
    private JLabel label1;
    private JTextField textField6;
    private JTextField textField5;
    private JButton MODIFICARButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
