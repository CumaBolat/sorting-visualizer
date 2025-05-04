package com.sorting.visualizer.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.sorting.visualizer.frontend.homepage.HomePage;

public class SortingVisualizer extends JFrame {
  public SortingVisualizer() {
    initializeFrame();

    initializeHomePage();
  }

  private void initializeFrame() {
    setTitle("Sorting Algorithm Visualizer");
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setMinimumSize(new Dimension(800,600));
    setBackground(new Color(224, 224, 224));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
  }

  private void initializeHomePage() {
    HomePage homePage = new HomePage(this);

    add(homePage);
  }
}
