package com.sorting.visualizer.backend;

import com.sorting.visualizer.backend.algorithms.AlgorithmStrategy;
import com.sorting.visualizer.backend.algorithms.strategies.Algorithm;
import com.sorting.visualizer.frontend.sortdisplay.BarChartPanel;

public class Sort {
  private AlgorithmStrategy algorithmStrategy = new AlgorithmStrategy();

  public void sort(BarChartPanel panel, int[] array, String algorithm) {
    System.out.println("algorithm: " + algorithm);
    Algorithm chosenAlgorithm = algorithmStrategy.chooseAlgorithm(algorithm);

    chosenAlgorithm.sort(panel, array);
  } 
}
