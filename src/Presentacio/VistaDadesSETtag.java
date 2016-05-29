package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

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
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
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
            frame1ContentPane.setLayout(new FormLayout(
                "4*(default, $lcgap), 121dlu, 6*($lcgap, default)",
                "13*(default, $lgap), default"));

            //---- button1 ----
            button1.setText("Enrere");
            frame1ContentPane.add(button1, CC.xy(3, 3));

            //---- label2 ----
            label2.setText("Tipus d'entitat");
            frame1ContentPane.add(label2, CC.xy(9, 3));

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "Article",
                "Autor",
                "Congr\u00e9s"
            }));
            frame1ContentPane.add(comboBox2, CC.xy(9, 5));

            //---- label1 ----
            label1.setText("Nom de l'entitat:");
            frame1ContentPane.add(label1, CC.xy(9, 7));
            frame1ContentPane.add(textField6, CC.xy(9, 9));

            //---- button2 ----
            button2.setText("Seleccionar ID");
            frame1ContentPane.add(button2, CC.xy(9, 11));

            //---- label8 ----
            label8.setText("ID de l'entitat");
            frame1ContentPane.add(label8, CC.xy(9, 13));
            frame1ContentPane.add(textField1, CC.xy(9, 15));

            //---- label6 ----
            label6.setText("Nova etiqueta");
            frame1ContentPane.add(label6, CC.xy(9, 17));
            frame1ContentPane.add(textField5, CC.xy(9, 19));

            //---- MODIFICARButton2 ----
            MODIFICARButton2.setText("MODIFICAR");
            MODIFICARButton2.addActionListener(e -> {
			MODIFICARButton2ActionPerformed(e);
			MODIFICARButton2ActionPerformed(e);
		});
            frame1ContentPane.add(MODIFICARButton2, CC.xy(9, 21));
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
    private JButton button2;
    private JTextField textField1;
    private JTextField textField5;
    private JButton MODIFICARButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
