package com.sorting.visualizer.frontend.sortdisplay;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class BarChartPanel extends JPanel {

  private int[] data;
  private int size;
  private Color barColor = Color.BLACK;
  private Color highlightColor = Color.RED;
  private int highlightIndex = -1;
  private int highlight2Index = -1;

  private int barWidth;
  private final int BAR_SPACING = 0;

  private JFrame parentFrame;

  public BarChartPanel(int[] data, JFrame parentFrame) {
    this.data = data;
    this.size = data.length;
    this.parentFrame = parentFrame;

    initializeBarChartPanel();
  }

  private void initializeBarChartPanel() {
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

  public void setHighlight(int index, int index2) {
    this.highlightIndex = index;
    this.highlight2Index = index2;
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

    return (int) (totalHeight * 0.8);
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

      g.setColor((i == highlightIndex || i == highlight2Index) ? highlightColor : barColor);
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
}