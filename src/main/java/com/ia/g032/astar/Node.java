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
    boolean solid;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.orange);
    }

}
