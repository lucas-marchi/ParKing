package view;

import dao.AluguelDAO;
import model.Aluguel;

import java.time.LocalDate;
import java.util.Optional;

public class AtualizarAluguel {

    public static void main(String[] args) {

        AluguelDAO dao = new AluguelDAO();
        Optional<Aluguel> aluguelOptional = dao.findById(3L);

        Aluguel aluguel = aluguelOptional.get();
        System.out.println(aluguel.getId());
        System.out.println(aluguel.getNomeCliente());
        System.out.println(aluguel.getIdentidadeCliente());
        System.out.println(aluguel.getEnderecoCliente());
        System.out.println(aluguel.getTelefoneCliente());
        System.out.println(aluguel.getModeloVeiculo());
        System.out.println(aluguel.getPlacaVeiculo());
        System.out.println(aluguel.getData());

        aluguel.setNomeCliente("teste atualizar");
        aluguel.setIdentidadeCliente("teste atualizar");
        aluguel.setEnderecoCliente("teste atualizar");
        aluguel.setTelefoneCliente("teste atualizar");
        aluguel.setModeloVeiculo("teste atualizar");
        aluguel.setPlacaVeiculo("teste atualizar");
        aluguel.setData(LocalDate.now());

        dao.update(aluguel);
    }
}
