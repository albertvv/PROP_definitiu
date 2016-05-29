package Presentacio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * Created by marc on 19/5/16.
 */
public class VistaDadesSET {
    public VistaDadesSET() {
        initComponents();
        frame1.setVisible(true);
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater (
                new Runnable() {
                    public void run() {
                        VistaDadesSET vd = new VistaDadesSET();
                        vd.ferVisible();
                    }});
    }

    private void ferVisible() {
        frame1.setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDADES vd = new VistaDADES();
    }

    private void button2ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDadesSETid vd = new VistaDadesSETid();
    }

    private void button3ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDadesSETnom vd = new VistaDadesSETnom();
    }

    private void button4ActionPerformed(ActionEvent e) {
        frame1.setVisible(false);
        VistaDadesSETtag vd = new VistaDadesSETtag();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame1 = new JFrame();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("Editar entitat");
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new FormLayout(
                "4*(default, $lcgap), default",
                "5*(default, $lgap), default"));

            //---- button1 ----
            button1.setText("Enrere");
            button1.addActionListener(e -> button1ActionPerformed(e));
            frame1ContentPane.add(button1, CC.xy(3, 3));

            //---- button2 ----
            button2.setText("Modificar ID");
            button2.addActionListener(e -> button2ActionPerformed(e));
            frame1ContentPane.add(button2, CC.xy(7, 3));

            //---- button3 ----
            button3.setText("Modificar nom");
            button3.addActionListener(e -> button3ActionPerformed(e));
            frame1ContentPane.add(button3, CC.xy(7, 7));

            //---- button4 ----
            button4.setText("Modificar etiqueta");
            button4.addActionListener(e -> button4ActionPerformed(e));
            frame1ContentPane.add(button4, CC.xy(7, 11));
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
