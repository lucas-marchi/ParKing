package model;

import java.time.LocalDate;

public class Aluguel {
    private Long id;
    private String nomeCliente;
    private String identidadeCliente;
    private String enderecoCliente;
    private String telefoneCliente;
    private LocalDate data;

    private String modeloVeiculo;
    private String placaVeiculo;

    public Aluguel(Long id, String nomeCliente, String identidadeCliente, String enderecoCliente, String telefoneCliente, LocalDate data, String modeloVeiculo, String placaVeiculo) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.identidadeCliente = identidadeCliente;
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;
        this.data = data;
        this.modeloVeiculo = modeloVeiculo;
        this.placaVeiculo = placaVeiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getIdentidadeCliente() {
        return identidadeCliente;
    }

    public void setIdentidadeCliente(String identidadeCliente) {
        this.identidadeCliente = identidadeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}
