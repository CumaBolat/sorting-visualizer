package com.sorting.visualizer.backend.algorithms.strategies.impl;

import com.sorting.visualizer.backend.algorithms.strategies.Algorithm;
import com.sorting.visualizer.frontend.sortdisplay.BarChartPanel;

public class BubbleSort implements Algorithm {
  private BarChartPanel barChartPanel;

  @Override
  public void sort(BarChartPanel barChartPanel, int[] arr) {
    this.barChartPanel = barChartPanel;

    new Thread(() -> {
      try {
        bubbleSort(arr);
        bubbleSort(arr);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
  }

  private void bubbleSort(int[] arr) throws InterruptedException {
    int n = arr.length;
    boolean swapped;

    for (int i = 0; i < n - 1; i++) {
      swapped = false;

      for (int j = 0; j < n - 1 - i; j++) {
        barChartPanel.setHighlight(j + 1, j);
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];

          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          swapped = true;
        }
        barChartPanel.setData(arr);
        Thread.sleep(1);
      }

      if (!swapped)
        break;
    }
  }
}
