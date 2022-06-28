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


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            aluguel.setId(generatedId);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        return aluguel;
    }

    @Override
    public Aluguel update(Aluguel aluguel) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE alugueis SET nomeCliente = ?, identidadeCliente = ?, enderecoCliente = ?, telefoneCliente = ?, modeloVeiculo = ?, placaVeiculo = ?, data = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, aluguel.getNomeCliente());
            preparedStatement.setString(2, aluguel.getIdentidadeCliente());
            preparedStatement.setString(3, aluguel.getEnderecoCliente());
            preparedStatement.setString(4, aluguel.getTelefoneCliente());
            preparedStatement.setString(5, aluguel.getModeloVeiculo());
            preparedStatement.setString(6, aluguel.getPlacaVeiculo());
            preparedStatement.setDate(7, java.sql.Date.valueOf(aluguel.getData()));
            preparedStatement.setLong(8, aluguel.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return aluguel;
    }

    @Override
    public void delete(Aluguel aluguel) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM alugueis WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, aluguel.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
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

                Aluguel aluguel = new Aluguel(id, nomeCliente, identidadeCliente, enderecocliente, telefoneCliente, data, placaVeiculo, modeloVeiculo);
                alugueis.add(aluguel);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return alugueis;
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        String sql = "SELECT id, nomeCliente, identidadeCliente, enderecoCliente, telefoneCliente, modeloVeiculo, placaVeiculo, data FROM alugueis WHERE id = ?";

        Aluguel aluguel = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("id");
                String nomeCliente = rs.getString("nomeCliente");
                String identidadeCliente = rs.getString("identidadeCliente");
                String enderecocliente = rs.getString("enderecocliente");
                String telefoneCliente = rs.getString("telefoneCliente");
                String modeloVeiculo = rs.getString("modeloVeiculo");
                String placaVeiculo = rs.getString("placaVeiculo");
                LocalDate data = rs.getDate("data").toLocalDate();

                aluguel = new Aluguel(pKey, nomeCliente, identidadeCliente, enderecocliente, telefoneCliente, data, placaVeiculo, modeloVeiculo);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(aluguel);
    }

    public Optional<Aluguel> findByName(String nomeCliente) {
        String sql = "SELECT id, nomeCliente, identidadeCliente, enderecoCliente, telefoneCliente, modeloVeiculo, placaVeiculo, data FROM alugueis WHERE nomeCliente = ?";

        Aluguel aluguel = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nomeCliente);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String cliNome = rs.getString("nomeCliente");
                String identidadeCliente = rs.getString("identidadeCliente");
                String enderecocliente = rs.getString("enderecocliente");
                String telefoneCliente = rs.getString("telefoneCliente");
                String modeloVeiculo = rs.getString("modeloVeiculo");
                String placaVeiculo = rs.getString("placaVeiculo");
                LocalDate data = rs.getDate("data").toLocalDate();

                aluguel = new Aluguel(id, nomeCliente, identidadeCliente, enderecocliente, telefoneCliente, data, placaVeiculo, modeloVeiculo);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(aluguel);
    }

    public Optional<Aluguel> findByPlacaVeiculo(String placaVeiculo) {
        String sql = "SELECT id, nomeCliente, identidadeCliente, enderecoCliente, telefoneCliente, modeloVeiculo, placaVeiculo, data FROM alugueis WHERE nomeCliente = ?";

        Aluguel aluguel = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, placaVeiculo);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nomeCliente = rs.getString("nomeCliente");
                String identidadeCliente = rs.getString("identidadeCliente");
                String enderecocliente = rs.getString("enderecocliente");
                String telefoneCliente = rs.getString("telefoneCliente");
                String modeloVeiculo = rs.getString("modeloVeiculo");
                String placaVeic = rs.getString("placaVeiculo");
                LocalDate data = rs.getDate("data").toLocalDate();

                aluguel = new Aluguel(id, nomeCliente, identidadeCliente, enderecocliente, telefoneCliente, data, placaVeiculo, modeloVeiculo);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(aluguel);
    }

}