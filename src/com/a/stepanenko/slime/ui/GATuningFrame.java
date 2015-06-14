/*
 * Created by JFormDesigner on Sun Jun 14 14:02:15 MSK 2015
 */

package com.a.stepanenko.slime.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Anton Ilot
 */
public class GATuningFrame extends JFrame {
    public GATuningFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Anton Ilot
        ResourceBundle bundle = ResourceBundle.getBundle("AlghorithmFormStrings");
        tabPanel = new JTabbedPane();
        reproductionPanel = new JPanel();
        vSpacer2 = new JPanel(null);
        panel11 = new JPanel();
        label3 = new JLabel();
        reproductionTypeComboBox = new JComboBox<>();
        panel12 = new JPanel();
        label4 = new JLabel();
        populationSizeSpinner = new JSpinner();
        vSpacer1 = new JPanel(null);
        creatingPopulationPanel = new JPanel();
        creatingPopulationOptionPanel = new JPanel();
        panel13 = new JPanel();
        label1 = new JLabel();
        strategicComboBox = new JComboBox<>();
        goPanel = new JPanel();
        panel9 = new JPanel();
        scrollPane1 = new JScrollPane();
        goList = new JList<>();
        panel10 = new JPanel();
        addGoButton = new JButton();
        delateGobutton = new JButton();
        goOptionsPanel = new JPanel();
        traceOptionPanel = new JPanel();
        label6 = new JButton();
        okCancelButtonsPanel = new JPanel();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setTitle(bundle.getString("GATuningFrame.this.title"));
        setMinimumSize(new Dimension(470, 400));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== tabPanel ========
        {
            tabPanel.setMinimumSize(new Dimension(470, 400));

            //======== reproductionPanel ========
            {

                // JFormDesigner evaluation mark
                reproductionPanel.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                                java.awt.Color.red), reproductionPanel.getBorder()));
                reproductionPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                    public void propertyChange(java.beans.PropertyChangeEvent e) {
                        if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                    }
                });

                reproductionPanel.setLayout(new GridLayout(4, 1));
                reproductionPanel.add(vSpacer2);

                //======== panel11 ========
                {
                    panel11.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText(bundle.getString("GATuningFrame.label3.text"));
                    panel11.add(label3);

                    //---- reproductionTypeComboBox ----
                    reproductionTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                            "\u042d\u043b\u0438\u0442\u043d\u0430\u044f \u0441\u0445\u0435\u043c\u0430",
                            "\u041f\u043e\u0441\u043b\u0435\u0434\u043e\u0432\u0430\u0442\u0435\u043b\u044c\u043d\u0430\u044f \u0441\u0445\u0435\u043c\u0430"
                    }));
                    panel11.add(reproductionTypeComboBox);
                }
                reproductionPanel.add(panel11);

                //======== panel12 ========
                {
                    panel12.setLayout(new FlowLayout());

                    //---- label4 ----
                    label4.setText(bundle.getString("GATuningFrame.label4.text"));
                    panel12.add(label4);

                    //---- populationSizeSpinner ----
                    populationSizeSpinner.setModel(new SpinnerNumberModel(10, 10, null, 10));
                    panel12.add(populationSizeSpinner);
                }
                reproductionPanel.add(panel12);
                reproductionPanel.add(vSpacer1);
            }
            tabPanel.addTab(bundle.getString("GATuningFrame.reproductionPanel.tab.title"), reproductionPanel);
            tabPanel.setBackgroundAt(0, Color.darkGray);

            //======== creatingPopulationPanel ========
            {
                creatingPopulationPanel.setLayout(new BorderLayout());

                //======== creatingPopulationOptionPanel ========
                {
                    creatingPopulationOptionPanel.setLayout(new FlowLayout());
                }
                creatingPopulationPanel.add(creatingPopulationOptionPanel, BorderLayout.CENTER);

                //======== panel13 ========
                {
                    panel13.setLayout(new FlowLayout());

                    //---- label1 ----
                    label1.setText(bundle.getString("GATuningFrame.label1.text"));
                    panel13.add(label1);

                    //---- strategicComboBox ----
                    strategicComboBox.setModel(new DefaultComboBoxModel<>(new String[]{
                            "\u042d\u0432\u0440\u0438\u0441\u0442\u0438\u043a\u0430",
                            "\u0414\u0440\u043e\u0431\u043e\u0432\u0438\u043a",
                            "\u0424\u043e\u043a\u0443\u0441\u0438\u0440\u043e\u0432\u043a\u0430"
                    }));
                    panel13.add(strategicComboBox);
                }
                creatingPopulationPanel.add(panel13, BorderLayout.NORTH);
            }
            tabPanel.addTab(bundle.getString("GATuningFrame.creatingPopulationPanel.tab.title"), creatingPopulationPanel);

            //======== goPanel ========
            {
                goPanel.setLayout(new GridLayout());

                //======== panel9 ========
                {
                    panel9.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel9.setLayout(new BorderLayout());

                    //======== scrollPane1 ========
                    {

                        //---- goList ----
                        goList.setModel(new AbstractListModel<String>() {
                            String[] values = {
                                    "\u041a\u0440\u043e\u0441\u0441\u0438\u043d\u0433\u043e\u0432\u0435\u0440",
                                    "\u041c\u0443\u0442\u0430\u0446\u0438\u044f",
                                    "\u0421\u0435\u043b\u0435\u043a\u0446\u0438\u044f"
                            };

                            @Override
                            public int getSize() {
                                return values.length;
                            }

                            @Override
                            public String getElementAt(int i) {
                                return values[i];
                            }
                        });
                        scrollPane1.setViewportView(goList);
                    }
                    panel9.add(scrollPane1, BorderLayout.CENTER);

                    //======== panel10 ========
                    {
                        panel10.setLayout(new GridLayout());

                        //---- addGoButton ----
                        addGoButton.setText(bundle.getString("GATuningFrame.addGoButton.text"));
                        panel10.add(addGoButton);

                        //---- delateGobutton ----
                        delateGobutton.setText(bundle.getString("GATuningFrame.delateGobutton.text"));
                        panel10.add(delateGobutton);
                    }
                    panel9.add(panel10, BorderLayout.SOUTH);
                }
                goPanel.add(panel9);

                //======== goOptionsPanel ========
                {
                    goOptionsPanel.setLayout(new FlowLayout());
                }
                goPanel.add(goOptionsPanel);
            }
            tabPanel.addTab(bundle.getString("GATuningFrame.goPanel.tab.title"), goPanel);

            //======== traceOptionPanel ========
            {
                traceOptionPanel.setLayout(new FlowLayout());

                //---- label6 ----
                label6.setText(bundle.getString("GATuningFrame.label6.text"));
                traceOptionPanel.add(label6);
            }
            tabPanel.addTab(bundle.getString("GATuningFrame.traceOptionPanel.tab.title"), traceOptionPanel);
        }
        contentPane.add(tabPanel, BorderLayout.CENTER);

        //======== okCancelButtonsPanel ========
        {
            okCancelButtonsPanel.setLayout(new GridLayout());

            //---- button3 ----
            button3.setText(bundle.getString("GATuningFrame.button3.text"));
            okCancelButtonsPanel.add(button3);

            //---- button4 ----
            button4.setText(bundle.getString("GATuningFrame.button4.text"));
            okCancelButtonsPanel.add(button4);
        }
        contentPane.add(okCancelButtonsPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Anton Ilot
    private JTabbedPane tabPanel;
    private JPanel reproductionPanel;
    private JPanel vSpacer2;
    private JPanel panel11;
    private JLabel label3;
    private JComboBox<String> reproductionTypeComboBox;
    private JPanel panel12;
    private JLabel label4;
    private JSpinner populationSizeSpinner;
    private JPanel vSpacer1;
    private JPanel creatingPopulationPanel;
    private JPanel creatingPopulationOptionPanel;
    private JPanel panel13;
    private JLabel label1;
    private JComboBox<String> strategicComboBox;
    private JPanel goPanel;
    private JPanel panel9;
    private JScrollPane scrollPane1;
    private JList<String> goList;
    private JPanel panel10;
    private JButton addGoButton;
    private JButton delateGobutton;
    private JPanel goOptionsPanel;
    private JPanel traceOptionPanel;
    private JButton label6;
    private JPanel okCancelButtonsPanel;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
