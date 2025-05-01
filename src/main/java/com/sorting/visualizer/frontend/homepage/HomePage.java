package com.sorting.visualizer.frontend.homepage;

import javax.swing.JPanel;

import com.sorting.visualizer.frontend.homepage.components.AlgorithmComboBox;
import com.sorting.visualizer.frontend.homepage.components.ArraySizeField;
import com.sorting.visualizer.frontend.homepage.components.ArraySizeLabel;
import com.sorting.visualizer.frontend.homepage.components.StartSortButton;

public class HomePage extends JPanel {
  public HomePage() {
    initializeHomePage();
  }

  private void initializeHomePage() {
    addArraySizeLabel();
    addArraySizeField();
    addAlgorithmBox();
    addStartButton();
  }

  private void addArraySizeLabel() {
    ArraySizeLabel arraySizeLabel = new ArraySizeLabel();

    add(arraySizeLabel);
  }

  private void addArraySizeField() {
    ArraySizeField arraySizeField = new ArraySizeField();

    add(arraySizeField);
  }

  private void addAlgorithmBox() {
    AlgorithmComboBox algorithmComboBox = new AlgorithmComboBox();

    add(algorithmComboBox);
  }

  private void addStartButton() {
    StartSortButton startSortButton = new StartSortButton();

    add(startSortButton);
  }
}
