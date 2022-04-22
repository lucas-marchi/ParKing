package view;

import javax.swing.*;

public class HomeView extends JFrame {
    private JButton novoAluguelButton;
    private JPanel panelHome;
    private JButton buscarAluguelButton;
    private JButton visãoGeralButton;

    public HomeView(String title) {
            super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelHome);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame homeFrame = new HomeView("Home");
        homeFrame.setVisible(true);
    }
}
