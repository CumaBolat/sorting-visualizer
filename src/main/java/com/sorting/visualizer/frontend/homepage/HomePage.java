package com.sorting.visualizer.frontend.homepage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sorting.visualizer.frontend.homepage.components.AlgorithmComboBox;
import com.sorting.visualizer.frontend.homepage.components.AlgorithmLabel;
import com.sorting.visualizer.frontend.homepage.components.ArraySizeField;
import com.sorting.visualizer.frontend.homepage.components.ArraySizeLabel;
import com.sorting.visualizer.frontend.homepage.components.GenerateArrayButton;
import com.sorting.visualizer.frontend.homepage.components.HomePageHeader;
import com.sorting.visualizer.frontend.sortdisplay.SortDisplay;

public class HomePage extends JPanel {
  private ArraySizeField arraySizeField;
  private SortDisplay sortDisplay;
  private AlgorithmComboBox algorithmComboBox;

  private JFrame parentFrame;

  public HomePage(JFrame parentFrame) {
    this.parentFrame = parentFrame;

    initializeHomePage();
  }

  private void initializeHomePage() {
    setLayout(new GridBagLayout());
    setBackground(Color.WHITE);

    addComponents();
  }

  private void addComponents() {
    addHeader();
    addArraySizeSection();
    addAlgorithmSelectionSection();
    addStartButton();
  }

  private void addHeader() {
    add(new HomePageHeader(), createConstraints(0, 0, 2));
  }

  private void addArraySizeSection() {
    arraySizeField = new ArraySizeField();

    add(new ArraySizeLabel(), createConstraints(0, 1));
    add(arraySizeField, createConstraints(1, 1));
  }

  private void addAlgorithmSelectionSection() {
    algorithmComboBox = new AlgorithmComboBox();
    
    add(new AlgorithmLabel(), createConstraints(0, 2));
    add(algorithmComboBox, createConstraints(1, 2));
  }

  private void addStartButton() {
    GenerateArrayButton generateArrayButton = new GenerateArrayButton();
    generateArrayButton.addGenerateArrayListener(e -> onGenerateButtonClicked());

    add(generateArrayButton, createConstraints(0, 3, 2));
  }

  private void onGenerateButtonClicked() {
    int arraySize = arraySizeField.getArraySize();
    String algorithm = String.valueOf(algorithmComboBox.getSelectedItem());
    System.out.println("chosen algorithm is: " + algorithm);
    sortDisplay = new SortDisplay(arraySize, algorithm, parentFrame);

    SwingUtilities.invokeLater(() -> {
      parentFrame.getContentPane().removeAll();
      parentFrame.getContentPane().add(sortDisplay);
      parentFrame.revalidate();
      parentFrame.repaint();
    });
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
