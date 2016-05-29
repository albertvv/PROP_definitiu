package Presentacio;

import com.sun.awt.AWTUtilities;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 * Created by albert.val.vila on 10/05/2016.
 */
public class VistaCerques  {
    private CtrlPresentacio cp;
    private VistaClustering vclustering;
    private VistaRellevancia vrellevancia;
    private VistaRelImportant vrelimp;
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
        impbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionPerformed_buttonObrirImp(e);
            }
        });
    }

    public void actionPerformed_buttonObrirImp (ActionEvent e) {
        System.out.println("obro important");
        desactivar();
        if(vrelimp==null)vrelimp = new VistaRelImportant(cp);
        vrelimp.ferVisible();
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
        Vector<String> v = cp.getLlistaPaths();
        v.add(0,"Totes");
        String [] m = new String[v.size()];
        v.copyInto(m); //copio
        v.remove(0);
        String f = (String) JOptionPane.showInputDialog(frame,"Recalcular matrius",
                "Escolleix que vols recalcular",
                JOptionPane.QUESTION_MESSAGE,
                null,
                m,
                m[0]);
        AWTUtilities.setWindowOpaque(framew, false);
        framew.setVisible(true);
        framew.setEnabled(true);
        class Computa implements Runnable{
            @Override
            public void run() {
                clustbutton.setEnabled(false);
                enrere.setEnabled(false);
                relbutton.setEnabled(false);
                reldirectbutton.setEnabled(false);
                impbutton.setEnabled(false);
                recalcmat.setEnabled(false);
                if(f.equals("Totes")){  //canviar try catch i el disable del loading
                    for (int i = 1; i <m.length ; i++) {
                        try {
                            cp.recalcula_matriu(m[i]);
                            JOptionPane.showMessageDialog(frame,
                                    "S'ha recalculat l'opció correctament","Matrius",JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException e1) {
                            JOptionPane.showMessageDialog(frame,
                                    "No s'ha pogut recalcular "+m[i],"Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if(m.length==1)JOptionPane.showMessageDialog(frame,
                            "No hi ha cap Matriu guardada","Error",JOptionPane.ERROR_MESSAGE);
                }
                else try {
                    cp.recalcula_matriu(f);
                    framew.setVisible(false);
                    framew.setEnabled(false);
                    JOptionPane.showMessageDialog(frame,
                            "S'ha recalculat l'opció correctament","Matrius",JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame,
                            "No s'ha pogut recalcular "+f,"Error",JOptionPane.ERROR_MESSAGE);
                }
                clustbutton.setEnabled(true);
                enrere.setEnabled(true);
                relbutton.setEnabled(true);
                reldirectbutton.setEnabled(true);
                recalcmat.setEnabled(true);
                impbutton.setEnabled(true);
            }
        }
        if(f!=null) {
            Computa c = new Computa();
            Thread t = new Thread(c);
            t.start();
        }
    }

    private void EnrereActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void framewComponentMoved(ComponentEvent e) {
        framew.setLocationRelativeTo(frame);
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
        framew = new JWindow();
        label4 = new JLabel();

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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(relbutton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(impbutton)
                        .addGap(12, 12, 12)
                        .addComponent(reldirectbutton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clustbutton)
                        .addGap(67, 67, 67)
                        .addComponent(recalcmat)
                        .addGap(54, 54, 54))
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
            label4.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentMoved(ComponentEvent e) {
                    framewComponentMoved(e);
                }
            });

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
    // Generated using JFormDesigner Evaluation license - Albert Val
    private JFrame frame;
    private JButton clustbutton;
    private JButton relbutton;
    private JButton impbutton;
    private JButton enrere;
    private JButton reldirectbutton;
    private JButton recalcmat;
    private JWindow framew;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
