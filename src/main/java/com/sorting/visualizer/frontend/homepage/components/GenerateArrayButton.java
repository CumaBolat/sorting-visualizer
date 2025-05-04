package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GenerateArrayButton extends JButton {
  public GenerateArrayButton(String text) {
    setText(text);
    setFont(new Font("SansSerif", Font.BOLD, 14));
  }

  public void addGenerateArrayListener(ActionListener listener) {
    addActionListener(listener);
  }
}