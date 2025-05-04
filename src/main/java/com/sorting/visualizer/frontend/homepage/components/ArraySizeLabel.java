package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Font;

import javax.swing.JLabel;

public class ArraySizeLabel extends JLabel{
  public ArraySizeLabel() {
    initializeArraySizeLable();
  }

  private void initializeArraySizeLable() {
    setText("Please Enter Array Size");
    setFont(new Font("SansSerif", Font.PLAIN, 16));
  }
}
