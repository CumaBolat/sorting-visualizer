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
    
    //setAlignmentX(CENTER_ALIGNMENT);
    //setPreferredSize(new Dimension(200, 30));
    //setMaximumSize(new Dimension(200, 30));
    //setHorizontalAlignment(JTextField.CENTER);
    
    setToolTipText("Enter array size (e.g., 50)");

    setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
  }
}
