package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends JFrame {
    private JButton novoAluguelButton;
    private JPanel panelHome;
    private JButton buscarAluguelButton;
    private JButton visãoGeralButton;

    public HomeView(String title) {
        super(title);

        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelHome);
        this.pack();
        novoAluguelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NovoAluguelView telaAluguel = new NovoAluguelView(title);
                telaAluguel.setVisible(true);
            }
        });
        buscarAluguelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarAluguelView telaBuscarAluguel = new BuscarAluguelView(title);
                telaBuscarAluguel.setVisible(true);
            }
        });
        visãoGeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisaoGeralView telaVisaoGeral = new VisaoGeralView(title);
                telaVisaoGeral.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame homeFrame = new HomeView("Home");
        homeFrame.setVisible(true);
    }
}
