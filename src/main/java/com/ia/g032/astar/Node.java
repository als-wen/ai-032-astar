package com.ia.g032.astar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JButton;

public class Node extends JButton implements ActionListener {

    Node parent;
    int col;
    int row;
    int g;
    int h;
    int f;
    boolean start;
    boolean goal;
    boolean wall;
    boolean open;
    boolean close;

    public Node(int col, int row) {
        this.col = col;
        this.row = row;
        setBackground(Color.white);
        setForeground(Color.black);
        setOpaque(true);
        addActionListener(this);
    }

    public void start() {
        setBackground(Color.cyan);
        setForeground(Color.white);
        start = true;
    }

    public void goal() {
        setBackground(Color.blue);
        setForeground(Color.white);
        goal = true;
    }

    public void wall() {
        setBackground(Color.black);
        setForeground(Color.black);
        wall = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.yellow);
    }

}
