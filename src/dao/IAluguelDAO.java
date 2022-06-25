package dao;

import model.Aluguel;

import java.util.List;
import java.util.Optional;

public interface IAluguelDAO {
    Aluguel save(Aluguel aluguel);
    Aluguel update(Aluguel aluguel);
    void delete(Aluguel aluguel);
    List<Aluguel> findAll();
    Optional<Aluguel>findById(Long id);
}
