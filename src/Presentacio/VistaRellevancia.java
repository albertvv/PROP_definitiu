package Presentacio;

import java.awt.event.*;
import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Vector;


/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaRellevancia {
    private CtrlPresentacio cp;
    private String path;
    private VistaCerques vcerques;
    private void framewComponentMoved(ComponentEvent e) {
        framew.setLocationRelativeTo(frame);
    }

    private void enrereButtonActionPerformed(ActionEvent e) {
        frame.setVisible(false);
        if(vcerques==null) vcerques = new VistaCerques(cp);
        vcerques.ferVisible();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Hola bebes
        frame = new JFrame();
        JPanel panel2 = new JPanel();
        enrereButton = new JButton();
        JLabel label1 = new JLabel();
        JPanel panel3 = new JPanel();
        textField1 = new JTextField();
        JLabel label2 = new JLabel();
        JPanel panel4 = new JPanel();
        JLabel label3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        JPanel panel5 = new JPanel();
        cercaButton = new JButton();
        framew = new JWindow();
        label4 = new JLabel();

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

            //======== panel2 ========
            {

                // JFormDesigner evaluation mark
                panel2.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- enrereButton ----
                enrereButton.setText("Enrere");
                enrereButton.addActionListener(e -> enrereButtonActionPerformed(e));

                //---- label1 ----
                label1.setText("CERCA RELLEV\u00c0NCIA");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(enrereButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(enrereButton)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                );
            }

            //======== panel3 ========
            {

                //---- label2 ----
                label2.setText("Tipus de cerca : ");

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                            .addGap(92, 92, 92))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12))
                );
            }

            //======== panel4 ========
            {

                //---- label3 ----
                label3.setText("Entitats:");

                //======== jScrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setColumns(20);
                    textArea1.setRows(5);
                    jScrollPane1.setViewportView(textArea1);
                }

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(97, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGroup(panel4Layout.createParallelGroup()
                                .addComponent(label3)
                                .addGroup(panel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(35, Short.MAX_VALUE))
                );
            }

            //======== panel5 ========
            {

                //---- cercaButton ----
                cercaButton.setText("Cerca");

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(283, 283, 283)
                            .addComponent(cercaButton)
                            .addGap(141, 141, 141))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(cercaButton))
                );
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(frameContentPaneLayout.createParallelGroup()
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
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
                    framewComponentMoved(e);
                }
            });
            Container framewContentPane = framew.getContentPane();

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/Presentacio/ajax-loader.gif")));
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            label4.setFocusable(false);
            label4.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

            GroupLayout framewContentPaneLayout = new GroupLayout(framewContentPane);
            framewContentPane.setLayout(framewContentPaneLayout);
            framewContentPaneLayout.setHorizontalGroup(
                framewContentPaneLayout.createParallelGroup()
                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            );
            framewContentPaneLayout.setVerticalGroup(
                framewContentPaneLayout.createParallelGroup()
                    .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            );
            framew.pack();
            framew.setLocationRelativeTo(framew.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Hola bebes
    private JFrame frame;
    private JButton enrereButton;
    private JTextField textField1;
    private JScrollPane jScrollPane1;
    private JTextArea textArea1;
    private JButton cercaButton;
    private JWindow framew;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public VistaRellevancia(CtrlPresentacio ctrlPresentacio) {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        this.cp = ctrlPresentacio;
        initComponents();
        inicialitzarbotons();
    }


    private void inicialitzarbotons() {
        cercaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    if(cp.exist_relacio(textField1.getText())) {
                        path = cp.getPath(textField1.getText());
                        if (checked(cp.readTextArea(textArea1)) && path.length() == textArea1.getLineCount()) {
                            IniciaCerca();

                        } else if (path.length() != textArea1.getLineCount()) {
                            JOptionPane.showMessageDialog(frame,
                                    "Nombre d'entitats incorrecte (han de ser " + path.length() + ")", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }else JOptionPane.showMessageDialog(frame,
                            "Tipus de Relació incorrecte","Error",JOptionPane.ERROR_MESSAGE);
                }catch (Exception exc){
                    if(exc.getMessage() == "Entitats Repetides")
                        JOptionPane.showMessageDialog(frame,
                                "Entitats Repetides","Error", JOptionPane.ERROR_MESSAGE);
                    else if(exc.getMessage()== "fix"){
                        JOptionPane.showMessageDialog(frame,
                                "La primera i última Entitat han d'estar fixades","Error",JOptionPane.ERROR_MESSAGE);
                     }else JOptionPane.showMessageDialog(frame,
                           "EP aquí hi ha algún problema","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private void IniciaCerca() throws Exception {
        Vector<Integer> vi = NomtoID(cp.readTextArea(textArea1));
        AWTUtilities.setWindowOpaque(framew, false);
        framew.setVisible(true);
        framew.setEnabled(true);
        class Computa implements Runnable{
            @Override
            public void run() {
                DecimalFormat df = new DecimalFormat("#.#####");
                enrereButton.setEnabled(false);
                cercaButton.setEnabled(false);
                Double d = cp.CercaRellevancia(path,vi);
                framew.setVisible(false);
                framew.setEnabled(false);
                cercaButton.setEnabled(true);
                enrereButton.setEnabled(true);
                JOptionPane.showMessageDialog(frame,
                        "La rellevància és de " + df.format(d));
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
            String t = cp.TipusEquilvalent(path.charAt(i));
            if(cp.NomToID(s.get(i),t).size()==0 && !s.get(i).equals("-")) {
                JOptionPane.showMessageDialog(frame,
                        "L'entitat amb nom "+s.get(i)+" de tipus "+t+" no existeix","Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private Vector<Integer> NomtoID(Vector<String> strings) throws Exception {
        Vector<Integer> v = new Vector<>();
        for (int i = 0; i <strings.size() ; i++) {
            Vector<Integer> w = cp.NomToID(strings.get(i),cp.TipusEquilvalent(path.charAt(i)));
            System.out.println(w);
            if(w.size()>1)v.add((Integer.parseInt(showOptDialog(cp.convert(w),strings.get(i)))));
            else if(w.size()==0){
                if(i!=0 && i!=strings.size()-1) v.add(null);
                else{
                    throw new Exception("fix");
                }
            }
            else v.add(w.get(0));
            if(v.lastElement()!=null) cp.checknorepe(v,v.lastElement());
        }
        return v;
    }

    public void ferVisible() {
        System.out.println("Faig visible vistarellevancia");
        frame.pack();
        frame.setVisible(true);
        frame.setEnabled(true);
    }

}