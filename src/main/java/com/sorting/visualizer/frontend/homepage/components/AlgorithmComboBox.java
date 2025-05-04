package com.sorting.visualizer.frontend.homepage.components;

import javax.swing.JComboBox;

public class AlgorithmComboBox extends JComboBox<String> {
  public AlgorithmComboBox() {
    initializeAlgorithmComboBox();
  }

  private void initializeAlgorithmComboBox() {
    addItem("Merge Sort");
    addItem("Bubble Sort");
  }
}
