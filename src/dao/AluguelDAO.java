package dao;

import infra.ConnectionFactory;
import model.Aluguel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AluguelDAO implements IAluguelDAO{
    @Override
    public Aluguel save(Aluguel aluguel) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = ("INSERT INTO alugueis (nomeCliente, identidadeCliente, enderecoCliente, telefoneCliente, modeloVeiculo, placaVeiculo, data) " +
                          "VALUES  (?, ?, ?, ?, ?, ?, ?)");

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, aluguel.getNomeCliente());
            preparedStatement.setString(2, aluguel.getIdentidadeCliente());
            preparedStatement.setString(3, aluguel.getEnderecoCliente());
            preparedStatement.setString(4, aluguel.getTelefoneCliente());
            preparedStatement.setString(5, aluguel.getModeloVeiculo());
            preparedStatement.setString(6, aluguel.getPlacaVeiculo());
            preparedStatement.setDate(7, java.sql.Date.valueOf(aluguel.getData()));

            preparedStatement.executeUpdate();

            /*
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            aluguel.setId(generatedId);
             */

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        return aluguel;
    }

    @Override
    public Aluguel update(Aluguel aluguel) {
        return null;
    }

    @Override
    public void delete(Aluguel aluguel) {

    }

    @Override
    public List<Aluguel> findAll() {
        String sql = "SELECT id, nomeCliente, identidadeCliente, enderecoCliente, telefoneCliente, modeloVeiculo, placaVeiculo, data FROM alugueis";

        List<Aluguel> alugueis = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nomeCliente = rs.getString("nomeCliente");
                String identidadeCliente = rs.getString("identidadeCliente");
                String enderecocliente = rs.getString("enderecocliente");
                String telefoneCliente = rs.getString("telefoneCliente");
                String modeloVeiculo = rs.getString("modeloVeiculo");
                String placaVeiculo = rs.getString("placaVeiculo");
                LocalDate data = rs.getDate("data").toLocalDate();
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return alugueis;
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        return Optional.empty();
    }
}