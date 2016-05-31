/*
 * Created by JFormDesigner on Sun May 29 19:51:04 CEST 2016
 */

package Presentacio;

import com.sun.awt.AWTUtilities;
import org.la4j.vector.SparseVector;
import org.la4j.vector.sparse.CompressedVector;

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

    private Integer obteid(String nom) throws Exception {
        Vector<Integer> v = cp.NomToID(nom,cp.TipusEquilvalent(path.charAt(0)));
        if(v.size() == 1) {return v.get(0);}
        else {
            String ids[] = cp.convert(v);
            String s = (String) JOptionPane.showInputDialog(frame, nom+" es refereix a múltiples entitats, escull quina",
                    "Multiples refèrencies", JOptionPane.QUESTION_MESSAGE, null, ids, ids[0]);
            return Integer.parseInt(s);
        }
    }

    private void IniciaCerca(Integer id) throws Exception {
        AWTUtilities.setWindowOpaque(frame2, false);
        frame2.setVisible(true);
        frame2.setEnabled(true);
        class Computa implements Runnable{

            @Override
            public void run() {
                enrere.setEnabled(false);
                cerca.setEnabled(false);
                SparseVector sv = null;
                try {
                    sv = cp.RelImportant(path, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                frame2.setVisible(false);
                frame2.setEnabled(false);
                resultat.setVisible(true);
                resultat.pack();
                resultat.setLocationRelativeTo(frame);
                panel1.setFocusable(false);
                try {
                    llistares.setListData(cp.MostraRelImp(sv,cp.TipusEquilvalent(path.charAt(0)),id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

    private void framewComponentMoved(ComponentEvent e) {
        frame2.setLocationRelativeTo(frame);
    }

    private void enrere2ActionPerformed(ActionEvent e) {
        resultat.setVisible(false);
        panel1.setFocusable(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
        frame = new JFrame();
        panel1 = new JPanel();
        enrere = new JButton();
        label1 = new JLabel();
        tiprel = new JTextField();
        label2 = new JLabel();
        priment = new JTextField();
        label3 = new JLabel();
        cerca = new JButton();
        frame2 = new JWindow();
        label4 = new JLabel();
        resultat = new JDialog();
        label5 = new JLabel();
        enrere2 = new JButton();
        scrollPane1 = new JScrollPane();
        llistares = new JList();

        //======== frame ========
        {
            Container frameContentPane = frame.getContentPane();

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- enrere ----
                enrere.setText("Enrere");
                enrere.addActionListener(e -> enrereActionPerformed(e));

                //---- label1 ----
                label1.setText("Cerca Relaci\u00f3 Important");

                //---- label2 ----
                label2.setText("Tipus de relaci\u00f3:");

                //---- label3 ----
                label3.setText("Primera entitat:");

                //---- cerca ----
                cerca.setText("Cerca");
                cerca.addActionListener(e -> cercaActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(enrere)
                                    .addGap(43, 43, 43)
                                    .addComponent(label1))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addComponent(label2)
                                        .addComponent(label3))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(priment, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(tiprel, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                            .addGap(0, 60, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(295, Short.MAX_VALUE)
                            .addComponent(cerca)
                            .addContainerGap())
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(enrere))
                            .addGap(38, 38, 38)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(tiprel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(priment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48)
                            .addComponent(cerca)
                            .addContainerGap())
                );
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    framewComponentMoved(e);
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

        //======== resultat ========
        {
            Container resultatContentPane = resultat.getContentPane();

            //---- label5 ----
            label5.setText("Resultat de Relaci\u00f3 Important");

            //---- enrere2 ----
            enrere2.setText("Enrere");
            enrere2.addActionListener(e -> enrere2ActionPerformed(e));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(llistares);
            }

            GroupLayout resultatContentPaneLayout = new GroupLayout(resultatContentPane);
            resultatContentPane.setLayout(resultatContentPaneLayout);
            resultatContentPaneLayout.setHorizontalGroup(
                resultatContentPaneLayout.createParallelGroup()
                    .addGroup(resultatContentPaneLayout.createSequentialGroup()
                        .addGroup(resultatContentPaneLayout.createParallelGroup()
                            .addGroup(resultatContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(enrere2)
                                .addGap(36, 36, 36)
                                .addComponent(label5))
                            .addGroup(resultatContentPaneLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))
            );
            resultatContentPaneLayout.setVerticalGroup(
                resultatContentPaneLayout.createParallelGroup()
                    .addGroup(resultatContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(resultatContentPaneLayout.createParallelGroup()
                            .addComponent(enrere2)
                            .addComponent(label5))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
            );
            resultat.pack();
            resultat.setLocationRelativeTo(resultat.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ãlvar HernÃ¡ndez
    private JFrame frame;
    private JPanel panel1;
    private JButton enrere;
    private JLabel label1;
    private JTextField tiprel;
    private JLabel label2;
    private JTextField priment;
    private JLabel label3;
    private JButton cerca;
    private JWindow frame2;
    private JLabel label4;
    private JDialog resultat;
    private JLabel label5;
    private JButton enrere2;
    private JScrollPane scrollPane1;
    private JList llistares;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
