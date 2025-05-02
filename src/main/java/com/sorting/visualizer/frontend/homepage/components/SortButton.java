package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class SortButton extends JButton {
  public SortButton() {
    setText("Sort");
    setFont(new Font("SansSerif", Font.BOLD, 14));
  }
}