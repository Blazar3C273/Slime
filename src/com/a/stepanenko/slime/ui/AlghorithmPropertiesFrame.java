/*
 * Created by JFormDesigner on Sun Jun 14 12:57:40 MSK 2015
 */

package com.a.stepanenko.slime.ui;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Anton Ilot
 */
public class AlghorithmPropertiesFrame extends JFrame {
    public AlghorithmPropertiesFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Anton Ilot
        ResourceBundle bundle = ResourceBundle.getBundle("AlghorithmFormStrings");
        panel5 = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        loadSchematicsButton = new JButton();
        loadSchematicsStatuslabel = new JLabel();
        label3 = new JLabel();
        panel2 = new JPanel();
        loadCaseButton = new JButton();
        loadCaseStatusLabel = new JLabel();
        label5 = new JLabel();
        panel3 = new JPanel();
        buttonPanel2 = new JPanel();
        loadGaSettingsButton = new JButton();
        createGaSettingsButton = new JButton();
        gaSettingsStatus = new JLabel();
        buttonPanel = new JPanel();
        saveButton = new JButton();
        nextButton = new JButton();

        //======== this ========
        setTitle(bundle.getString("AlghorithmPropertiesFrame.this.title"));
        setMinimumSize(new Dimension(280, 200));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel5 ========
        {

            // JFormDesigner evaluation mark
            panel5.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel5.getBorder()));
            panel5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            panel5.setLayout(new GridLayout(6, 1));

            //---- label1 ----
            label1.setText(bundle.getString("AlghorithmPropertiesFrame.label1.text"));
            label1.setBorder(new EmptyBorder(0, 5, 0, 5));
            panel5.add(label1);

            //======== panel1 ========
            {
                panel1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, Color.gray));
                panel1.setForeground(Color.darkGray);
                panel1.setLayout(new BorderLayout());

                //---- loadSchematicsButton ----
                loadSchematicsButton.setText(bundle.getString("AlghorithmPropertiesFrame.loadSchematicsButton.text"));
                loadSchematicsButton.setOpaque(false);
                panel1.add(loadSchematicsButton, BorderLayout.LINE_START);

                //---- loadSchematicsStatuslabel ----
                loadSchematicsStatuslabel.setText(bundle.getString("AlghorithmPropertiesFrame.loadSchematicsStatuslabel.text"));
                loadSchematicsStatuslabel.setBorder(new EmptyBorder(0, 5, 0, 5));
                loadSchematicsStatuslabel.setHorizontalAlignment(SwingConstants.CENTER);
                loadSchematicsStatuslabel.setHorizontalTextPosition(SwingConstants.CENTER);
                loadSchematicsStatuslabel.setMinimumSize(new Dimension(86, 14));
                loadSchematicsStatuslabel.setForeground(new Color(102, 204, 0));
                loadSchematicsStatuslabel.setFont(loadSchematicsStatuslabel.getFont().deriveFont(loadSchematicsStatuslabel.getFont().getStyle() | Font.BOLD));
                panel1.add(loadSchematicsStatuslabel, BorderLayout.LINE_END);
            }
            panel5.add(panel1);

            //---- label3 ----
            label3.setText(bundle.getString("AlghorithmPropertiesFrame.label3.text"));
            label3.setBorder(new EmptyBorder(0, 5, 0, 5));
            panel5.add(label3);

            //======== panel2 ========
            {
                panel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, Color.gray));
                panel2.setForeground(Color.darkGray);
                panel2.setLayout(new BorderLayout());

                //---- loadCaseButton ----
                loadCaseButton.setText(bundle.getString("AlghorithmPropertiesFrame.loadCaseButton.text"));
                loadCaseButton.setOpaque(false);
                panel2.add(loadCaseButton, BorderLayout.LINE_START);

                //---- loadCaseStatusLabel ----
                loadCaseStatusLabel.setText(bundle.getString("AlghorithmPropertiesFrame.loadCaseStatusLabel.text"));
                loadCaseStatusLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
                loadCaseStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
                loadCaseStatusLabel.setMinimumSize(new Dimension(86, 14));
                loadCaseStatusLabel.setFont(loadCaseStatusLabel.getFont().deriveFont(loadCaseStatusLabel.getFont().getStyle() | Font.BOLD));
                panel2.add(loadCaseStatusLabel, BorderLayout.LINE_END);
            }
            panel5.add(panel2);

            //---- label5 ----
            label5.setText(bundle.getString("AlghorithmPropertiesFrame.label5.text"));
            label5.setBorder(new EmptyBorder(0, 5, 0, 5));
            panel5.add(label5);

            //======== panel3 ========
            {
                panel3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, Color.gray));
                panel3.setForeground(Color.darkGray);
                panel3.setLayout(new BorderLayout());

                //======== buttonPanel2 ========
                {
                    buttonPanel2.setLayout(new GridLayout());

                    //---- loadGaSettingsButton ----
                    loadGaSettingsButton.setText(bundle.getString("AlghorithmPropertiesFrame.loadGaSettingsButton.text"));
                    loadGaSettingsButton.setOpaque(false);
                    buttonPanel2.add(loadGaSettingsButton);

                    //---- createGaSettingsButton ----
                    createGaSettingsButton.setText(bundle.getString("AlghorithmPropertiesFrame.createGaSettingsButton.text"));
                    createGaSettingsButton.setOpaque(false);
                    buttonPanel2.add(createGaSettingsButton);
                }
                panel3.add(buttonPanel2, BorderLayout.LINE_START);

                //---- gaSettingsStatus ----
                gaSettingsStatus.setText(bundle.getString("AlghorithmPropertiesFrame.gaSettingsStatus.text"));
                gaSettingsStatus.setBorder(new EmptyBorder(0, 5, 0, 5));
                gaSettingsStatus.setHorizontalAlignment(SwingConstants.CENTER);
                gaSettingsStatus.setMinimumSize(new Dimension(86, 14));
                gaSettingsStatus.setFont(gaSettingsStatus.getFont().deriveFont(gaSettingsStatus.getFont().getStyle() | Font.BOLD));
                panel3.add(gaSettingsStatus, BorderLayout.LINE_END);
            }
            panel5.add(panel3);
        }
        contentPane.add(panel5, BorderLayout.CENTER);

        //======== buttonPanel ========
        {
            buttonPanel.setLayout(new GridLayout());

            //---- saveButton ----
            saveButton.setText(bundle.getString("AlghorithmPropertiesFrame.saveButton.text"));
            saveButton.setOpaque(false);
            buttonPanel.add(saveButton);

            //---- nextButton ----
            nextButton.setText(bundle.getString("AlghorithmPropertiesFrame.nextButton.text"));
            nextButton.setOpaque(false);
            buttonPanel.add(nextButton);
        }
        contentPane.add(buttonPanel, BorderLayout.PAGE_END);
        setSize(300, 200);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Anton Ilot
    private JPanel panel5;
    private JLabel label1;
    private JPanel panel1;
    private JButton loadSchematicsButton;
    private JLabel loadSchematicsStatuslabel;
    private JLabel label3;
    private JPanel panel2;
    private JButton loadCaseButton;
    private JLabel loadCaseStatusLabel;
    private JLabel label5;
    private JPanel panel3;
    private JPanel buttonPanel2;
    private JButton loadGaSettingsButton;
    private JButton createGaSettingsButton;
    private JLabel gaSettingsStatus;
    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton nextButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
