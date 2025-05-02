package com.sorting.visualizer.frontend.sortdisplay;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.awt.Dimension;

public class BarChartPanel extends JPanel {

  private int[] data;
  private Color barColor = Color.BLUE;
  private Color highlightColor = Color.RED;
  private int highlightIndex = -1;

  private final int BAR_WIDTH;
  private final int BAR_SPACING = 1;

  private JFrame parentFrame;

  public BarChartPanel(int size, JFrame parentFrame) {
    this.data = generateRandomArray(size);
    this.BAR_WIDTH = calculateBarWidth(size);
    this.parentFrame = parentFrame;

    setPreferredSize(new Dimension(750, 360)); // temp

    parentFrame.addComponentListener(new java.awt.event.ComponentAdapter() {
      @Override
      public void componentResized(java.awt.event.ComponentEvent e) {
        setSize(new Dimension(calculateWidth(), calculateHeight()));
        revalidate();
        repaint();
      }
    });
  }

  public void setData(int[] newData) {
    this.data = newData;
    setPreferredSize(new Dimension(calculateWidth(), calculateHeight()));
    repaint();
  }

  public void setHighlight(int index) {
    this.highlightIndex = index;
    repaint();
  }

  public void setBarColor(Color color) {
    this.barColor = color;
    repaint();
  }

  public void setHighlightColor(Color color) {
    this.highlightColor = color;
    repaint();
  }

  private int calculateWidth() {
    int totalWidth = parentFrame.getContentPane().getWidth();

    return totalWidth;
  }

  private int calculateHeight() {
    int totalHeight = parentFrame.getContentPane().getHeight();

    return (int) (totalHeight * 0.6);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (data == null || data.length == 0) {
      return;
    }

    int panelHeight = getHeight();
    int x = BAR_SPACING;

    for (int i = 0; i < data.length; i++) {
      int barHeight = data[i];
      int y = panelHeight - barHeight - 10;

      Color currentColor = (i == highlightIndex) ? highlightColor : barColor;
      g.setColor(currentColor);
      g.fillRect(x, y, BAR_WIDTH, barHeight);

      g.setColor(Color.BLACK);
      g.drawRect(x, y, BAR_WIDTH, barHeight);

      x += BAR_WIDTH + BAR_SPACING;
    }
  }

  private int calculateBarWidth(int size) {
    return 5;
  }

  private int calculateBarHeight(int size) {
    return 10;
  }

  private int[] generateRandomArray(int size) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= size; i++) {
      numbers.add(i);
    }

    Collections.shuffle(numbers, new Random());

    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = numbers.get(i);
    }

    return arr;
  }
}