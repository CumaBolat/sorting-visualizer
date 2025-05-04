package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Font;

import javax.swing.JLabel;

public class AlgorithmLabel extends JLabel{
  private final String ALGORITHM_LABEL_TEXT = "Please Choose the Algorithm You Want to Visualize";
  
  public AlgorithmLabel() {
    initializeAlgorithmLable();    
  }

  private void initializeAlgorithmLable() {
    setText(ALGORITHM_LABEL_TEXT);
    setFont(new Font("SansSerif", Font.PLAIN, 16));
  }
}
