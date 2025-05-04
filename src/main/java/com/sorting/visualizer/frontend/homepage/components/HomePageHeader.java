package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class HomePageHeader extends JLabel {
  private final String HOME_PAGE_HEADER = "Sorting Algorithm Visualizer";

  public HomePageHeader() {
    initializeHomePageHeader();
  }

  private void initializeHomePageHeader() {
    setText(HOME_PAGE_HEADER);
    setHorizontalAlignment(CENTER);
    setFont(new Font("SansSerif", Font.BOLD, 24));
    setForeground(new Color(40, 40, 40));
  }
}
