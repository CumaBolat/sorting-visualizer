package com.sorting.visualizer.frontend;

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
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }

  private void initializeHomePage() {
    HomePage homePage = new HomePage();

    add(homePage);
  }
}
