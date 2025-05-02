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

  public SortDisplay(int arraySize, String algorithm, JFrame parentFrame) {
    this.arraySize = arraySize;
    this.algorithm = algorithm;
    this.parentFrame = parentFrame;

    initializeDisplay();
  }

  private void initializeDisplay() {
    setLayout(new GridBagLayout());
    setBackground(new Color(0, 0, 0));
    setBackground(Color.GRAY);

    addHeader();
    addBarChartPanel();
    addComponentsPanel();
  }

  private void addHeader() {
    add(new JLabel("Array of size: " + arraySize), createConstraints(0, 0));
    add(new JLabel("Sorting with algorithm: " + algorithm), createConstraints(1, 0));
  }

  private void addBarChartPanel() {
    add(new BarChartPanel(arraySize, parentFrame), createConstraints(0, 1, 2));
  }

  private void addComponentsPanel() {
    add(new ComponentsPanel(), createConstraints(0, 2, 2));
  }


  private GridBagConstraints createConstraints(int x, int y) {
    return createConstraints(x, y, 1);
  }

  private GridBagConstraints createConstraints(int x, int y, int gridWidth) {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 20, 10, 20);
    gbc.gridx = x;
    gbc.gridy = y;
    gbc.gridwidth = gridWidth;
    gbc.weightx = 0.5;
    return gbc;
  }
}
