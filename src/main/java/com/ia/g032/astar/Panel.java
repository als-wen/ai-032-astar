package com.ia.g032.astar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel {
    final int cols = 15;
    final int rows = 15;
    final int nodeSize = 50;
    final int screenWidth = nodeSize * cols;
    final int screenHeight = nodeSize * rows;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(rows, cols));
    }
}
