package com.sorting.visualizer.backend.algorithms.strategies;

import com.sorting.visualizer.frontend.sortdisplay.BarChartPanel;

public interface Algorithm {
  public void sort(BarChartPanel panel, int[] arr);
}
