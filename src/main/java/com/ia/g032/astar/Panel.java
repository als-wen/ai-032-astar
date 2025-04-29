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

    Node[][] node = new Node[cols][rows];
    Node startNode;
    Node finalNode;
    Node currentNode;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(rows, cols));

        int col = 0;
        int row = 0;

        while(col < cols && row < rows) {
            node[col][row] = new Node(col, row);
            this.add(node[col][row]);

            col++;
            if(col == cols) {
                col = 0;
                row++;
            }
        } 

        startNode(2, 3);
        finalNode(11, 9);

        for(int i = 7; i < 11; i++) {
            wallNode(10, i);
        }
        wallNode(11,7);
        wallNode(12,7);
    }

    private void startNode(int col, int row) {
        node[col][row].start();
        startNode = node[col][row];
        currentNode = startNode;
    }

    private void finalNode(int col, int row) {
        node[col][row].goal();
        finalNode = node[col][row];
    }

    private void wallNode(int col, int row) {
        node[col][row].wall();
    }
}
