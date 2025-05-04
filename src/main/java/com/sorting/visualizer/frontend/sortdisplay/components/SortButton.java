package com.sorting.visualizer.frontend.sortdisplay.components;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.sorting.visualizer.backend.Sort;
import com.sorting.visualizer.frontend.sortdisplay.BarChartPanel;

public class SortButton extends JButton {
  private BarChartPanel barChartPanel;
  
  private Sort sort = new Sort();

  private int[] array;
  private String algorithm;
  
  public SortButton(BarChartPanel barChartPanel, int[] array, String algorithm) {
    this.barChartPanel = barChartPanel;
    this.array = array;
    this.algorithm = algorithm;

    initializeSortButton();
  }

  private void initializeSortButton() {
    setText("SORT");
    setForeground(Color.WHITE);
    setBackground(Color.BLACK);

    addSortEventListener(e -> onSortButtonClicked());
  }

  private void addSortEventListener(ActionListener listener) {
    addActionListener(listener);
  }

  private void onSortButtonClicked() {
    sort.sort(barChartPanel, array, algorithm);
  }
}
