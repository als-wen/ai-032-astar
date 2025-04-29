package com.ia.g032.astar;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("A* Pathfinding");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new Panel());

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
