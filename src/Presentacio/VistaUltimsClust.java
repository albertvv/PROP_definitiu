/*
 * Created by JFormDesigner on Mon May 16 19:34:55 CEST 2016
 */

package Presentacio;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javafx.util.Pair;

/**
 * @author Albert Val
 */
public class VistaUltimsClust {
    private CtrlPresentacio cp;
    private VistaClustering vclust;
    Vector<Pair<String, Vector<Vector<Integer>>>> ultimsclust;

    public VistaUltimsClust(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
        ultimsclust= cp.UltimsClust();
        mostraUltimsClust(ultimsclust);
    }

    private void mostraUltimsClust(Vector<Pair<String, Vector<Vector<Integer>>>> pairs) {
        Vector<String>v = new Vector<>();
        for (int i = 0; i <pairs.size() ; i++) {
            v.add(cp.get_nom_relacio(pairs.get(i).getKey())); // necessito funció que passi de path a tipus relació
        }
        list1.setListData(v.toArray(new String[v.size()]));
    }

    private void EnrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        if(vclust==null) vclust = new VistaClustering(cp);
        vclust.ferVisible();
    }

    private void infobuttonActionPerformed(ActionEvent e) {
        if(list1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(frame, "Per a informació adicional has de seleccionar un resultat","Error", JOptionPane.ERROR_MESSAGE);
        }else{
            dialog1.setVisible(true);
            dialog1.pack();
            dialog1.setLocationRelativeTo(frame);
            frame.setFocusable(false);
            System.out.println(ultimsclust.get(list1.getLeadSelectionIndex()).getValue());
            list2.setListData(cp.MostraClustering(ultimsclust.get(list1.getLeadSelectionIndex()).getValue(),
                    cp.TipusEquilvalent(ultimsclust.get(list1.getLeadSelectionIndex()).getKey().charAt(0))));
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        dialog1.setVisible(false);
        frame.setFocusable(true);
    }

    private void filtrbuttonActionPerformed(ActionEvent e) {
        if(list1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(frame, "Per a filtrar has de seleccionar un resultat","Error Filtrat", JOptionPane.ERROR_MESSAGE);
        }else {
            String[] possibilities = {"Database", "Data Mining", "AI", "Information Retrieval"};
            String etiq = (String) JOptionPane.showInputDialog(
                    frame,
                    "Escull per a quina etiqueta filtrar:",
                    "Filtar de Clustering",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    possibilities[0]);
                    dialog2.setVisible(true);
                    dialog2.pack();
                    dialog2.setLocationRelativeTo(frame);
                    frame.setFocusable(false);
                    list3.setListData(cp.MostraClustering(cp.FiltratClustering(list1.getLeadSelectionIndex(), etiq)
                            ,cp.TipusEquilvalent(ultimsclust.get(list1.getLeadSelectionIndex()).getKey().charAt(0))));
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        dialog2.setVisible(false);
        frame.setFocusable(true);
    }

    private void frameWindowClosed(WindowEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hola bebes
        frame = new JFrame();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        filtrbutton = new JButton();
        infobutton = new JButton();
        dialog1 = new JDialog();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        list2 = new JList();
        button3 = new JButton();
        dialog2 = new JDialog();
        button4 = new JButton();
        list3 = new JList();
        label3 = new JLabel();

        //======== frame ========
        {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    frameWindowClosed(e);
                }
            });
            Container frameContentPane = frame.getContentPane();

            //---- label1 ----
            label1.setText("\u00daltims Resultats de Clustering");
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(list1);
            }

            //---- button1 ----
            button1.setText("Enrere");
            button1.addActionListener(e -> EnrereActionPerformed(e));

            //---- filtrbutton ----
            filtrbutton.setText("Filtra");
            filtrbutton.addActionListener(e -> filtrbuttonActionPerformed(e));

            //---- infobutton ----
            infobutton.setText("Info");
            infobutton.addActionListener(e -> infobuttonActionPerformed(e));

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(infobutton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filtrbutton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
                        .addContainerGap(81, Short.MAX_VALUE))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(label1))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addComponent(filtrbutton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                            .addComponent(infobutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(23, Short.MAX_VALUE))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== dialog1 ========
        {
            Container dialog1ContentPane = dialog1.getContentPane();

            //---- label2 ----
            label2.setText("Resultat Detallat");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(list2);
            }

            //---- button3 ----
            button3.setText("OK");
            button3.addActionListener(e -> button3ActionPerformed(e));

            GroupLayout dialog1ContentPaneLayout = new GroupLayout(dialog1ContentPane);
            dialog1ContentPane.setLayout(dialog1ContentPaneLayout);
            dialog1ContentPaneLayout.setHorizontalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(59, Short.MAX_VALUE)
                        .addGroup(dialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(146, 146, 146))))
            );
            dialog1ContentPaneLayout.setVerticalGroup(
                dialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
            );
            dialog1.pack();
            dialog1.setLocationRelativeTo(dialog1.getOwner());
        }

        //======== dialog2 ========
        {
            Container dialog2ContentPane = dialog2.getContentPane();

            //---- button4 ----
            button4.setText("OK");
            button4.addActionListener(e -> {
			button3ActionPerformed(e);
			button4ActionPerformed(e);
		});

            //---- label3 ----
            label3.setText("Resultat Filtrat");

            GroupLayout dialog2ContentPaneLayout = new GroupLayout(dialog2ContentPane);
            dialog2ContentPane.setLayout(dialog2ContentPaneLayout);
            dialog2ContentPaneLayout.setHorizontalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(67, Short.MAX_VALUE)
                        .addGroup(dialog2ContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))
                            .addGroup(GroupLayout.Alignment.TRAILING, dialog2ContentPaneLayout.createSequentialGroup()
                                .addComponent(list3, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))))
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 131, Short.MAX_VALUE))
            );
            dialog2ContentPaneLayout.setVerticalGroup(
                dialog2ContentPaneLayout.createParallelGroup()
                    .addGroup(dialog2ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(9, Short.MAX_VALUE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(list3, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
            dialog2.pack();
            dialog2.setLocationRelativeTo(dialog2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hola bebes
    private JFrame frame;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton filtrbutton;
    private JButton infobutton;
    private JDialog dialog1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList list2;
    private JButton button3;
    private JDialog dialog2;
    private JButton button4;
    private JList list3;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void ferVisible(){
        frame.setVisible(true);
    }
}
