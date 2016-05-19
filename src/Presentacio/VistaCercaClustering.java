/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import com.sun.awt.AWTUtilities;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 *
 * @author Albert
 */
public class VistaCercaClustering {
    private CtrlPresentacio cp;
    public  VistaClustering vclust;
    private String path;
    /**
     * Creates new form VistaCercaClustering
     */
    private void EnrereActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        if(vclust==null) vclust = new VistaClustering(cp);
        vclust.ferVisible();
    }

    private void BotoAgrupaActionPerformed(ActionEvent e) {
        try{
            path = textfieldpath.getText();
            Vector<String> s = cp.readTextArea(jTextArea1);
            if(path_valid()){
                if(grup_valid()){
                    if(it_valid()){
                        if(checked(s)) IniciaCerca(s);

                    }
                    else{
                        JOptionPane.showMessageDialog(frame,
                                "El nombre d'iteracions ha de ser superior a 0","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame,
                            "El nombre de grups ha de ser inferior o igual al nombre d'entitats i ha de ser superior a 1","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,
                        "Tipus de cerca invàlid, ha de tenir el mateix tipus d'entitat al principi i al final","Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e1) {
            if(e1.getMessage() == "Entitats Repetides")
                JOptionPane.showMessageDialog(frame,
                        "Entitats Repetides","Error", JOptionPane.ERROR_MESSAGE);
            else JOptionPane.showMessageDialog(frame,                                  //FALTA TRACTAR INPUT INCORRECTE
                    "EP aquí hi ha algún problema","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void IniciaCerca(Vector<String> s) throws Exception {
        Vector<Integer> vi =NomtoID(s);
        AWTUtilities.setWindowOpaque(framew, false);
        framew.setVisible(true);
        framew.setEnabled(true);
        class Computa implements Runnable{

            @Override
            public void run() {
                enrerebutton.setEnabled(false);
                BotoAgrupa.setEnabled(false);
                Vector<Vector<Integer>> c = cp.Clustering(path, Integer.parseInt(numgrupstext.getText()),vi, Integer.parseInt(iteracionstext.getText()));
                jDialog1.setVisible(true);
                jDialog1.pack();
                jDialog1.setLocationRelativeTo(frame);
                jPanel1.setFocusable(false);
                jList1.setListData(cp.MostraClustering(c,cp.TipusEquilvalent(path.charAt(0))));
                framew.setVisible(false);
                framew.setEnabled(false);
                BotoAgrupa.setEnabled(true);
                enrerebutton.setEnabled(true);

            }
        }
        Computa c = new Computa();
        Thread t = new Thread(c);
        t.start();
    }

    private String showOptDialog(String[] ids,String nom) {
        String f = (String) JOptionPane.showInputDialog(frame,
                nom+" es refereix a múltiples entitats, escull quina",
                "Multiples refèrencies",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ids,
                ids[0]);
        return f;
    }


    private boolean checked(Vector<String> s) {
        for (int i = 0; i <s.size() ; i++) {
            String t = cp.TipusEquilvalent(path.charAt(0));
            if(cp.NomToID(s.get(i),t).size()==0) {
                JOptionPane.showMessageDialog(frame,
                        "L'entitat amb nom "+s.get(i)+" de tipus "+t+" no existeix","Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    private Vector<Integer> NomtoID(Vector<String> s) throws Exception {
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i <s.size() ; i++) {
            System.out.println("Nom toID de id :"+s.get(i));
            Vector<Integer> w = cp.NomToID(s.get(i),cp.TipusEquilvalent(path.charAt(0)));
            System.out.println(w);
            if(w.size()>1)v.add((Integer.parseInt(showOptDialog(cp.convert(w),s.get(i)))));
            else v.add(w.get(0));
            cp.checknorepe(v,v.lastElement());
        }
        return v;
    }


    private boolean it_valid() {
        return Integer.parseInt(iteracionstext.getText())>0;
    }

    private boolean grup_valid() {
        int g = Integer.parseInt(numgrupstext.getText());
        return (g <= jTextArea1.getLineCount()) && g>1;
    }

    private boolean path_valid() {
        return (path.charAt(0) == path.charAt(path.length()-1)); // ex: APA (A==A)
    }


    private void button2ActionPerformed(ActionEvent e) {
        jDialog1.setVisible(false);
        jPanel1.setFocusable(true);
    }

    private void framewComponentMoved(ComponentEvent e) {
        framew.setLocationRelativeTo(frame);
    }

    public VistaCercaClustering(CtrlPresentacio cp) {
        this.cp = cp;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Albert Val
    private void initComponents() {
        frame = new JFrame();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel3 = new JLabel();
        textfieldpath = new JTextField();
        BotoAgrupa = new JButton();
        jLabel4 = new JLabel();
        numgrupstext = new JTextField();
        jLabel5 = new JLabel();
        iteracionstext = new JTextField();
        enrerebutton = new JButton();
        jDialog1 = new JDialog();
        jScrollPane2 = new JScrollPane();
        jList1 = new JList<>();
        jLabel6 = new JLabel();
        button2 = new JButton();
        framew = new JWindow();
        label1 = new JLabel();

        //======== frame ========
        {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentMoved(ComponentEvent e) {
                    framewComponentMoved(e);
                }
            });
            Container frameContentPane = frame.getContentPane();

            //======== jPanel1 ========
            {

                // JFormDesigner evaluation mark
                jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- jLabel1 ----
                jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setText("Clustering");
                jLabel1.setToolTipText("");

                //---- jLabel2 ----
                jLabel2.setText("Entitats a agrupar:");

                //======== jScrollPane1 ========
                {

                    //---- jTextArea1 ----
                    jTextArea1.setColumns(20);
                    jTextArea1.setRows(5);
                    jScrollPane1.setViewportView(jTextArea1);
                }

                //---- jLabel3 ----
                jLabel3.setText("Tipus de cerca:");

                //---- BotoAgrupa ----
                BotoAgrupa.setText("Agrupa");
                BotoAgrupa.setToolTipText("");
                BotoAgrupa.addActionListener(e -> {
			BotoAgrupaActionPerformed(e);
		});

                //---- jLabel4 ----
                jLabel4.setText("Nombre de grups:");

                //---- jLabel5 ----
                jLabel5.setText("Nombre iteracions:");

                //---- enrerebutton ----
                enrerebutton.setText("Enrere");
                enrerebutton.addActionListener(e -> EnrereActionPerformed(e));

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup()
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup()
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup()
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup()
                                        .addComponent(textfieldpath, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(enrerebutton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(54, 54, 54)
                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(numgrupstext, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(iteracionstext, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(BotoAgrupa)))
                            .addGap(22, 22, 22))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup()
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(enrerebutton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addGap(5, 5, 5)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(textfieldpath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(numgrupstext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(iteracionstext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup()
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BotoAgrupa))
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(jPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== jDialog1 ========
        {
            Container jDialog1ContentPane = jDialog1.getContentPane();

            //======== jScrollPane2 ========
            {

                //---- jList1 ----
                jList1.setModel(new AbstractListModel<String>() {
                    String[] values = {
                        "Item 1",
                        "Item 2",
                        "Item 3",
                        "Item 4",
                        "Item 5"
                    };
                    @Override
                    public int getSize() { return values.length; }
                    @Override
                    public String getElementAt(int i) { return values[i]; }
                });
                jScrollPane2.setViewportView(jList1);
            }

            //---- jLabel6 ----
            jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel6.setText("Resultat del Clustering");

            //---- button2 ----
            button2.setText("OK");
            button2.addActionListener(e -> button2ActionPerformed(e));

            GroupLayout jDialog1ContentPaneLayout = new GroupLayout(jDialog1ContentPane);
            jDialog1ContentPane.setLayout(jDialog1ContentPaneLayout);
            jDialog1ContentPaneLayout.setHorizontalGroup(
                jDialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(jDialog1ContentPaneLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jDialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addGroup(jDialog1ContentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, jDialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(GroupLayout.Alignment.TRAILING, jDialog1ContentPaneLayout.createSequentialGroup()
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))))
            );
            jDialog1ContentPaneLayout.setVerticalGroup(
                jDialog1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, jDialog1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== framew ========
        {
            framew.setOpacity(0.5F);
            framew.setFocusable(false);
            framew.setFocusableWindowState(false);
            framew.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            framew.setAlwaysOnTop(true);
            framew.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentMoved(ComponentEvent e) {
                    framewComponentMoved(e);
                }
            });
            Container framewContentPane = framew.getContentPane();

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/Presentacio/ajax-loader.gif")));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setFocusable(false);
            label1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            GroupLayout framewContentPaneLayout = new GroupLayout(framewContentPane);
            framewContentPane.setLayout(framewContentPaneLayout);
            framewContentPaneLayout.setHorizontalGroup(
                framewContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
            );
            framewContentPaneLayout.setVerticalGroup(
                framewContentPaneLayout.createParallelGroup()
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            );
            framew.pack();
            framew.setLocationRelativeTo(framew.getOwner());
        }
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Albert Val
    private JFrame frame;
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JLabel jLabel3;
    private JTextField textfieldpath;
    private JButton BotoAgrupa;
    private JLabel jLabel4;
    private JTextField numgrupstext;
    private JLabel jLabel5;
    private JTextField iteracionstext;
    private JButton enrerebutton;
    private JDialog jDialog1;
    private JScrollPane jScrollPane2;
    private JList<String> jList1;
    private JLabel jLabel6;
    private JButton button2;
    private JWindow framew;
    private JLabel label1;
    // End of variables declaration//GEN-END:variables
    public void ferVisible(){
        frame.setVisible(true);
    }
}
