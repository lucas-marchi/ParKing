package view;

import dao.AluguelDAO;
import model.Aluguel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HomeView extends JFrame {
    private JButton novoAluguelButton;
    private JPanel panelHome;
    private JButton buscarAluguelButton;
    private JButton visãoGeralButton;

    public HomeView(String title) {
        super(title);

        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(450, 474));

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
        visãoGeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AluguelDAO dao = new AluguelDAO();
                List<Aluguel> alugueis = dao.findAll();

                for (Aluguel aluguel : alugueis) {
                    System.out.println("ID: " + aluguel.getId());
                    System.out.println("Nome do cliente: " + aluguel.getNomeCliente());
                    System.out.println("Identidade do cliente: " + aluguel.getIdentidadeCliente());
                    System.out.println("Endereço do cliente: " + aluguel.getEnderecoCliente());
                    System.out.println("Telefone do cliente: " + aluguel.getTelefoneCliente());
                    System.out.println("Modelo do veiculo: " + aluguel.getModeloVeiculo());
                    System.out.println("Placa do veículo: " + aluguel.getPlacaVeiculo());
                    System.out.println("Data de cadastro: " + aluguel.getData());
                    System.out.println("--------------------------------------");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame homeFrame = new HomeView("Home");
        homeFrame.setVisible(true);
    }
}
