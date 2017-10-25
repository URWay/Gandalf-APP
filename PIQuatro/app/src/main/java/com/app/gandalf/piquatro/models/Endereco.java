package com.app.gandalf.piquatro.models;

public class Endereco {
    private int idEndereco;
    private int idCliente;
    private String nomeEndereco;
    private String logradouroEndereco;
    private int numeroEndereco;
    private String CEPEndereco;
    private String complementoEndereco;
    private String cidadeEndereco;
    private String paisEndereo;
    private String UFEndereco;

    public Endereco(int idCliente, String nomeEndereco, String logradouroEndereco, int numeroEndereco, String CEPEndereco, String complementoEndereco, String cidadeEndereco, String paisEndereo, String UFEndereco) {
        this.idCliente = idCliente;
        this.nomeEndereco = nomeEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.CEPEndereco = CEPEndereco;
        this.complementoEndereco = complementoEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.paisEndereo = paisEndereo;
        this.UFEndereco = UFEndereco;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCEPEndereco() {
        return CEPEndereco;
    }

    public void setCEPEndereco(String CEPEndereco) {
        this.CEPEndereco = CEPEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getPaisEndereo() {
        return paisEndereo;
    }

    public void setPaisEndereo(String paisEndereo) {
        this.paisEndereo = paisEndereo;
    }

    public String getUFEndereco() {
        return UFEndereco;
    }

    public void setUFEndereco(String UFEndereco) {
        this.UFEndereco = UFEndereco;
    }

}
