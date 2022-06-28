package view;

import dao.AluguelDAO;
import model.Aluguel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NovoAluguelView extends JFrame{
    private JTextField nomeTextField;
    private JTextField modeloTextField;
    private JTextField identidadeTextField;
    private JTextField placaTextField;
    private JTextField endereçoTextField;
    private JTextField telefoneTextField;
    private JButton realizarAluguelButton;
    private JButton voltarButton;
    private JPanel pnlNovoAluguel;

    public NovoAluguelView(String title) {
        super(title);

        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(pnlNovoAluguel);
        this.pack();

        createConnection();
        realizarAluguelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AluguelDAO dao = new AluguelDAO();
                Aluguel aluguel = new Aluguel();

                aluguel.setId(null);
                aluguel.setNomeCliente(nomeTextField.getText());
                aluguel.setIdentidadeCliente(identidadeTextField.getText());
                aluguel.setEnderecoCliente(endereçoTextField.getText());
                aluguel.setTelefoneCliente(telefoneTextField.getText());
                aluguel.setModeloVeiculo(modeloTextField.getText());
                aluguel.setPlacaVeiculo(placaTextField.getText());
                aluguel.setData(LocalDate.now());

                dao.save(aluguel);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
    }

    Connection conn;
    void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ParKing", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new NovoAluguelView("ParKing's Systems");
        frame.setVisible(true);
    }

}
