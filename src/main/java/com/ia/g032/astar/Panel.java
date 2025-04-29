package com.ia.g032.astar;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel {
    final int cols = 15;
    final int rows = 15;
    final int nodeSize = 50;
    final int screenWidth = nodeSize * cols;
    final int screenHeight = nodeSize * rows;
    int count = 0;

    Node[][] node = new Node[cols][rows];
    Node startNode;
    Node finalNode;
    Node currentNode;
    ArrayList<Node> openNodes = new ArrayList<>();
    ArrayList<Node> wallNodes = new ArrayList<>();

    boolean goalReached = false;

    public Panel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(rows, cols));
        this.addKeyListener(new KeyHandler(this));
        setFocusable(true);

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

        nodeCosts();
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
        wallNodes.add(node[col][row]);
    }

    private void nodeCosts() {
        int col = 0;
        int row = 0;

        while(col < cols && row < rows) {
            fCost(node[col][row]);
            col++;

            if(col == cols) {
                col = 0;
                row++;
            }
        }
    }

    private void fCost(Node node) {
        int x = Math.abs(node.col - startNode.col);
        int y = Math.abs(node.row - startNode.row);
        node.g = x + y; //g (Distance from start node to current node)

        x = Math.abs(node.col - finalNode.col);
        y = Math.abs(node.row - finalNode.row);
        node.h = x + y; //heuristic (Distance from current node to goal node)

        node.f = node.g + node.h; //f (Total estimated cost)

        if(node != startNode && node != finalNode && (!wallNodes.contains(node))) {
            node.setText("<html>f: " + node.f + "<br>g: " + node.g + "</html>");
        }
    }

    public void search() {
        while(goalReached == false && count <= 1000) {
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.closeNode();
            openNodes.remove(currentNode);

            if(row - 1 >= 0) open(node[col][row - 1]);
            if(col - 1 >= 0) open(node[col - 1][row]);
            if(row + 1 < rows) open(node[col][row + 1]);
            if(col + 1 < cols) open(node[col + 1][row]);

            int bestIndex = 0;
            int bestfCost = 999;

            for(int i = 0; i < openNodes.size(); i++) {
                if(openNodes.get(i).f < bestfCost) {
                    bestIndex = i;
                    bestfCost = openNodes.get(i).f;
                }

                else if(openNodes.get(i).f == bestfCost) {
                    if(openNodes.get(i).g < openNodes.get(bestIndex).g) {
                        bestIndex = i;

                    }  
                }
            }

            currentNode = openNodes.get(bestIndex);

            if(currentNode == finalNode) {
                goalReached = true;
                path();
            }

            count++;
        }
    }

    private void open(Node node) {
        if(node.open == false && node.close == false && node.wall == false) {
            node.openNode();
            node.parent = currentNode;
            openNodes.add(node);
        }
    }

    private void path() {
        Node current = finalNode;

        while(current != startNode) {
            current = current.parent;

            if(current != startNode) current.path();
        }
    }
}
