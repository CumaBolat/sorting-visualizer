package com.sorting.visualizer.frontend.sortdisplay;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortDisplay extends JPanel {
  private int arraySize;
  private String algorithm;
  private JFrame parentFrame;

  private BarChartPanel barChartPanel;

  public SortDisplay(int arraySize, String algorithm, JFrame parentFrame) {
    this.arraySize = arraySize;
    this.algorithm = algorithm;
    this.parentFrame = parentFrame;

    initializeDisplay();
  }

  private void initializeDisplay() {
    setLayout(new GridBagLayout());
    setBackground(Color.WHITE);

    addHeader();
    addBarChartPanel();
    addComponentsPanel();
  }

  private void addHeader() {
    add(new JLabel("Array of size: " + arraySize), createConstraints(0, 0));
    add(new JLabel("Sorting with algorithm: " + algorithm), createConstraints(1, 0));
  }

  private void addBarChartPanel() {
    barChartPanel = new BarChartPanel(arraySize, parentFrame);
    add(barChartPanel, createConstraints(0, 1, 2));
  }

  private void addComponentsPanel() {
    add(new ComponentsPanel(), createConstraints(0, 2, 2));
  }

  private GridBagConstraints createConstraints(int x, int y) {
    return createConstraints(x, y, 1);
  }

  private GridBagConstraints createConstraints(int x, int y, int gridWidth) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = gridWidth;
    gbc.insets = new Insets(10, 20, 10, 20);
    gbc.weightx = 1.0;
    gbc.weighty = (y == 0) ? 0 : 1.0;
    gbc.fill = GridBagConstraints.BOTH;
    return gbc;
  }
}
