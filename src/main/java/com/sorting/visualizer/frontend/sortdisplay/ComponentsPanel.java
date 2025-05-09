package com.sorting.visualizer.frontend.sortdisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sorting.visualizer.frontend.sortdisplay.components.ReturnButton;
import com.sorting.visualizer.frontend.sortdisplay.components.SortButton;

public class ComponentsPanel extends JPanel {
  private JFrame parentFrame;
  private BarChartPanel barChartPanel;
  private SortButton sortButton;
  private ReturnButton returnButton;

  private int[] array;
  private String algorithm;

  public ComponentsPanel(JFrame parentFrame, BarChartPanel barChartPanel, int[] array, String algorithm) {
    this.parentFrame = parentFrame;
    this.barChartPanel = barChartPanel;
    this.array = array;
    this.algorithm = algorithm;

    initializeComponents();
  }

  private void initializeComponents() {
    setLayout(new GridBagLayout());
    setBackground(Color.LIGHT_GRAY);
    setPreferredSize(new Dimension(750, 120)); // temp

    addComponents();
  }

  private void addComponents() {
    addReturnButton();
    addSortButton();
  }

  private void addReturnButton() {
    returnButton = new ReturnButton(parentFrame);

    add(returnButton, createConstraints(0, 0));
  }

  private void addSortButton() {
    sortButton = new SortButton(barChartPanel, array, algorithm);

    add(sortButton, createConstraints(0, 1));
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
