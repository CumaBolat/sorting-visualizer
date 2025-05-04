package com.sorting.visualizer.frontend.sortdisplay.components;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.sorting.visualizer.frontend.homepage.HomePage;

public class ReturnButton extends JButton {
  private final String RETURN_HOME = "Return Home";

  private JFrame parentFrame;
  private HomePage homePage;

  public ReturnButton(JFrame parentFrame) {
    this.parentFrame = parentFrame;

    initializeReturnButton();
  }

  private void initializeReturnButton() {
    setText(RETURN_HOME);
    setBackground(Color.BLACK);
    setForeground(Color.WHITE);

    addSortEventListener(e -> onReturnButtonClicked());
  }

  private void addSortEventListener(ActionListener listener) {
    addActionListener(listener);
  }

  private void onReturnButtonClicked() {
    homePage = new HomePage(parentFrame);

    SwingUtilities.invokeLater(() -> {
      parentFrame.getContentPane().removeAll();
      parentFrame.getContentPane().add(homePage);
      parentFrame.revalidate();
      parentFrame.repaint();
    });
  }
}
