package Presentacio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by marc on 16/5/16.
 */
public class VistaDADES {

    private CtrlPresentacio cp;

    private VistaDadesSET       vs;
    private VistaDADESafRel     var;
    private VistaDADESesRel     ver;
    private VistaDadesAFEGIR    va;
    private VistaDadesESBORRAR  ve;

    public VistaDADES(CtrlPresentacio cp) {
        //ENRERE
        this.cp = cp;
        initComponents();
        frame1.setVisible(true);
        //IMPORTAR GRAF
        carregarColLeccióDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        //GESTIÓ ENTITATS
        afegirUnaEntitatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("obro afegir");
                frame1.setVisible(false);
                if (va == null) va = new VistaDadesAFEGIR(cp);
                va.ferVisible();
            }
        });
        modificarUnaEntitatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("obro setter");
                frame1.setVisible(false);
                if (vs == null) vs = new VistaDadesSET(cp);
                vs.ferVisible();
            }
        });
        esborrarUnaEntitatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("obro deleter");
                frame1.setVisible(false);
                if (ve == null) ve = new VistaDadesESBORRAR(cp);
                ve.ferVisible();
            }
        });
        //GESTIÓ RELACIONS
        afegirUnaRelacióDirectaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("obro afegir");
                frame1.setVisible(false);
                if (var == null) var = new VistaDADESafRel(cp);
                var.ferVisible();
            }
        });
        esborrarUnaRelacióDirectaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("obro deteler relacio");
                frame1.setVisible(false);
                if (ver == null) ver = new VistaDADESesRel(cp);
                ver.ferVisible();
            }
        });
        //SORTIDA
        desarElsCanvisIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //desar canvis
                cp.principal();
                frame1.setVisible(false);
            }
        });
    }

    public void ferVisible() {
        frame1.setVisible(true);
    }

    private void enrereButtonActionPerformed(ActionEvent e) {
        cp.principal();
        frame1.setVisible(false);
    }

    private void afegirUnaEntitatButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mariano Rajoy
        frame1 = new JFrame();
        panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        enrereButton = new JButton();
        JPanel panel4 = new JPanel();
        afegirUnaEntitatButton = new JButton();
        JPanel panel5 = new JPanel();
        esborrarUnaEntitatButton = new JButton();
        JPanel panel6 = new JPanel();
        modificarUnaEntitatButton = new JButton();
        JPanel panel7 = new JPanel();
        esborrarUnaRelacióDirectaButton = new JButton();
        JPanel panel8 = new JPanel();
        afegirUnaRelacióDirectaButton = new JButton();
        JPanel panel9 = new JPanel();
        carregarColLeccióDeButton = new JButton();
        JPanel panel3 = new JPanel();
        JPanel panel10 = new JPanel();
        JLabel label2 = new JLabel();
        JPanel panel11 = new JPanel();
        desarElsCanvisIButton = new JButton();
        JLabel label3 = new JLabel();

        //======== frame1 ========
        {
            frame1.setTitle("Gesti\u00f3 de dades");
            Container frame1ContentPane = frame1.getContentPane();

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                /*panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
*/

                //======== panel2 ========
                {

                    //---- enrereButton ----
                    enrereButton.setText("Enrere");
                    enrereButton.addActionListener(e -> enrereButtonActionPerformed(e));

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addComponent(enrereButton)
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(enrereButton)
                                .addGap(340, 340, 340))
                    );
                }

                //======== panel4 ========
                {

                    //---- afegirUnaEntitatButton ----
                    afegirUnaEntitatButton.setText("Afegir una entitat");
                    afegirUnaEntitatButton.addActionListener(e -> afegirUnaEntitatButtonActionPerformed(e));

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addComponent(afegirUnaEntitatButton, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addComponent(afegirUnaEntitatButton)
                    );
                }

                //======== panel5 ========
                {

                    //---- esborrarUnaEntitatButton ----
                    esborrarUnaEntitatButton.setText("Esborrar una entitat");

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(esborrarUnaEntitatButton, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addComponent(esborrarUnaEntitatButton)
                    );
                }

                //======== panel6 ========
                {

                    //---- modificarUnaEntitatButton ----
                    modificarUnaEntitatButton.setText("Modificar una entitat");

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addComponent(modificarUnaEntitatButton, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addComponent(modificarUnaEntitatButton)
                    );
                }

                //======== panel7 ========
                {

                    //---- esborrarUnaRelacióDirectaButton ----
                    esborrarUnaRelacióDirectaButton.setText("Esborrar una relaci\u00f3 directa");

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addComponent(esborrarUnaRelacióDirectaButton, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addComponent(esborrarUnaRelacióDirectaButton)
                    );
                }

                //======== panel8 ========
                {

                    //---- afegirUnaRelacióDirectaButton ----
                    afegirUnaRelacióDirectaButton.setText("Afegir una relaci\u00f3 directa");

                    GroupLayout panel8Layout = new GroupLayout(panel8);
                    panel8.setLayout(panel8Layout);
                    panel8Layout.setHorizontalGroup(
                        panel8Layout.createParallelGroup()
                            .addComponent(afegirUnaRelacióDirectaButton, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                    );
                    panel8Layout.setVerticalGroup(
                        panel8Layout.createParallelGroup()
                            .addComponent(afegirUnaRelacióDirectaButton)
                    );
                }

                //======== panel9 ========
                {

                    //---- carregarColLeccióDeButton ----
                    carregarColLeccióDeButton.setText("Carregar col\u00b7lecci\u00f3 de dades");

                    GroupLayout panel9Layout = new GroupLayout(panel9);
                    panel9.setLayout(panel9Layout);
                    panel9Layout.setHorizontalGroup(
                        panel9Layout.createParallelGroup()
                            .addComponent(carregarColLeccióDeButton)
                    );
                    panel9Layout.setVerticalGroup(
                        panel9Layout.createParallelGroup()
                            .addComponent(carregarColLeccióDeButton)
                    );
                }

                //======== panel3 ========
                {

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGap(0, 335, Short.MAX_VALUE)
                    );
                }

                //======== panel10 ========
                {

                    GroupLayout panel10Layout = new GroupLayout(panel10);
                    panel10.setLayout(panel10Layout);
                    panel10Layout.setHorizontalGroup(
                        panel10Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                    panel10Layout.setVerticalGroup(
                        panel10Layout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                    );
                }

                //---- label2 ----
                label2.setText("Relacions:");

                //======== panel11 ========
                {

                    //---- desarElsCanvisIButton ----
                    desarElsCanvisIButton.setText("Desar els canvis i sortir");

                    GroupLayout panel11Layout = new GroupLayout(panel11);
                    panel11.setLayout(panel11Layout);
                    panel11Layout.setHorizontalGroup(
                        panel11Layout.createParallelGroup()
                            .addComponent(desarElsCanvisIButton, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                    );
                    panel11Layout.setVerticalGroup(
                        panel11Layout.createParallelGroup()
                            .addComponent(desarElsCanvisIButton)
                    );
                }

                //---- label3 ----
                label3.setText("Entitats:");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2)
                                .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(panel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(label3)
                            .addGap(5, 5, 5)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(label2)
                            .addGap(5, 5, 5)
                            .addComponent(panel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(panel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mariano Rajoy
    private JFrame frame1;
    private JPanel panel1;
    private JButton enrereButton;
    private JButton afegirUnaEntitatButton;
    private JButton esborrarUnaEntitatButton;
    private JButton modificarUnaEntitatButton;
    private JButton esborrarUnaRelacióDirectaButton;
    private JButton afegirUnaRelacióDirectaButton;
    private JButton carregarColLeccióDeButton;
    private JButton desarElsCanvisIButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
