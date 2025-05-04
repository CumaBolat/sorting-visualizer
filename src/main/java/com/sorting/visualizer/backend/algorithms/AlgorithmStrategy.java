package com.sorting.visualizer.backend.algorithms;

import com.sorting.visualizer.backend.algorithms.strategies.Algorithm;
import com.sorting.visualizer.backend.algorithms.strategies.impl.BubbleSort;

public class AlgorithmStrategy {
  public Algorithm chooseAlgorithm(String algorithm) {
    return switch(algorithm) {
      case "Bubble Sort" -> new BubbleSort();
      default -> null; 
  };
  }
}
