package com.sorting.visualizer.frontend.sortdisplay.components;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

import javax.swing.JButton;

public class SortButton extends JButton {
  public SortButton() {
    setText("SORT");
    setForeground(Color.WHITE);
    setBackground(Color.BLACK);

    addSortEventListener(e -> onSortButtonClicked());
  }

  private void addSortEventListener(ActionListener listener) {
    addActionListener(listener);
  }

  private void onSortButtonClicked() {
    System.out.println("Start Sort");
  }
}
