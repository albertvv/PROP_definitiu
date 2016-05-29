/*
 * Created by JFormDesigner on Sun May 29 19:51:04 CEST 2016
 */

package Presentacio;

import com.sun.awt.AWTUtilities;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Ãlvar HernÃ¡ndez
 */
public class VistaCercaImportant {
    private CtrlPresentacio cp;
    private VistaRelImportant vrelimp;
    private String path;

    public VistaCercaImportant(CtrlPresentacio ctrl) {
        initComponents();
        this.cp = ctrl;
        vrelimp = new VistaRelImportant(cp);
    }

    public void ferVisible() {
        frame.setVisible(true);
    }

    private void enrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        vrelimp.ferVisible();
    }

    private Integer obteid(String nom) {
        Vector<Integer> v = cp.NomToID(nom,cp.TipusEquilvalent(path.charAt(0)));
        if(v.size() == 1) return v.get(0);
        else {
            String ids[] = cp.convert(v);
            String s = (String) JOptionPane.showInputDialog(frame, nom+" es refereix a múltiples entitats, escull quina",
                    "Multiples refèrencies", JOptionPane.QUESTION_MESSAGE, null, ids, ids[0]);
            return Integer.parseInt(s);
        }
    }

    private void IniciaCerca(Integer i) throws Exception {
        AWTUtilities.setWindowOpaque(frame2, false);
        frame2.setVisible(true);
        frame2.setEnabled(true);
        class Computa implements Runnable{

            @Override
            public void run() {
                enrere.setEnabled(false);
                cerca.setEnabled(false);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                }
                System.out.println("acabat");
                /*Vector<Vector<Integer>> c = cp.Clustering(path, Integer.parseInt(numgrupstext.getText()),vi, Integer.parseInt(iteracionstext.getText()));
                jDialog1.setVisible(true);
                jDialog1.pack();
                jDialog1.setLocationRelativeTo(frame);
                jPanel1.setFocusable(false);
                jList1.setListData(cp.MostraClustering(c,cp.TipusEquilvalent(path.charAt(0))));*/
                frame2.setVisible(false);
                frame2.setEnabled(false);
                cerca.setEnabled(true);
                enrere.setEnabled(true);

            }
        }
        Computa c = new Computa();
        Thread t = new Thread(c);
        t.start();
    }

    private void cercaActionPerformed(ActionEvent e) {
        try {
            if(cp.exist_relacio(tiprel.getText())) {
                path = cp.getPath(tiprel.getText());
                Integer id = obteid(priment.getText());
                IniciaCerca(id);
            }
            else JOptionPane.showMessageDialog(frame,
                    "Aquest tipus de relació no existeix", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e1) {
            JOptionPane.showMessageDialog(frame, "aquí hi ha algún problema","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void frame2ComponentMoved(ComponentEvent e) {
        frame2.setLocationRelativeTo(frame);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        label1 = new JLabel();
        enrere = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        tiprel = new JTextField();
        priment = new JTextField();
        cerca = new JButton();
        frame2 = new JWindow();
        label4 = new JLabel();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //---- label1 ----
            label1.setText("Cerca Relaci\u00f3 Important");

            //---- enrere ----
            enrere.setText("Enrere");
            enrere.addActionListener(e -> enrereActionPerformed(e));

            //---- label2 ----
            label2.setText("Tipus de relaci\u00f3:");

            //---- label3 ----
            label3.setText("Primera entitat:");

            //---- cerca ----
            cerca.setText("Cerca");
            cerca.addActionListener(e -> cercaActionPerformed(e));

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addComponent(enrere)
                                .addGap(56, 56, 56)
                                .addComponent(label1))
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGroup(frameContentPaneLayout.createParallelGroup()
                                    .addComponent(label2)
                                    .addComponent(label3))
                                .addGap(18, 18, 18)
                                .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tiprel, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(priment, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap(287, Short.MAX_VALUE)
                        .addComponent(cerca)
                        .addGap(14, 14, 14))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addComponent(enrere)
                            .addComponent(label1))
                        .addGap(18, 18, 18)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(tiprel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(priment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(cerca)
                        .addGap(17, 17, 17))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== frame2 ========
        {
            frame2.setOpacity(0.5F);
            frame2.setFocusable(false);
            frame2.setFocusableWindowState(false);
            frame2.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            frame2.setAlwaysOnTop(true);
            frame2.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentMoved(ComponentEvent e) {
                    frame2ComponentMoved(e);
                }
            });
            Container frame2ContentPane = frame2.getContentPane();

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/Presentacio/ajax-loader.gif")));
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setFocusable(false);
            label4.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            GroupLayout frame2ContentPaneLayout = new GroupLayout(frame2ContentPane);
            frame2ContentPane.setLayout(frame2ContentPaneLayout);
            frame2ContentPaneLayout.setHorizontalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
            );
            frame2ContentPaneLayout.setVerticalGroup(
                frame2ContentPaneLayout.createParallelGroup()
                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            );
            frame2.pack();
            frame2.setLocationRelativeTo(frame2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
    private JFrame frame;
    private JLabel label1;
    private JButton enrere;
    private JLabel label2;
    private JLabel label3;
    private JTextField tiprel;
    private JTextField priment;
    private JButton cerca;
    private JWindow frame2;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
