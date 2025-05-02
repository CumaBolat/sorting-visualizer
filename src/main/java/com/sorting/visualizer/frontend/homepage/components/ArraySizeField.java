package com.sorting.visualizer.frontend.homepage.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class ArraySizeField extends JTextField {

  public ArraySizeField() {
    setBackground(Color.WHITE);
    setForeground(Color.DARK_GRAY);
    setFont(new Font("SansSerif", Font.PLAIN, 16));
    setToolTipText("Enter array size (e.g., 50)");

    setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
  }

  public int getArraySize() {
    return Integer.parseInt(getText());
  }
}
