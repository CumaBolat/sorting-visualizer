package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class HomePageHeader extends JLabel {
  public HomePageHeader() {
    setText("Sorting Algorithm Visualizer");
    setHorizontalAlignment(CENTER);
    setFont(new Font("SansSerif", Font.BOLD, 24));
    setForeground(new Color(40, 40, 40));
  }
}
