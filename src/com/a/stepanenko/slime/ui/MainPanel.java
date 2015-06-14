/*
 * Created by JFormDesigner on Sat Jun 13 21:01:20 MSK 2015
 */

package com.a.stepanenko.slime.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author uuu eeee
 */
public class MainPanel extends JFrame {
    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Anton Ilot
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem2 = new JMenuItem();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menu3 = new JMenu();
        menu4 = new JMenu();
        menu5 = new JMenu();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u0424\u0430\u0439\u043b");

                //---- menuItem2 ----
                menuItem2.setText("\u041d\u043e\u0432\u044b\u0439 \u0440\u0430\u0441\u0441\u0447\u0435\u0442");
                menu1.add(menuItem2);
                menu1.addSeparator();

                //---- menuItem1 ----
                menuItem1.setText("\u0412\u044b\u0445\u043e\u0434");
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("text");
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("text");
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("text");
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText("\u041e \u043f\u0440\u043e\u0433\u0440\u0430\u043c\u043c\u0435");
            }
            menuBar1.add(menu5);
        }
        setJMenuBar(menuBar1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Anton Ilot
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
    private JMenu menu5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
