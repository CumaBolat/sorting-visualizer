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

  private int barWidth;
  private final int BAR_SPACING = 0;

  private JFrame parentFrame;

  public BarChartPanel(int size, JFrame parentFrame) {
    this.data = generateRandomArray(size);
    this.parentFrame = parentFrame;

    setBackground(Color.GRAY);
    setPreferredSize(new Dimension(750, 360)); // temp
    barWidth = calculateBarWidth(size);

    parentFrame.addComponentListener(new java.awt.event.ComponentAdapter() {
      @Override
      public void componentResized(java.awt.event.ComponentEvent e) {
        setSize(new Dimension(calculateWidth(), calculateHeight()));
        barWidth = calculateBarWidth(size);

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

    return (int) (totalHeight * 0.9);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (data == null || data.length == 0) {
      return;
    }

    int panelWidth = getWidth();
    int panelHeight = getHeight();
    int totalBarWidth = (barWidth + BAR_SPACING) * data.length;

    int startX = (panelWidth - totalBarWidth) / 2;

    for (int i = 0; i < data.length; i++) {
      int barHeight = (int) ((data[i] / (double) data.length) * (panelHeight - 20));
      int x = startX + i * (barWidth + BAR_SPACING);
      int y = panelHeight - barHeight - 10;

      g.setColor(i == highlightIndex ? highlightColor : barColor);
      g.fillRect(x, y, barWidth, barHeight);
      g.setColor(Color.BLACK);
      g.drawRect(x, y, barWidth, barHeight);
    }
  }

  private int calculateBarWidth(int size) {
    int panelWidth = calculateWidth();
    int totalSpacing = (size + 1) * BAR_SPACING;
    int availableWidth = panelWidth - totalSpacing;

    int calculatedWidth = availableWidth / size;

    int minBarWidth = 1;
    int maxBarWidth = 20;

    return Math.max(minBarWidth, Math.min(calculatedWidth, maxBarWidth));
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