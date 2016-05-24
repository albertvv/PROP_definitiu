package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaCerques  {
    private CtrlPresentacio cp;
    private VistaClustering vclustering;
    private VistaRellevancia vrellevancia;
    public VistaCerques(CtrlPresentacio ctrlPresentacio) {
        initComponents();
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        cp = ctrlPresentacio;
        inicialitzarbotons();
    }


    private void inicialitzarbotons() {
        relbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonObrirRel(e);
            }
        });
        clustbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonObrirClust(e);
            }
        });
    }

    private void actionPerformed_buttonObrirClust(ActionEvent e) {
        System.out.println("obro clustering");
        desactivar();
        if(vclustering==null)vclustering = new VistaClustering(cp);
        vclustering.ferVisible();
    }

    public void ferVisible() {
        System.out.println
                ("isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
        frame.pack();
        frame.setVisible(true);
        frame.setEnabled(true);
    }
    public void actionPerformed_buttonObrirRel (ActionEvent event) {
        System.out.println("obro rellevancia");
        desactivar();
        if(vrellevancia==null)vrellevancia = new VistaRellevancia(cp);
        vrellevancia.ferVisible();
    }

    public void desactivar() {
        frame.setEnabled(true);
        frame.setVisible(false);
    }

    private void reldirectbuttonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void enrereActionPerformed(ActionEvent e) {
        cp.principal();
        frame.setVisible(false);
    }


    private void recalcmatActionPerformed(ActionEvent e) {
        Vector<String> s =cp.getLlistaPaths();
        s.add(0,"Totes");
        String [] m = new String[s.size()];
        s.toArray(m);
        String f = (String) JOptionPane.showInputDialog(frame,"Recalcular matrius",
                "Escolleix que vols recalcular",
                JOptionPane.QUESTION_MESSAGE,
                null,
                m,
                m[0]);
        if(f.equals("Totes")){
            for (int i = 1; i <s.size() ; i++) {
                cp.guarda_matriu(s.get(i));
            }
        }
        else if(f!=null) cp.guarda_matriu(f);
    }

    private void EnrereActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Albert Val
        frame = new JFrame();
        clustbutton = new JButton();
        relbutton = new JButton();
        impbutton = new JButton();
        enrere = new JButton();
        reldirectbutton = new JButton();
        recalcmat = new JButton();

        //======== frame ========
        {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container frameContentPane = frame.getContentPane();

            //---- clustbutton ----
            clustbutton.setText("Clustering");

            //---- relbutton ----
            relbutton.setText("Cerca de Rellev\u00e0ncia");

            //---- impbutton ----
            impbutton.setText("Relacions Importants");

            //---- enrere ----
            enrere.setText("Enrere");
            enrere.addActionListener(e -> {
			EnrereActionPerformed(e);
			enrereActionPerformed(e);
		});

            //---- reldirectbutton ----
            reldirectbutton.setText("Relacions Directes");
            reldirectbutton.addActionListener(e -> reldirectbuttonActionPerformed(e));

            //---- recalcmat ----
            recalcmat.setText("Recalcula Matrius");
            recalcmat.addActionListener(e -> recalcmatActionPerformed(e));

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(frameContentPaneLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                    .addComponent(clustbutton)
                                    .addComponent(reldirectbutton)
                                    .addComponent(impbutton)
                                    .addComponent(relbutton)
                                    .addComponent(recalcmat)))
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(enrere, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(175, Short.MAX_VALUE))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(enrere)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(relbutton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(impbutton)
                        .addGap(12, 12, 12)
                        .addComponent(reldirectbutton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clustbutton)
                        .addGap(84, 84, 84)
                        .addComponent(recalcmat)
                        .addGap(33, 33, 33))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Albert Val
    private JFrame frame;
    private JButton clustbutton;
    private JButton relbutton;
    private JButton impbutton;
    private JButton enrere;
    private JButton reldirectbutton;
    private JButton recalcmat;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
