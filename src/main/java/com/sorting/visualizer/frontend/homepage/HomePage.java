package com.sorting.visualizer.frontend.homepage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sorting.visualizer.frontend.homepage.components.AlgorithmComboBox;
import com.sorting.visualizer.frontend.homepage.components.AlgorithmLabel;
import com.sorting.visualizer.frontend.homepage.components.ArraySizeField;
import com.sorting.visualizer.frontend.homepage.components.ArraySizeLabel;
import com.sorting.visualizer.frontend.homepage.components.SortButton;

public class HomePage extends JPanel {
  public HomePage() {
    initializeHomePage();
  }

  private void initializeHomePage() {
    setLayout(new GridBagLayout());
    setBackground(Color.WHITE);

    addHeader();
    addArraySizeSection();
    addAlgorithmSelectionSection();
    addStartButton();
  }

  private void addHeader() {
    JLabel titleLabel = new JLabel("Sorting Algorithm Visualizer", JLabel.CENTER);
    titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
    titleLabel.setForeground(new Color(40, 40, 40));

    add(titleLabel, createConstraints(0, 0, 2));
  }

  private void addArraySizeSection() {
    add(new ArraySizeLabel(), createConstraints(0, 1));
    add(new ArraySizeField(), createConstraints(1, 1));
  }

  private void addAlgorithmSelectionSection() {
    add(new AlgorithmLabel(), createConstraints(0, 2));
    add(new AlgorithmComboBox(), createConstraints(1, 2));
  }

  private void addStartButton() {
    add(new SortButton(), createConstraints(0, 3, 2));
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
