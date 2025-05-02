package com.sorting.visualizer.frontend;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.sorting.visualizer.frontend.homepage.HomePage;

public class SortingVisualizer extends JFrame {
  public SortingVisualizer() {
    initializeFrame();

    initializeHomePage();
  }

  private void initializeFrame() {
    setTitle("Sorting Algorithm Visualizer");
    setSize(800, 600);
    setBackground(new Color(224, 224, 224));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    add(new HomePage(), BorderLayout.CENTER);
  }

  private void initializeHomePage() {
    HomePage homePage = new HomePage();

    add(homePage);
  }
}
