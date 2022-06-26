package view;

import dao.AluguelDAO;
import model.Aluguel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class BuscarAluguelView extends JFrame{
    private JTextField nomeClienteTextField;
    private JTextField placaVeiculoTextField;
    private JButton buscarButton;
    private JButton voltarButton;
    private JPanel pnlBuscarAluguel;

    public BuscarAluguelView(String title) {
        super(title);

        setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(pnlBuscarAluguel);
        this.pack();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*
                AluguelDAO dao = new AluguelDAO();
                Optional<Aluguel> aluguelOptional = dao.findById(2L);
                aluguelOptional.ifPresent(aluguel -> {
                    System.out.println("ID: " + aluguel.getId());
                    System.out.println("Nome do cliente: " + aluguel.getNomeCliente());
                    System.out.println("Identidade do cliente: " + aluguel.getIdentidadeCliente());
                    System.out.println("Endereço do cliente: " + aluguel.getEnderecoCliente());
                    System.out.println("Telefone do cliente: " + aluguel.getTelefoneCliente());
                    System.out.println("Modelo do veiculo: " + aluguel.getModeloVeiculo());
                    System.out.println("Placa do veículo: " + aluguel.getPlacaVeiculo());
                    System.out.println("Data de cadastro: " + aluguel.getData());
                });
                 */

                AluguelDAO dao = new AluguelDAO();
                Optional<Aluguel> aluguelOptionalName = dao.findByName(nomeClienteTextField.getText());
                Optional<Aluguel> aluguelOptionalPlaca = dao.findByPlacaVeiculo(placaVeiculoTextField.getText());

                if(aluguelOptionalPlaca.isPresent()) {
                    aluguelOptionalPlaca.ifPresent(aluguel -> {
                        System.out.println("ID: " + aluguel.getId());
                        System.out.println("Nome do cliente: " + aluguel.getNomeCliente());
                        System.out.println("Identidade do cliente: " + aluguel.getIdentidadeCliente());
                        System.out.println("Endereço do cliente: " + aluguel.getEnderecoCliente());
                        System.out.println("Telefone do cliente: " + aluguel.getTelefoneCliente());
                        System.out.println("Modelo do veiculo: " + aluguel.getModeloVeiculo());
                        System.out.println("Placa do veículo: " + aluguel.getPlacaVeiculo());
                        System.out.println("Data de cadastro: " + aluguel.getData());
                    });
                } else {
                    aluguelOptionalName.ifPresent(aluguel -> {
                        System.out.println("ID: " + aluguel.getId());
                        System.out.println("Nome do cliente: " + aluguel.getNomeCliente());
                        System.out.println("Identidade do cliente: " + aluguel.getIdentidadeCliente());
                        System.out.println("Endereço do cliente: " + aluguel.getEnderecoCliente());
                        System.out.println("Telefone do cliente: " + aluguel.getTelefoneCliente());
                        System.out.println("Modelo do veiculo: " + aluguel.getModeloVeiculo());
                        System.out.println("Placa do veículo: " + aluguel.getPlacaVeiculo());
                        System.out.println("Data de cadastro: " + aluguel.getData());
                    });
                }
            }
        });
    }
}
