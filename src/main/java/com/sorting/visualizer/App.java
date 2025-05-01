package com.sorting.visualizer;

import javax.swing.SwingUtilities;

import com.sorting.visualizer.frontend.SortingVisualizer;

public class App {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SortingVisualizer app = new SortingVisualizer();
      app.setVisible(true);
    });
  }
}
